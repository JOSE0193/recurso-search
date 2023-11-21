package com.searchtecnologia.recurso.service.recurso.query.specification;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.model.recurso.RecursoPK_;
import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.recurso.RecursoView_;
import com.searchtecnologia.recurso.model.recurso.Recurso_;
import com.searchtecnologia.recurso.service.recurso.query.criteria.RecursoViewCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class RecursoViewSpecification {

    public static Specification<RecursoView> buildSpecification(RecursoViewCriteria criteria) {
        QueryService<RecursoView> queryService = new QueryService<>();

        Specification<RecursoView> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            // FILTRO NUMERO DO PROCESSO
            if (Objects.nonNull(criteria.getNumeroProcesso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroProcesso(),
                        root -> root.get(RecursoView_.numero)));
            }
            // FILTRO CODIGO DO ORGAO ANALISADOR DO RECURSO
            if (Objects.nonNull(criteria.getOrgaoAnalisador())) {
                    specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAnalisador(),
                            root -> root.join(RecursoView_.orgaoAnalizador, JoinType.LEFT)
                                    .get(OrgaoAutuador_.codigo)));
            }
            // FILTRO TIPO RECURSO
            if (Objects.nonNull(criteria.getTipoRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoRecurso(),
                        root -> root.get(RecursoView_.tipoRecurso)));
            }
            // FILTRO STATUS RECURSO
            if (Objects.nonNull(criteria.getStatusRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getStatusRecurso(),
                        root -> root.get(RecursoView_.status)));
            }
        }
        return specification;
    }

}
