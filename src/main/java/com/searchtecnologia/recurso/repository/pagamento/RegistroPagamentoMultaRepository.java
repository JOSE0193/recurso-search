package com.searchtecnologia.recurso.repository.pagamento;

import com.searchtecnologia.recurso.model.pagamento.RegistroPagamentoMulta;
import com.searchtecnologia.recurso.model.pagamento.RegistroPagamentoMultaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPagamentoMultaRepository extends JpaRepository<RegistroPagamentoMulta, RegistroPagamentoMultaPK>,
        JpaSpecificationExecutor<RegistroPagamentoMulta> {

}
