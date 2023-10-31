package com.searchtecnologia.recurso.service.relator.query.specification;

import com.searchtecnologia.recurso.model.jari.JariPK_;
import com.searchtecnologia.recurso.model.jari.Jari_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.model.relator.Relator;
import com.searchtecnologia.recurso.model.relator.RelatorPK_;
import com.searchtecnologia.recurso.model.relator.Relator_;
import com.searchtecnologia.recurso.service.relator.query.criteria.RelatorCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class RelatorSpecification {

    public static Specification<Relator> buildSpecification(RelatorCriteria criteria) {
        QueryService<Relator> queryService = new QueryService<>();

        Specification<Relator> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            // FILTRO CODIGO RELATOR
            if (Objects.nonNull(criteria.getCodigo())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigo(),
                        root -> root.get(Relator_.id).get(RelatorPK_.codigo)));
            }
            // FILTRO NOME RELATOR
            if (Objects.nonNull(criteria.getNome())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNome(),
                        root -> root.get(Relator_.nome)));
            }
            // FILTRO NUMERO DO CODIGO JARI
            if (Objects.nonNull(criteria.getJari())) {
                specification = specification.and(queryService.buildSpecification(criteria.getJari(),
                        root -> root.join(Relator_.jari, JoinType.LEFT).get(Jari_.id).get(JariPK_.codigo)));
            }
            // FILTRO TIPO JARI
            if (Objects.nonNull(criteria.getTipoJari())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoJari(),
                        root -> root.join(Relator_.jari, JoinType.LEFT).get(String.valueOf(Jari_.tipoJari))));
            }
            // FILTRO CODIGO ORGAO RELATOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.join(Relator_.orgaoAutuador, JoinType.LEFT).get(OrgaoAutuador_.codigo)));
            }

            // FILTRO NUMERO DO ORGAO RELATOR
            if (Objects.nonNull(criteria.getOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAutuador(),
                        root -> root.join(Relator_.orgaoAutuador, JoinType.LEFT).get(OrgaoAutuador_.codigo)));
            }
            // FILTRO ATIVO
            if (Objects.nonNull(criteria.getAtivo())) {
                specification = specification.and(queryService.buildSpecification(criteria.getAtivo(),
                        root -> root.get(String.valueOf(Relator_.ativo))));
            }
        }
        return specification;
    }

}