package com.searchtecnologia.recurso.service.processo.query.specification;

import com.searchtecnologia.recurso.model.processo.Processo;
import com.searchtecnologia.recurso.model.processo.ProcessoPK_;
import com.searchtecnologia.recurso.model.processo.Processo_;
import com.searchtecnologia.recurso.model.resultado.Resultado_;
import com.searchtecnologia.recurso.service.processo.query.criteria.ProcessoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ProcessoSpecification {
    public static Specification<Processo> buildSpecification(ProcessoCriteria criteria) {
        QueryService<Processo> queryService = new QueryService<>();

        Specification<Processo> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            //FILTRO NUMERO PROCESSO
            if (Objects.nonNull(criteria.getNumeroProcesso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroProcesso(),
                        root -> root.get(Processo_.id).get(ProcessoPK_.numero)));
            }
            //FILTRO SITUACAO
            if (Objects.nonNull(criteria.getSituacao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSituacao(),
                        root -> root.get(Processo_.situacao1)));
            }
            //FILTRO TIPO JULGAMENTO RESULTADO
            if (Objects.nonNull(criteria.getTipoJulgamentoResultado())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoJulgamentoResultado(),
                        root -> root.join(Processo_.resultado, JoinType.LEFT).get(Resultado_.tipoJulgamento)));
            }
            //FILTRO TIPO RECURSO RESULTADO
            if (Objects.nonNull(criteria.getTipoRecursoResultado())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoRecursoResultado(),
                        root -> root.join(Processo_.resultado, JoinType.LEFT).get(Resultado_.tipoRecurso)));
            }
        }
        return specification;
    }

}
