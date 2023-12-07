package com.searchtecnologia.recurso.service.parcelamento.query.specification;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.model.parcelamento.AutoInfracaoParcelamento;
import com.searchtecnologia.recurso.model.parcelamento.AutoInfracaoParcelamentoPK_;
import com.searchtecnologia.recurso.model.parcelamento.AutoInfracaoParcelamento_;
import com.searchtecnologia.recurso.service.cancelamento.query.criteria.CancelamentoCriteria;
import com.searchtecnologia.recurso.service.parcelamento.query.criteria.AutoInfracaoParcelamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class AutoInfracaoParcelamentoSpecification {

    public static Specification<AutoInfracaoParcelamento> buildSpecification(AutoInfracaoParcelamentoCriteria criteria) {
        QueryService<AutoInfracaoParcelamento> queryService = new QueryService<>();

        Specification<AutoInfracaoParcelamento> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {

            //FILTRO NUMERO AUTO
            if (Objects.nonNull(criteria.getNumeroAuto())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAuto(),
                        root -> root.get(AutoInfracaoParcelamento_.id).get(AutoInfracaoParcelamentoPK_.autoNumero)));
            }
            // FILTRO SEQUENCIAL
            if (Objects.nonNull(criteria.getSequencial())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSequencial(),
                        root -> root.get(AutoInfracaoParcelamento_.id).get(AutoInfracaoParcelamentoPK_.autoSequencial)));
            }
            // FILTRO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.get(AutoInfracaoParcelamento_.autoOrgaoAutuador)));
            }
        }
        return specification;
    }

}
