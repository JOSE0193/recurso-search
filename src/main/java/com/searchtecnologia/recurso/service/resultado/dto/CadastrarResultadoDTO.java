package com.searchtecnologia.recurso.service.resultado.dto;

public record CadastrarResultadoDTO(
        String codigoResultado,
        String descricao,
        String tipoJulgamento,
        String tipoRecurso,
        String ativo,
        String update
) {
}
