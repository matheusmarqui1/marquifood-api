package marqui.matheus.marquifood.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import marqui.matheus.marquifood.domain.model.Restaurante;
import marqui.matheus.marquifood.domain.repository.CustomizedRestauranteRepositoryQueries;
import marqui.matheus.marquifood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static marqui.matheus.marquifood.infrastructure.repository.spec.RestauranteSpecifications.comFreteGratis;
import static marqui.matheus.marquifood.infrastructure.repository.spec.RestauranteSpecifications.comNomeSemelhante;

@Repository
public class RestauranteRepositoryImpl implements CustomizedRestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    @Lazy
    private RestauranteRepository restaurantes;

    @Override
    public List<Restaurante> findPersonalizado(String nome,
                                               BigDecimal taxaFreteInicial,
                                               BigDecimal taxaFreteFinal) {

        Set<Predicate> predicados = new HashSet<>();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);

        Root<Restaurante> root = criteria.from(Restaurante.class); //from Restaurante

        if(StringUtils.hasLength(nome)) {
            predicados.add(builder.like(root.get("nome"), "%"+nome+"%"));
        }

        if(taxaFreteInicial != null) {
            predicados.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }

        if(taxaFreteFinal != null) {
            predicados.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        criteria.where(predicados.toArray(new Predicate[predicados.size()]));

        TypedQuery<Restaurante> query = manager.createQuery(criteria);

        return query.getResultList();
    }

    @Override
    public List<Restaurante> findComFreteGratis(String nome) {
        return restaurantes.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
