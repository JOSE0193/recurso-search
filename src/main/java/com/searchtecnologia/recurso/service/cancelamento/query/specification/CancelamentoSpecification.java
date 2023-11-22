package com.searchtecnologia.recurso.service.cancelamento.query.specification;

import com.searchtecnologia.recurso.model.cancelamento.CancelamentoMulta;
import com.searchtecnologia.recurso.model.cancelamento.CancelamentoMulta_;
import com.searchtecnologia.recurso.model.cancelamento.CancelamentoPK_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.service.cancelamento.query.criteria.CancelamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class CancelamentoSpecification {

    public static Specification<CancelamentoMulta> buildSpecification(CancelamentoCriteria criteria) {
        QueryService<CancelamentoMulta> queryService = new QueryService<>();

        Specification<CancelamentoMulta> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {

            //FILTRO NUMERO AUTO
            if (Objects.nonNull(criteria.getNumeroAuto())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAuto(),
                        root -> root.get(CancelamentoMulta_.id).get(CancelamentoPK_.numeroAuto)));
            }
            // FILTRO SEQUENCIAL
            if (Objects.nonNull(criteria.getSequencial())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSequencial(),
                        root -> root.get(CancelamentoMulta_.id).get(CancelamentoPK_.sequencial)));
            }
            // FILTRO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.join(CancelamentoMulta_.orgaoAutuador, JoinType.LEFT)
                                .get(OrgaoAutuador_.codigo)));
            }
        }
        return specification;
    }

}
