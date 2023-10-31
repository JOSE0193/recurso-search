package com.searchtecnologia.recurso.service.resultado.query.specification;

import com.searchtecnologia.recurso.model.resultado.MotivoResultadoPK_;
import com.searchtecnologia.recurso.model.resultado.MotivoResultado_;
import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.model.resultado.Resultado_;
import com.searchtecnologia.recurso.service.resultado.query.criteria.ResultadoCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ResultadoSpecification {

    public static Specification<Resultado> buildSpecification(ResultadoCriteria criteria) {
        QueryService<Resultado> queryService = new QueryService<>();

        Specification<Resultado> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            //FILTRO CODIGO RESULTADO
            if (Objects.nonNull(criteria.getCodigoResultado())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoResultado(),
                        root -> root.join(Resultado_.motivosResultado, JoinType.LEFT).get(MotivoResultado_.id)
                                .get(MotivoResultadoPK_.codigoResultado)));
            }
            //FILTRO CODIGO ORGAO AUTUADOR
            if (Objects.nonNull(criteria.getOrgaoAnalisador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoAnalisador(),
                        root -> root.join(Resultado_.motivosResultado, JoinType.LEFT).get(MotivoResultado_.id)
                                .get(MotivoResultadoPK_.codigoOrgao)));
            }
            //FILTRO TIPO JULGAMENTO
            if (Objects.nonNull(criteria.getTipoJulgamento())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoJulgamento(),
                        root -> root.get(String.valueOf(Resultado_.tipoJulgamento))));
            }
            // FILTRO TIPO RECURSO
            if (Objects.nonNull(criteria.getTipoRecurso())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoRecurso(),
                        root -> root.get(String.valueOf(Resultado_.tipoRecurso))));
            }
            // FILTRO DESCRICAO RESULTADO
            if (Objects.nonNull(criteria.getDescricaoResultado())) {
                specification = specification.and(queryService.buildSpecification(criteria.getDescricaoResultado(),
                        root -> root.get((Resultado_.descricao))));

            }
            // FILTRO RESULTADO ATIVO
            if (Objects.nonNull(criteria.getAtivoResultado())) {
                specification = specification.and(queryService.buildSpecification(criteria.getAtivoResultado(),
                        root -> root.get(String.valueOf(Resultado_.ativo))));
            }
            // FILTRO MOTIVO ATIVO
            if (Objects.nonNull(criteria.getAtivoMotivo())) {
                specification = specification.and(queryService.buildSpecification(criteria.getAtivoMotivo(),
                        root -> root.join(Resultado_.motivosResultado, JoinType.INNER).get(String.valueOf(MotivoResultado_.ativo))));
            }
        }
        return specification;
    }

}
