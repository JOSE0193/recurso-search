package com.searchtecnologia.recurso.service.recurso.dto;

import com.searchtecnologia.recurso.model.uf.UF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CadastrarRecursoDTO(
        @NotBlank(message = "numeroProcesso deve ser informado")
        String numeroProcesso,
        @NotNull(message = "dataProtocolo deve ser informada")
        LocalDate dataProtocolo,
        @NotBlank(message = "codigoOrgaoProcesso deve ser informado")
        String codigoOrgaoProcesso,
        @NotBlank(message = "codigoOrgaoAnalisador deve ser informado")
        String codigoOrgaoAnalisador,
        @NotBlank(message = "nome deve ser informado")
        String nome,
        String endereco,
        String complementoEndereco,
        String bairroEndereco,
        String cidadeEndereco,
        UF ufEndereco,
        String cepEndereco,
        @NotBlank(message = "codigoOrgaoInterno deve ser informado")
        String codigoOrgaoInterno,
        @NotBlank(message = "codigoOrgaoResponsavel deve ser informado")
        String codigoOrgaoResponsavel,
        @NotNull(message = "ufOperadorCadastro deve ser informada")
        UF ufOperadorCadastro,
        @NotBlank(message = "operadorCadastro deve ser informado")
        String operadorCadastro,
        @NotBlank(message = "estacaoCadastro deve ser informada")
        String estacaoCadastro,
        @NotBlank(message = "funcaoCadastro deve ser informada")
        String funcaoCadastro,
        @Valid
        @NotEmpty(message = "itens não pode ser vazia")
        List<CadastrarRecursoItemDTO> itens
) {
}
