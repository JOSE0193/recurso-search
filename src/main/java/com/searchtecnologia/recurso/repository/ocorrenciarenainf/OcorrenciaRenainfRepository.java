package com.searchtecnologia.recurso.repository.ocorrenciarenainf;

import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainfPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRenainfRepository extends JpaRepository<OcorrenciaRenainf, OcorrenciaRenainfPK>, JpaSpecificationExecutor<OcorrenciaRenainf> {
}
