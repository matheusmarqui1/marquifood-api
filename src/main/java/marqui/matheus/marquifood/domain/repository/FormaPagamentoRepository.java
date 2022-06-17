package marqui.matheus.marquifood.domain.repository;

import marqui.matheus.marquifood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
