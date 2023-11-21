package com.searchtecnologia.recurso.service.processo.query.specification;

import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import com.searchtecnologia.recurso.model.processo.DadosProcessoView_;
import com.searchtecnologia.recurso.model.processo.ProcessoView_;
import com.searchtecnologia.recurso.service.processo.query.criteria.DadosProcessoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class DadosProcessoSpecification {

    public static Specification<DadosProcessoView> buildSpecification(DadosProcessoCriteria criteria) {
        QueryService<DadosProcessoView> queryService = new QueryService<>();

        Specification<DadosProcessoView> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            //FILTRO NUMERO PROCESSO
            if (Objects.nonNull(criteria.getNumeroProcesso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroProcesso(),
                        root -> root.get(DadosProcessoView_.numeroProcesso)));
            }
            //FILTRO PLACA
            if (Objects.nonNull(criteria.getPlaca())) {
                specification = specification.and(queryService.buildSpecification(criteria.getPlaca(),
                        root -> root.join(DadosProcessoView_.processos, JoinType.LEFT).get(ProcessoView_.placa)));
            }
            //FILTRO NUMERO AUTO
            if (Objects.nonNull(criteria.getNumeroAuto())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAuto(),
                        root -> root.join(DadosProcessoView_.processos, JoinType.LEFT).get(ProcessoView_.numeroAuto)));
            }
            //FILTRO SITUAÇÃO
            if (Objects.nonNull(criteria.getSituacao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSituacao(),
                        root -> root.get(DadosProcessoView_.codSituacaoProcesso)));
            }
            //FILTRO RELATOR
            if (Objects.nonNull(criteria.getRelator())) {
                specification = specification.and(queryService.buildSpecification(criteria.getRelator(),
                        root -> root.get(DadosProcessoView_.codRelator)));
            }
            //FILTRO DATA INICIO
            if (Objects.nonNull(criteria.getDataInicio())) {
                specification = specification.and(queryService.buildSpecification(criteria.getDataInicio(),
                        root -> root.get(DadosProcessoView_.dataCadastramentoDb)));
            }
            //FILTRO DATA FIM
            if (Objects.nonNull(criteria.getDataFim())) {
                specification = specification.and(queryService.buildSpecification(criteria.getDataFim(),
                        root -> root.get(DadosProcessoView_.dataCadastramentoDb)));
            }
            //FILTRO NOME REQUERENTE
            if (Objects.nonNull(criteria.getNomeRequerente())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNomeRequerente(),
                        root -> root.get(DadosProcessoView_.nomeRequerente)));
            }
            //FILTRO ORGAO INTERNO
            if (Objects.nonNull(criteria.getOrgaoInterno())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoInterno(),
                        root -> root.get(DadosProcessoView_.codOrgaoInternoAnalizador)));
            }
            //FILTRO TIPO RECURSO
            if (Objects.nonNull(criteria.getTipoRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoRecurso(),
                        root -> root.get(DadosProcessoView_.tipoRecurso)));
            }
            //FILTRO ORGAO PROCESSO
            if (Objects.nonNull(criteria.getOrgaoProcesso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoProcesso(),
                        root -> root.get(DadosProcessoView_.codOrgaoProcesso)));
            }
            //FILTRO ORGAO ANALIZADOR
            if (Objects.nonNull(criteria.getOrgaoAnalisador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAnalisador(),
                        root -> root.get(DadosProcessoView_.codOrgaoAnalizador)));
            }
        }
        return specification;
    }

}