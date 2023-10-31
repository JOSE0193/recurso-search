package com.searchtecnologia.recurso.service.recurso.impl;

import com.searchtecnologia.recurso.exception.NotFoundException;
import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import com.searchtecnologia.recurso.model.recurso.*;
import com.searchtecnologia.recurso.repository.processo.DadosProcessoRepository;
import com.searchtecnologia.recurso.repository.processo.ProcessoViewRepository;
import com.searchtecnologia.recurso.repository.recurso.RecursoRepository;
import com.searchtecnologia.recurso.repository.recurso.RecursoViewRepository;
import com.searchtecnologia.recurso.service.orgaoautuador.OrgaoAutuadorService;
import com.searchtecnologia.recurso.service.recurso.RecursoItemService;
import com.searchtecnologia.recurso.service.recurso.RecursoService;
import com.searchtecnologia.recurso.service.recurso.dto.CadastrarRecursoDTO;
import com.searchtecnologia.recurso.service.recurso.dto.RecursoDTO;
import com.searchtecnologia.recurso.service.recurso.mapper.RecursoMapper;
import com.searchtecnologia.recurso.service.recurso.query.criteria.DadosProcessoCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import com.searchtecnologia.recurso.service.veiculo.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.recurso.query.specification.ProcessoSpecification.buildSpecification;


@Service
@Transactional
@AllArgsConstructor
public class RecursoServiceImpl implements RecursoService {

    private final RecursoRepository repository;
    private final OrgaoAutuadorService orgaoAutuadorService;
    private final RecursoItemService recursoItemService;
    private final ProcessoViewRepository processoViewRepository;
    private final RecursoViewRepository recursoViewRepository;
    private final DadosProcessoRepository dadosProcessoRepository;
    private final RecursoMapper mapper;
    private final VeiculoService veiculoService;

    /***
     * PROCEDURE: PKG_SGM_RECURSO_DEFESA.PRC_CADASTRA_RECURSO_AUTUACAO
     */
    @Override
    public RecursoDTO cadastrarRecurso(CadastrarRecursoDTO cadastrarRecursoDTO) {
        //TODO VALIDAR O NUMERO DO PROCESSO

        Recurso recurso = this.criaRecurso(cadastrarRecursoDTO);

        cadastrarRecursoDTO.itens().stream()
                .forEach(it -> this.recursoItemService.criaItemRecurso(recurso, it));

        return this.mapper.toDTO(recurso);
    }

    private Recurso criaRecurso(CadastrarRecursoDTO cadastrarRecursoDTO) {
        Recurso recurso = new Recurso();

        RecursoPK id = new RecursoPK();
        id.setNumero(cadastrarRecursoDTO.numeroProcesso());
        id.setUf(cadastrarRecursoDTO.ufOperadorCadastro());
        id.setOrgaoInterno(cadastrarRecursoDTO.codigoOrgaoInterno());
        recurso.setId(id);

        recurso.setOrgaoLotacao(cadastrarRecursoDTO.codigoOrgaoResponsavel());
        recurso.setNome(cadastrarRecursoDTO.nome());
        recurso.setEndereco(cadastrarRecursoDTO.endereco());
        recurso.setComplementoEndereco(cadastrarRecursoDTO.complementoEndereco());
        recurso.setBairroEndereco(cadastrarRecursoDTO.bairroEndereco());
        recurso.setCidadeEndereco(cadastrarRecursoDTO.cidadeEndereco());
        recurso.setUfEndereco(cadastrarRecursoDTO.ufEndereco());
        recurso.setCepEndereco(cadastrarRecursoDTO.cepEndereco());
        recurso.setSituacao(SituacaoRecurso.EM_ABERTO);
        recurso.setDataLog(LocalDate.now());
        recurso.setHoraLog(LocalTime.now());
        recurso.setOperadorLog(cadastrarRecursoDTO.operadorCadastro());
        recurso.setEstacaoLog(cadastrarRecursoDTO.estacaoCadastro());
        recurso.setFuncaoLog(cadastrarRecursoDTO.funcaoCadastro());
        recurso.setTipo(TipoRecurso.DEFESA_PREVIA);
        recurso.setDataProtocolo(cadastrarRecursoDTO.dataProtocolo());
        recurso.setDataCadastro(LocalDate.now());
        recurso.setHoraCadastro(LocalTime.now());
        recurso.setOperadorCadastro(cadastrarRecursoDTO.operadorCadastro());
        recurso.setEstacaoCadastro(cadastrarRecursoDTO.estacaoCadastro());
        recurso.setFuncaoCadastro(cadastrarRecursoDTO.funcaoCadastro());
        recurso.setStatus(StatusRecurso.EM_ABERTO);

        // BUSCA O ORGAO AUTUADOR
        String codigoOrgaoAutuador = cadastrarRecursoDTO.codigoOrgaoProcesso().equals("SGD") ? cadastrarRecursoDTO.codigoOrgaoInterno() : cadastrarRecursoDTO.codigoOrgaoProcesso();
        this.orgaoAutuadorService.obterPorCodigo(codigoOrgaoAutuador)
                .ifPresentOrElse(
                        recurso::setOrgaoAutuador,
                        () -> new NotFoundException(String.format("Orgão autuador com id %s não existe", cadastrarRecursoDTO.codigoOrgaoInterno()))
                );

        // BUSCA O ORGAO ANALISADOR
        this.orgaoAutuadorService.obterPorCodigo(cadastrarRecursoDTO.codigoOrgaoAnalisador())
                .ifPresentOrElse(
                        recurso::setOrgaoAnalisador,
                        () -> new NotFoundException(String.format("Orgão autuador com id %s não existe", cadastrarRecursoDTO.codigoOrgaoAnalisador()))
                );

        recurso = this.repository.save(recurso);

        return recurso;
    }

