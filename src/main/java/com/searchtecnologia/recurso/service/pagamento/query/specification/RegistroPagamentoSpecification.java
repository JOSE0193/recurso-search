package com.searchtecnologia.recurso.service.pagamento.query.specification;

import com.searchtecnologia.recurso.model.cancelamento.CancelamentoMulta_;
import com.searchtecnologia.recurso.model.cancelamento.CancelamentoPK_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.model.pagamento.RegistroPagamentoMulta;
import com.searchtecnologia.recurso.model.pagamento.RegistroPagamentoMultaPK_;
import com.searchtecnologia.recurso.model.pagamento.RegistroPagamentoMulta_;
import com.searchtecnologia.recurso.service.pagamento.query.criteria.RegistroPagamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class RegistroPagamentoSpecification {

    public static Specification<RegistroPagamentoMulta> buildSpecification(RegistroPagamentoCriteria criteria) {
        QueryService<RegistroPagamentoMulta> queryService = new QueryService<>();

        Specification<RegistroPagamentoMulta> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {

            //FILTRO NUMERO AUTO
            if (Objects.nonNull(criteria.getNumeroAuto())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAuto(),
                        root -> root.get(RegistroPagamentoMulta_.id).get(RegistroPagamentoMultaPK_.numeroAutoInfracao)));
            }
            // FILTRO CODIGO INFRAÇÃO
            if (Objects.nonNull(criteria.getCodigoInfracao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoInfracao(),
                        root -> root.get(RegistroPagamentoMulta_.id).get(RegistroPagamentoMultaPK_.codigoInfracao)));
            }
            // FILTRO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.get(RegistroPagamentoMulta_.id).get(RegistroPagamentoMultaPK_.codigoOrgaoAutuador)));
            }
        }
        return specification;
    }

}
