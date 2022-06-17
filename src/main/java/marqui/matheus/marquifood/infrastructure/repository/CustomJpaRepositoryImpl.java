package marqui.matheus.marquifood.infrastructure.repository;

import marqui.matheus.marquifood.domain.exception.EntidadeNaoEncontradaException;
import marqui.matheus.marquifood.domain.repository.CustomJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomJpaRepository<T, ID> {

    private final EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.manager = entityManager;
    }

    @Override
    public Optional<T> buscarPrimeiro() {
        String jpql = "from %s".formatted(getDomainClass().getName());

        T entity = manager.createQuery(jpql, getDomainClass())
                .setMaxResults(1)
                .getSingleResult();

        return Optional.ofNullable(entity);
    }

    @Override
    public T buscaSeguraPorId(ID id) {
        Class<T> entityClass = getDomainClass();
        try{
            T entity = manager.createQuery("from %s where %s = :id".formatted(
                    entityClass.getName(),
                    Arrays.stream(entityClass.getDeclaredFields())
                            .filter(field -> field.isAnnotationPresent(Id.class)).findFirst().get().getName()
            ), entityClass).setParameter("id", id).getSingleResult();

            return entity;
        }catch (NoResultException | NoSuchElementException | NullPointerException e) {
            throw new EntidadeNaoEncontradaException("%s de código %s não existe.".formatted(entityClass.getSimpleName(), id.toString()));
        }
    }
}
