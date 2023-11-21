package com.searchtecnologia.recurso.service.processo.dto;


import com.searchtecnologia.recurso.model.recurso.TipoRecurso;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosProcessoDTO(

        String numeroProcesso,
        String codOrgaoResponsavel,
        String ufOrgao,
        String codOrgaoInterno,
        String codOrgaoProcesso,
        String descOrgaoProcesso,
        String codOrgaoAnalizador,
        String nomeRequerente,
        String tipoRequerente,
        String codMunicipio,
        String nomeMunicipio,
        String ufMunicipio,
        String descOrgaoAnalizador,
        String enderecoRequerente,
        String complementoEndereco,
        String numeroEndereco,
        String bairroRequerente,
        String cidadeRequerente,
        String ufRequerente,
        String cepRequerente,
        String numeroAr,
        String codSituacaoProcesso,
        String descSituacaoProcesso,
        String codJari,
        String descJari,
        String codRelator,
        String descRelator,
        String codResultado,
        String descResultado,
        String tipoResultado,
        String codStatusProcesso,
        String descStatusProcesso,
        LocalDate dataProtocolo,
        LocalDate dataCadastramento,
        LocalDate dataCadastramentoDb,
        LocalTime horaCadastramento,
        LocalDate dataConclusao,
        TipoRecurso tipoRecurso,
        String descTipoRecurso,
        String codOperador,
        String codEstacao,
        String codFuncao,
        String codOrgaoInternoAnalizador,
        LocalDate dataCiencia,
        String numRequerimentoSite,
        String recursoJulgadoNoSgpam
) {
}