    @Override
    public String verificarAutoPossuiRecurso(String codigoOrgao, String numeroAuto, String sequencial, String tipoRecurso) {
        TipoRecurso tipo = TipoRecurso.valueOf(tipoRecurso);
        Long contador = processoViewRepository.countByCodigoOrgaoAndNumeroAutoAndSequencialAndRecursoViewTipoRecurso
                (codigoOrgao, numeroAuto, sequencial, tipo);
        if (contador == 0) {
            return "S";
        }
        return "N";
    }

    @Override
    public String validaConcluirSolicitacao(String numeroProcesso, String orgaoAnalizador, String indeferido) {
        String retorno = "0"; // Valor padrão

        RecursoView recurso = recursoViewRepository.findByNumeroAndOrgaoAnalizadorCodigoAndTipoRecurso
                (numeroProcesso, orgaoAnalizador, TipoRecurso.valueOf("A"));

        if (recurso == null) {
            retorno = "1";
        } else if (!"00".equals(recurso.getStatus().getValor()) &&
                !"01".equals(recurso.getStatus().getValor()) &&
                !"02".equals(recurso.getStatus().getValor())) {
            retorno = "2";
        }

        if ("1".equals(retorno)) {
            RecursoView advertenciaProcesso = recursoViewRepository.findByNumeroAndTipoRecurso(numeroProcesso, TipoRecurso.valueOf("A"));

            if (advertenciaProcesso == null) {
                RecursoView tipoInvalidoProcesso = recursoViewRepository.findByNumero(numeroProcesso);

                if (tipoInvalidoProcesso == null) {
                    retorno = "1";
                } else {
                    retorno = "4";
                }
            } else {
                retorno = "3";
            }
        }

        if ("0".equals(retorno) && "S".equals(indeferido)) {
            long count = processoViewRepository.countByCodigoRecursoAndResultadoTipoJulgamentoAndResultadoTipoRecurso
                    (numeroProcesso, "D", "A");
            if (count != 0) {
                retorno = "5";
            }
        }
        return retorno;
    }

    @Override
    public List<DadosProcessoView> consultarProcesso(String numeroProcesso, String placa, String numeroAuto, String situacao,
                                                     String relator, String dataInicio, String dataFim, String nomeRequerente,
                                                     String orgaoInterno, String tipoRecurso, String orgaoProcesso, String orgaoAnalizador) {
        String placaConvertida = veiculoService.conversorPlacaMercosul(placa);
        DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                .placa(StringFilter.buildEquals(placaConvertida))
                .tipoRecurso(StringFilter.buildEquals(tipoRecurso))
                .numeroAuto(StringFilter.buildContains(numeroAuto))
                .situacao(StringFilter.buildEquals(situacao))
                .relator(StringFilter.buildEquals(relator))
                .dataInicio(StringFilter.buildEquals(dataInicio))
                .dataFim(StringFilter.buildEquals(dataFim))
                .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                .orgaoInterno(StringFilter.buildEquals(orgaoInterno))
                .orgaoAnalizador(StringFilter.buildEquals(orgaoAnalizador))
                .nomeRequerente(StringFilter.buildEquals(nomeRequerente))
                .build();
        return dadosProcessoRepository.findAll(buildSpecification(criteria));
    }

}