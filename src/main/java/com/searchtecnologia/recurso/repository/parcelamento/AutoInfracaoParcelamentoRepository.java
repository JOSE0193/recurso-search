package com.searchtecnologia.recurso.repository.parcelamento;

import com.searchtecnologia.recurso.model.parcelamento.AutoInfracaoParcelamento;
import com.searchtecnologia.recurso.model.parcelamento.AutoInfracaoParcelamentoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AutoInfracaoParcelamentoRepository extends
        JpaRepository<AutoInfracaoParcelamento, AutoInfracaoParcelamentoPK>,
        JpaSpecificationExecutor<AutoInfracaoParcelamento> {
}
