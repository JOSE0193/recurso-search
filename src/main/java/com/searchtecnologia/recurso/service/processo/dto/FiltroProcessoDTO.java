package com.searchtecnologia.recurso.service.processo.dto;

public record FiltroProcessoDTO(
        String numeroProcesso,
        String numeroAuto,
        String placa,
        String situacao,
        String dataCadastro,
        String nomeRequerente,
        String orgaoAutuador
) {
}
