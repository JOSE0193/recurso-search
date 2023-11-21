package com.searchtecnologia.recurso.repository.processo;

import com.searchtecnologia.recurso.model.processo.Processo;
import com.searchtecnologia.recurso.model.processo.ProcessoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, ProcessoPK>, JpaSpecificationExecutor<Processo> {

}
