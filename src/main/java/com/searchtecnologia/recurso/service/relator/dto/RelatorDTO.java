package com.searchtecnologia.recurso.service.relator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RelatorDTO(
        String codigo,
        String nome,
        String matricula,
        String codigoJari,
        String descricaoJari,
        String orgaoAutuador,
        String ativo
) {
}