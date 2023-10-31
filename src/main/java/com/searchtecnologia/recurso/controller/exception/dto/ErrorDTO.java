package com.searchtecnologia.recurso.controller.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDTO(
        String message,
        List<String> details
) {
}
