package com.searchtecnologia.recurso.service.infrator.query.specification;

import com.searchtecnologia.recurso.model.infrator.HistoricoInfrator;
import com.searchtecnologia.recurso.model.infrator.HistoricoInfratorPK_;
import com.searchtecnologia.recurso.model.infrator.HistoricoInfrator_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.service.infrator.query.criteria.HistoricoInfratorCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class HistoricoInfratorSpecification {

    public static Specification<HistoricoInfrator> buildSpecification(HistoricoInfratorCriteria criteria) {
        QueryService<HistoricoInfrator> queryService = new QueryService<>();

        Specification<HistoricoInfrator> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {

            //FILTRO NUMERO AUTO
            if (Objects.nonNull(criteria.getNumeroAuto())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAuto(),
                        root -> root.get(HistoricoInfrator_.id).get(HistoricoInfratorPK_.numeroMulta)));
            }
            // FILTRO SEQUENCIAL
            if (Objects.nonNull(criteria.getSequencial())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSequencial(),
                        root -> root.get(HistoricoInfrator_.id).get(HistoricoInfratorPK_.sequencial)));
            }
            // FILTRO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.join(HistoricoInfrator_.orgaoAutuador, JoinType.LEFT)
                                .get(OrgaoAutuador_.codigo)));
            }
        }
        return specification;
    }

}
