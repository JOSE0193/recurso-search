package com.searchtecnologia.recurso.service.recurso;

import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import com.searchtecnologia.recurso.service.recurso.dto.CadastrarRecursoDTO;
import com.searchtecnologia.recurso.service.recurso.dto.RecursoDTO;

import java.util.List;

public interface RecursoService {

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_DEFESA.PRC_CADASTRA_RECURSO_AUTUACAO
     */
    RecursoDTO cadastrarRecurso(CadastrarRecursoDTO cadastrarRecursoDTO);

//    String verificarAutoPossuiRecurso(String numeroAuto, String orgaoAutuador, String sequencial, String tipoRecurso);
//

}