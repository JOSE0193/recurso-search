package com.searchtecnologia.recurso.service.relator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.searchtecnologia.recurso.model.resultado.DominioSimNao;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CadastroRelatorDTO(
        String codigoOrgao,
        String codigoJari,
        String codigo,
        String nome,
        String matricula,
        String ativo,
        String operador,
        String estacao,
        String funcao,
        String update
) {
}
