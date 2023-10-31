package com.searchtecnologia.recurso.service.resultado.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResultadoSalvoDTO(
        String codigoResultado,
        String descricao,
        String tipoJulgamento,
        String tipoRecurso,
        String ativo
) {
}
