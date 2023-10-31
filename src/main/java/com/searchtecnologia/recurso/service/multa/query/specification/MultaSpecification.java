package com.searchtecnologia.recurso.service.multa.query.specification;

import com.searchtecnologia.recurso.model.multa.Multa;
import com.searchtecnologia.recurso.model.multa.MultaPK_;
import com.searchtecnologia.recurso.model.multa.Multa_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.service.multa.query.criteria.MultaCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class MultaSpecification {

    public static Specification<Multa> buildEspecification(MultaCriteria criteria) {

        QueryService<Multa> queryService = new QueryService<>();

        Specification<Multa> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            // FILTRO NUMERO
            if (Objects.nonNull(criteria.getNumero())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumero(),
                        root -> root.get(Multa_.id).get(MultaPK_.numero)));
            }
            // FILTRO SEQUENCIAL
            if (Objects.nonNull(criteria.getSequencial())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSequencial(),
                        root -> root.get(Multa_.id).get(MultaPK_.sequencial)));
            }
            // FILTRO CODIGO DO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getCodigoOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoOrgaoAutuador(),
                        root -> root.join(Multa_.orgaoAutuador, JoinType.LEFT)
                                .get(OrgaoAutuador_.codigo)));
            }
        }

        return specification;
    }

}
