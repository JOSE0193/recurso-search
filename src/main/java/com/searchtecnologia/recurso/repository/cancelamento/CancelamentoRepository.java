package com.searchtecnologia.recurso.repository.cancelamento;

import com.searchtecnologia.recurso.model.cancelamento.CancelamentoMulta;
import com.searchtecnologia.recurso.model.cancelamento.CancelamentoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CancelamentoRepository extends JpaRepository<CancelamentoMulta, CancelamentoPK>,
        JpaSpecificationExecutor<CancelamentoMulta> {
}
