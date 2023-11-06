package com.searchtecnologia.recurso.service.recurso.impl;

import com.searchtecnologia.recurso.exception.NotFoundException;
import com.searchtecnologia.recurso.model.multa.LogMulta;
import com.searchtecnologia.recurso.model.multa.LogMultaPK;
import com.searchtecnologia.recurso.model.multa.Multa;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainfPK;
import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.model.recurso.RecursoItem;
import com.searchtecnologia.recurso.model.recurso.RecursoItemPK;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.repository.recurso.RecursoItemRepository;
import com.searchtecnologia.recurso.service.multa.MultaService;
import com.searchtecnologia.recurso.service.ocorrenciarenainf.OcorrenciaRenainfService;
import com.searchtecnologia.recurso.service.recurso.RecursoItemService;
import com.searchtecnologia.recurso.service.recurso.dto.CadastrarRecursoItemDTO;
import com.searchtecnologia.recurso.service.recurso.query.criteria.RecursoItemCriteria;
import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.searchtecnologia.recurso.service.recurso.query.specification.RecursoItemSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class RecursoItemServiceImpl implements RecursoItemService {

    private static final String MSG_MULTA_NAO_ENCONTRADA_POR_ORGAO = "Auto de infração com codigo do orgão autuador %s, número %s, sequência %s não existe";

    private final RecursoItemRepository repository;
    private final MultaService multaService;
    private final OcorrenciaRenainfService ocorrenciaRenainfService;

    /**
     * PROCEDURE: PKG_SGM_RECURSO_DEFESA.PRC_CADASTRAR_AUTO_RECURSO
     */
    @Override
    public RecursoItem criaItemRecurso(Recurso recurso, CadastrarRecursoItemDTO cadastrarRecursoItemDTO) {

        // BUSCA A MULTA
        Multa multa = this.multaService.obterPorCodigoOrgaoAutuador(
                recurso.getOrgaoAnalisador().getCodigo(),
                cadastrarRecursoItemDTO.numeroAuto(),
                cadastrarRecursoItemDTO.sequencialAuto()
        ).orElseThrow(() -> new NotFoundException(
                String.format(
                        MSG_MULTA_NAO_ENCONTRADA_POR_ORGAO,
                        recurso.getOrgaoAnalisador().getCodigo(),
                        cadastrarRecursoItemDTO.numeroAuto(),
                        cadastrarRecursoItemDTO.sequencialAuto())
        ));

        RecursoItem recursoItem = new RecursoItem();

        RecursoItemPK recursoItemPK = new RecursoItemPK();
        recursoItemPK.setPlaca(cadastrarRecursoItemDTO.placa());
        recursoItemPK.setNumeroRecurso(recurso.getId().getNumero());
        recursoItemPK.setUfRecurso(recurso.getId().getUf());
        recursoItemPK.setOrgaoInternoRecurso(recurso.getId().getOrgaoInterno());
        recursoItemPK.setMunicipioAuto(multa.getId().getMunicipio());
        recursoItemPK.setNumeroAuto(multa.getId().getNumero());
        recursoItemPK.setSequencialAuto(multa.getId().getSequencial());
        recursoItem.setId(recursoItemPK);

        recursoItem.setOrgaoAutuador(recurso.getOrgaoAutuador());
        recursoItem.setDataCadastro(LocalDate.now());
        recursoItem.setHoraCadastro(LocalTime.now());
        recursoItem.setOperadorCadastro(recurso.getOperadorCadastro());
        recursoItem.setTerminalCadastro(recurso.getEstacaoCadastro());
        recursoItem.setFuncaoCadastro(recurso.getFuncaoCadastro());
        recursoItem.setOrgaoAnalisador(recurso.getOrgaoAnalisador());
        recursoItem.setSituacao1(" ");

        recursoItem = this.repository.save(recursoItem);

        this.salvarLogMulta(recursoItem, multa);

        // SE ALTERA A MULTA
        if (multa.getSituacao().compareTo("140") >= 0) { //TODO TESTAR COMPARAÇÃO DE STRING NO JAVA VERIFICAR SE PODE ALTERAR POR UM INTEIRO
            this.atualizarSituacaoMulta(multa);

            if (StringUtils.isNotEmpty(multa.getCodigoRenainf())) {
                this.salvarOcorrenciaRenainf(recurso, recursoItem, multa);
            }
        }

        return recursoItem;
    }

    private void salvarLogMulta(RecursoItem recursoItem, Multa multa) {
        LogMulta logMulta = new LogMulta();

        LogMultaPK id = new LogMultaPK();
        id.setData(LocalDate.now());
        id.setHora(LocalTime.now());
        id.setNumero(multa.getId().getNumero());
        id.setSequencial(multa.getId().getSequencial());

        logMulta.setId(id);
        logMulta.setOrgaoAutuador(recursoItem.getOrgaoAnalisador());
        logMulta.setSituacao(multa.getSituacao());
        logMulta.setOperador(recursoItem.getOperadorCadastro());
        logMulta.setEstacao(recursoItem.getTerminalCadastro());
        logMulta.setFuncao(recursoItem.getFuncaoCadastro());

        this.multaService.salvarLog(logMulta);
    }

    private void atualizarSituacaoMulta(Multa multa) {

        String situacao = "";

        switch (multa.getSituacao()) {
            case "135": // EM ANALISE DE ADVERTENCIA
                situacao = "138"; // ADVERTENCIA E DEFESA PREVIA EM ANALISE
                break;
            case "136": // SOLICITACAO DE ADVERTENCIA INDEFERIDA
                situacao = "13A"; // EM DEFESA PREVIA COM ADVERTENCIA INDEFERIDA
                break;
            case "137": // SOLICITACAO DE ADVERTENCIA DEFERIDA
                situacao = "13B"; // EM DEFESA PREVIA COM ADVERTENCIA DEFERIDA
                break;
            case "13E": // ADVERTENCIA CONCEDIDADA PELO ORGAO AUTUADOR
                situacao = "13F"; // EM DEFESA PREVIA COM ADVERTENCIA CONCEDIDA
                break;
            default:
                situacao = "132"; // EM ANALISE DE DEFESA PREVIA
                break;
        }

        multa.setSituacao(situacao);

        this.multaService.salvar(multa);
    }

    private void salvarOcorrenciaRenainf(Recurso recurso, RecursoItem recursoItem, Multa multa) {

        // SETA O TIPO E A ORIGEM DA OCORRÊNCIA
        String tipoOcorrencia = recurso.getOrgaoAnalisador().getUf().equals(recurso.getId().getUf())
                && Objects.nonNull(multa.getRemessa()) ? "02" : "01";
        String origemOcorrencia = recurso.getOrgaoAnalisador().getUf().equals(recurso.getId().getUf())
                && Objects.nonNull(multa.getRemessa()) ? "3" : "5";

        String numeroProcesso = this.ocorrenciaRenainfService
                .obterProcessoOriginal(
                        recursoItem.getOrgaoAnalisador().getCodigo(),
                        multa.getId().getNumero(),
                        multa.getId().getSequencial(),
                        "01"
                )
                .map(OcorrenciaRenainf::getNumeroProcesso)
                .orElse(recursoItem.getId().getNumeroRecurso());

        // CASO A MULTA ESTEJA NO CASO ESPECIAL DE ALTERAÇÃO DE NP PARA NA (REFERENTE AO PROBLEMA DOS CORREIOS)
        if (!multa.getSituacaoCorreio().equals("V")) {

            // VERIFICA A QTD DE RECURSOS DE DEFESA QUE O AUTO ESTÁ CADASTRADO, SE FOR ENCONTRADO EM MAIS DE UM PROCESSO, NAO CADASTRAR NA TABELA DE TR416 PENDENTE
            RecursoItemCriteria criteria = RecursoItemCriteria.builder()
                    .numeroAutoInfracao(StringFilter.buildEquals(multa.getId().getNumero()))
                    .sequencialAutoInfracao(StringFilter.buildEquals(multa.getId().getSequencial()))
                    .codigoOrgaoAnalisadorRecurso(StringFilter.buildEquals(recursoItem.getOrgaoAutuador().getCodigo()))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.DEFESA_PREVIA))
                    .build();

            long qtde = this.repository.count(buildSpecification(criteria));

            if (qtde < 2) {
                OcorrenciaRenainf ocorrenciaRenainf = new OcorrenciaRenainf();

                OcorrenciaRenainfPK id = new OcorrenciaRenainfPK();
                id.setCodigoOrgaoAutuador(recursoItem.getOrgaoAnalisador().getCodigo());
                id.setNumeroAutoInfracao(multa.getId().getNumero());
                id.setTipoOcorrencia(tipoOcorrencia);
                id.setCodigoInfracao(multa.getCodigoInfracao());
                id.setDataOcorrencia(LocalDate.now());
                id.setHoraOcorrencia(LocalTime.now());

                ocorrenciaRenainf.setSequencialAutoInfracao(multa.getId().getSequencial());
                ocorrenciaRenainf.setTipoLancamento("1");
                ocorrenciaRenainf.setNumeroProcesso(numeroProcesso);
                ocorrenciaRenainf.setUfOcorrencia(recurso.getId().getUf());
                ocorrenciaRenainf.setOrgaoOrigemOcorrencia(origemOcorrencia);
                ocorrenciaRenainf.setResultadoExecucao("999");
                ocorrenciaRenainf.setTransacaoRealizada("N");

                this.ocorrenciaRenainfService.salvar(ocorrenciaRenainf);
            }
        }
    }
}
