package com.searchtecnologia.recurso.service.recurso;

import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.model.recurso.RecursoItem;
import com.searchtecnologia.recurso.service.recurso.dto.CadastrarRecursoItemDTO;

public interface RecursoItemService {

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_DEFESA.PRC_CADASTRAR_AUTO_RECURSO
     */
    RecursoItem criaItemRecurso(Recurso recurso, CadastrarRecursoItemDTO cadastrarRecursoItemDTO);
}
