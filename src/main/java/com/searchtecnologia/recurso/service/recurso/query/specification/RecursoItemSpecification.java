package com.searchtecnologia.recurso.service.recurso.query.specification;

import com.searchtecnologia.recurso.model.multa.MultaPK_;
import com.searchtecnologia.recurso.model.multa.Multa_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.model.recurso.RecursoItem;
import com.searchtecnologia.recurso.model.recurso.RecursoItem_;
import com.searchtecnologia.recurso.model.recurso.Recurso_;
import com.searchtecnologia.recurso.service.recurso.query.criteria.RecursoItemCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class RecursoItemSpecification {
    public static Specification<RecursoItem> buildSpecification(RecursoItemCriteria criteria) {
        QueryService<RecursoItem> queryService = new QueryService<>();

        Specification<RecursoItem> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            // FILTRO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getCodigoOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoOrgaoAutuador(),
                        root -> root.join(RecursoItem_.orgaoAutuador, JoinType.LEFT).get(OrgaoAutuador_.codigo)));
            }
            // FILTRO NUMERO DO AUTO DE INFRACAO
            if (Objects.nonNull(criteria.getNumeroAutoInfracao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAutoInfracao(),
                        root -> root.join(RecursoItem_.multa, JoinType.LEFT)
                                .get(Multa_.id)
                                .get(MultaPK_.numero)));
            }
            // FILTRO SEQUENCIAL DO AUTO DE INFRACAO
            if (Objects.nonNull(criteria.getSequencialAutoInfracao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAutoInfracao(),
                        root -> root.join(RecursoItem_.multa, JoinType.LEFT)
                                .get(Multa_.id)
                                .get(MultaPK_.sequencial)));
            }
            // FILTRO CODIGO DO ORGAO ANALISADOR DO RECURSO
            if (Objects.nonNull(criteria.getCodigoOrgaoAnalisadorRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoOrgaoAnalisadorRecurso(),
                        root -> root.join(RecursoItem_.recurso, JoinType.LEFT)
                                .join(Recurso_.orgaoAnalisador, JoinType.LEFT)
                                .get(OrgaoAutuador_.codigo)));
            }
            // FILTRO TIPO DO RECURSO
            if (Objects.nonNull(criteria.getTipoRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoRecurso(),
                        root -> root.join(RecursoItem_.recurso, JoinType.LEFT)
                                .get(Recurso_.tipo)));
            }
        }

        return specification;
    }
}