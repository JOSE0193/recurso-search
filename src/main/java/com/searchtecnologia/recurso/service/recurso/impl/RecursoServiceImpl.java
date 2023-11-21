package com.searchtecnologia.recurso.service.recurso.impl;

import com.searchtecnologia.recurso.exception.NotFoundException;
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
import com.searchtecnologia.recurso.service.veiculo.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

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

//    @Override
//    public String verificarAutoPossuiRecurso(String codigoOrgao, String numeroAuto, String sequencial, String tipoRecurso) {
//        TipoRecurso tipo = TipoRecurso.valueOf(tipoRecurso);
//        Long contador = processoViewRepository.countByCodigoOrgaoAndNumeroAutoAndSequencialAndRecursoViewTipoRecurso
//                (codigoOrgao, numeroAuto, sequencial, tipo);
//        if (contador == 0) {
//            return "S";
//        }
//        return "N";
//    }

//

}