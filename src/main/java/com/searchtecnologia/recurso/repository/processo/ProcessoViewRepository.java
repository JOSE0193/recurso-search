package com.searchtecnologia.recurso.repository.processo;

import com.searchtecnologia.recurso.model.processo.ProcessoView;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoViewRepository extends JpaRepository<ProcessoView, String> {

    Long countByCodigoOrgaoAndNumeroAutoAndSequencialAndRecursoViewTipoRecurso
            (String orgao, String numeroAuto, String sequencial, TipoRecurso tipoRecurso);

    Long countByCodigoRecursoAndResultadoTipoJulgamentoAndResultadoTipoRecurso(String numeroProcesso, String tipoJulgamento, String tipoRecurso);

}
