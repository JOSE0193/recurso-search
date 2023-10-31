package com.searchtecnologia.recurso.service.ocorrenciarenainf.query.specification;

import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainfPK_;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf_;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador_;
import com.searchtecnologia.recurso.service.ocorrenciarenainf.query.criteria.OcorrenciaRenainfCriteria;
import com.searchtecnologia.recurso.service.util.query.QueryService;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class OcorrenciaRenainfSpecification {
    public static Specification<OcorrenciaRenainf> buildEspecification(OcorrenciaRenainfCriteria criteria) {
        QueryService<OcorrenciaRenainf> queryService = new QueryService<>();

        Specification<OcorrenciaRenainf> specification = Specification.where(null);

        if (Objects.nonNull(criteria)) {
            if (Objects.nonNull(criteria.getCodigoOrgaoAutuador())) {
                specification = specification.and(queryService.buildSpecification(criteria.getCodigoOrgaoAutuador(),
                        root -> root.join(OcorrenciaRenainf_.orgaoAutuador, JoinType.LEFT)
                                .get(OrgaoAutuador_.codigo)));
            }
            if (Objects.nonNull(criteria.getNumeroAutoInfracao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getNumeroAutoInfracao(), root -> root.get(OcorrenciaRenainf_.id).get(OcorrenciaRenainfPK_.numeroAutoInfracao)));
            }
            if (Objects.nonNull(criteria.getSequencialAutoInfracao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getSequencialAutoInfracao(), root -> root.get(OcorrenciaRenainf_.sequencialAutoInfracao)));
            }
            if (Objects.nonNull(criteria.getTipoOcorrencia())) {
                specification = specification.and(queryService.buildSpecification(criteria.getTipoOcorrencia(), root -> root.get(OcorrenciaRenainf_.id).get(OcorrenciaRenainfPK_.tipoOcorrencia)));
            }
            if (Objects.nonNull(criteria.getOrgaoOrigemOcorrencia())) {
                specification = specification.and(queryService.buildSpecification(criteria.getOrgaoOrigemOcorrencia(), root -> root.get(OcorrenciaRenainf_.orgaoOrigemOcorrencia)));
            }
            if (Objects.nonNull(criteria.getResultadoExecucao())) {
                specification = specification.and(queryService.buildSpecification(criteria.getResultadoExecucao(), root -> root.get(OcorrenciaRenainf_.resultadoExecucao)));
            }
            if (Objects.nonNull(criteria.getDataOcorrencia())) {
                specification = specification.and(queryService.buildSpecification(criteria.getDataOcorrencia(), root -> root.get(OcorrenciaRenainf_.id).get(OcorrenciaRenainfPK_.dataOcorrencia)));
            }
            if (Objects.nonNull(criteria.getHoraOcorrencia())) {
                specification = specification.and(queryService.buildSpecification(criteria.getHoraOcorrencia(), root -> root.get(OcorrenciaRenainf_.id).get(OcorrenciaRenainfPK_.horaOcorrencia)));
            }
        }

        return specification;
    }
}
