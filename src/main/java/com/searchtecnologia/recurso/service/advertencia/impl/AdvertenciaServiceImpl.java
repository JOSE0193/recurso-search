package com.searchtecnologia.recurso.service.advertencia.impl;

import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.StatusRecurso;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.model.resultado.TipoJulgamentoResultado;
import com.searchtecnologia.recurso.model.resultado.TipoRecursoResultado;
import com.searchtecnologia.recurso.repository.advertencia.AutoAutorizacaoRepository;
import com.searchtecnologia.recurso.repository.processo.ProcessoRepository;
import com.searchtecnologia.recurso.repository.recurso.RecursoViewRepository;
import com.searchtecnologia.recurso.service.advertencia.AdvertenciaService;
import com.searchtecnologia.recurso.service.advertencia.dto.AdvertenciaDTO;
import com.searchtecnologia.recurso.service.advertencia.mapper.AutoAutorizacaoMapper;
import com.searchtecnologia.recurso.service.advertencia.query.criteria.AutoAutorizacaoCriteria;
import com.searchtecnologia.recurso.service.processo.query.criteria.ProcessoCriteria;
import com.searchtecnologia.recurso.service.recurso.query.criteria.RecursoViewCriteria;
import com.searchtecnologia.recurso.service.recurso.query.filter.StatusRecursoFilter;
import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.TipoJulgamentoResultadoFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.TipoRecursoResultadoFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.processo.query.specification.ProcessoSpecification.buildSpecification;
import static com.searchtecnologia.recurso.service.recurso.query.specification.RecursoViewSpecification.buildSpecification;
import static com.searchtecnologia.recurso.service.advertencia.query.specification.AutoAutorizacaoSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class AdvertenciaServiceImpl implements AdvertenciaService {

    private final RecursoViewRepository recursoViewRepository;
    private final ProcessoRepository processoRepository;
    private final AutoAutorizacaoRepository autorizacaoAdvertenciaRepository;
    private final AutoAutorizacaoMapper autoAutorizacaoMapper;

    @Override
    public List<AdvertenciaDTO> listarAdvertencias(String numeroAuto, String codigoOrgao, String codigoInfracao) {
        AutoAutorizacaoCriteria criteria = AutoAutorizacaoCriteria.builder()
                .numeroMulta(StringFilter.buildEquals(numeroAuto))
                .orgaoAutuador(StringFilter.buildEquals(codigoOrgao))
                .codigoInfracao(StringFilter.buildEquals(codigoInfracao))
                .build();
        return this.autorizacaoAdvertenciaRepository.findAll(buildSpecification(criteria))
                .stream()
                .map(autoAutorizacaoMapper::toAdvertenciaDTO)
                .collect(Collectors.toList());
    }
    @Override
    public String validaConcluirSolicitacao(String numeroProcesso, String orgaoAnalizador, String indeferido) {
        String retorno = "0";
        RecursoViewCriteria criteriaVerificacao1 = RecursoViewCriteria.builder()
                .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalizador))
                .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.DEFESA_PREVIA))
                .build();
        Optional<RecursoView> recurso1 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao1));
        if (recurso1.isEmpty()) {
            retorno = "1";
        }
        RecursoViewCriteria criteriaVerificacao2 = RecursoViewCriteria.builder()
                .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalizador))
                .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.DEFESA_PREVIA))
                .statusRecurso(StatusRecursoFilter.buildIn(List.of(StatusRecurso.EM_ABERTO, StatusRecurso.EM_ANALISE, StatusRecurso.RESULTADOS_LANCADOS)))
                .build();
        Optional<RecursoView> recurso2 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao2));
        if (retorno != "1" && recurso2.isEmpty())  {
            retorno = "2";
        }

        if (retorno == "1") {
            RecursoViewCriteria criteriaVerificacao3 = RecursoViewCriteria.builder()
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.ADVERTENCIA))
                    .build();
            Optional<RecursoView> recurso3 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao3));
            if (recurso3 == null) {
                retorno = "3";
                RecursoViewCriteria criteriaVerificacao4 = RecursoViewCriteria.builder()
                        .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                        .build();
                Optional<RecursoView> recurso4 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao4));
                if(recurso4 == null) {
                    retorno = "4";
                }
            }
        }
        if (retorno == "0" && indeferido.trim() == "S") {
            ProcessoCriteria criteriaVerificacao5 = ProcessoCriteria.builder()
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoJulgamentoResultado(TipoJulgamentoResultadoFilter.buildEquals(TipoJulgamentoResultado.DEFERIDO))
                    .tipoRecursoResultado(TipoRecursoResultadoFilter.buildEquals(TipoRecursoResultado.ADVERTENCIA))
                    .build();
            long processo = processoRepository.count(buildSpecification(criteriaVerificacao5));
            if (processo != 0) {
                retorno = "5";
            }
        }
        return retorno;
    }

}
