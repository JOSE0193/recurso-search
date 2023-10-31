package com.searchtecnologia.recurso.service.relator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.searchtecnologia.recurso.model.jari.TipoJari;
import com.searchtecnologia.recurso.model.resultado.SimNao;

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