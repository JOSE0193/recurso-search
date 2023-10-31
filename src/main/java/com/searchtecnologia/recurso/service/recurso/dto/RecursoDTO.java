package com.searchtecnologia.recurso.service.recurso.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RecursoDTO(
        String numero
) {
}