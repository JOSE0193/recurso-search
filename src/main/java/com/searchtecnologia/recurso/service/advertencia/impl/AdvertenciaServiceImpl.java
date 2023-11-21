package com.searchtecnologia.recurso.service.advertencia.impl;

import com.searchtecnologia.recurso.model.processo.Processo;
import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.StatusRecurso;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.model.resultado.TipoJulgamentoResultado;
import com.searchtecnologia.recurso.model.resultado.TipoRecursoResultado;
import com.searchtecnologia.recurso.repository.processo.ProcessoRepository;
import com.searchtecnologia.recurso.repository.recurso.RecursoRepository;
import com.searchtecnologia.recurso.repository.recurso.RecursoViewRepository;
import com.searchtecnologia.recurso.service.advertencia.AdvertenciaService;
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

import static com.searchtecnologia.recurso.service.processo.query.specification.ProcessoSpecification.buildSpecification;
import static com.searchtecnologia.recurso.service.recurso.query.specification.RecursoViewSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class AdvertenciaServiceImpl implements AdvertenciaService {

    private final RecursoViewRepository recursoViewRepository;
    private final ProcessoRepository processoRepository;

    @Override
    public String validaConcluirSolicitacao(String numeroProcesso, String orgaoAnalizador, String indeferido) {
        String retorno = "0";
        RecursoViewCriteria criteriaVerificacao1 = RecursoViewCriteria.builder()
                .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalizador))
                .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.ADVERTENCIA))
                .build();
        Optional<RecursoView> recurso1 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao1));
        RecursoViewCriteria criteriaVerificacao2 = RecursoViewCriteria.builder()
                .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalizador))
                .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.ADVERTENCIA))
                .statusRecurso(StatusRecursoFilter.buildIn(List.of(StatusRecurso.EM_ABERTO, StatusRecurso.EM_ANALISE, StatusRecurso.RESULTADOS_LANCADOS)))
                .build();
        if (recurso1.isEmpty()) {
            retorno = "1";
            Optional<RecursoView> recurso2 = this.recursoViewRepository.findOne(buildSpecification(criteriaVerificacao2));
            if (recurso2.isEmpty())  {
                retorno = "2";
            }
        }
        if (retorno == "1") {
            RecursoViewCriteria criteriaVerificacao3 = RecursoViewCriteria.builder()
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get("A")))
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
        if (retorno == "0" && indeferido.trim().toUpperCase() == "S") {
            ProcessoCriteria criteriaVerificacao5 = ProcessoCriteria.builder()
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoJulgamentoResultado(TipoJulgamentoResultadoFilter.buildEquals(TipoJulgamentoResultado.D))
                    .tipoRecursoResultado(TipoRecursoResultadoFilter.buildEquals(TipoRecursoResultado.get("A")))
                    .build();
            long processo = processoRepository.count(buildSpecification(criteriaVerificacao5));
            if (processo == 0) {
                retorno = "5";
            }
        }
        return retorno;
    }

}