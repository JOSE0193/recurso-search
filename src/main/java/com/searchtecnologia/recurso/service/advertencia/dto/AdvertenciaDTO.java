package com.searchtecnologia.recurso.service.advertencia.dto;

import java.time.LocalDateTime;

public record AdvertenciaDTO(
        Long idAutorizacao,
        String numeroOficio,
        LocalDateTime data,
        Long idSessao,
        Long idServicoSistema,
        Long idOperador,
        String observacao,
        String operador,
        Long idAutoAutorizacao,
        String numeroMulta,
        String orgaoAutuador,
        String codigoInfracao
) {
}
