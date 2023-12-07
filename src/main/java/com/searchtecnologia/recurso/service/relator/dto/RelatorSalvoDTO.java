package com.searchtecnologia.recurso.service.relator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RelatorSalvoDTO(
        String codigo,
        String matricula,
        String nome,
        String ativo,
        LocalDate dataCadastro,
        LocalTime horaCadastro,
        String operador,
        String estacao,
        String funcao,
        String codigoOrgao,
        String codigoJari
        ) {
}
