package com.searchtecnologia.recurso.service.resultado.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResultadoDTO(
        String codigoResultado,
        String descricaoResultado,
        String tipoJulgamento,
        String tipoRecurso,
        String ativo,
        String orgaoAnalisador
) {
}