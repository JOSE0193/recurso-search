package com.searchtecnologia.recurso.service.recurso.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarRecursoItemDTO(
        @NotBlank(message = "numeroAuto deve ser informado")
        String numeroAuto,
        @NotBlank(message = "sequencialAuto deve ser informado")
        String sequencialAuto,
        @NotBlank(message = "placa deve ser informada")
        String placa
) {
}
