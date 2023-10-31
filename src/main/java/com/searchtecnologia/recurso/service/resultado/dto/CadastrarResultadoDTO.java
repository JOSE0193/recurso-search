package com.searchtecnologia.recurso.service.resultado.dto;

import com.searchtecnologia.recurso.model.resultado.SimNao;
import com.searchtecnologia.recurso.model.resultado.TipoJulgamentoResultado;
import com.searchtecnologia.recurso.model.resultado.TipoRecursoResultado;

public record CadastrarResultadoDTO(
        String codigoResultado,
        String descricao,
        String tipoJulgamento,
        String tipoRecurso,
        String ativo,
        String update
) {
}
