package com.searchtecnologia.recurso.repository.infrator;

import com.searchtecnologia.recurso.model.infrator.HistoricoInfrator;
import com.searchtecnologia.recurso.model.infrator.HistoricoInfratorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HistoricoInfratorRepository extends JpaRepository<HistoricoInfrator, HistoricoInfratorPK>,
        JpaSpecificationExecutor<HistoricoInfrator> {

}
