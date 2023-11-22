package com.searchtecnologia.recurso.service.cancelamento.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)

public record CancelamentoDTO(
        String numeroAuto,
        String sequencial,
        OrgaoAutuador orgaoAutuador,
        String descricaoOrgao,
        String codigoMotivo,
        String descricaoMotivo,
        LocalDate dataOperacao,
        String observacao,
        String numeroProcesso,
        LocalDate dataProcesso,
        String matricula,
        LocalDate logData,
        LocalTime logHora,
        String operador,
        String funcao,
        String estacao,
        String uf,
        String motivoExclusao,
        String descricaoMotivoExclusao,
        String observacaoReativacao,
        LocalDate dataReativacao,
        LocalTime horaReativacao,
        String operadorReativacao,
        String estacaoReativacao,
        String funcaoReativacao

) {
}
