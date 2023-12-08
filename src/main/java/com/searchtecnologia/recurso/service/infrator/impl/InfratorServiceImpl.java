package com.searchtecnologia.recurso.service.infrator.impl;

import com.searchtecnologia.recurso.repository.cancelamento.CancelamentoRepository;
import com.searchtecnologia.recurso.repository.infrator.HistoricoInfratorRepository;
import com.searchtecnologia.recurso.service.cancelamento.CancelamentoService;
import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;
import com.searchtecnologia.recurso.service.cancelamento.mapper.CancelamentoMapper;
import com.searchtecnologia.recurso.service.cancelamento.query.criteria.CancelamentoCriteria;
import com.searchtecnologia.recurso.service.infrator.InfratorService;
import com.searchtecnologia.recurso.service.infrator.query.criteria.HistoricoInfratorCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.infrator.query.specification.HistoricoInfratorSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class InfratorServiceImpl implements InfratorService {

    private HistoricoInfratorRepository historicoInfratorRepository;

    /**
     * FUNÇÃO: PKG_SGM_INFRACAO_CONSULTA.FNC_POSSUI_HIST_INFRATOR
     */
    @Override
    public String possuiHistoricoInfrator(String numeroAuto, String sequencial, String orgaoAutuador) {
       HistoricoInfratorCriteria criteria = HistoricoInfratorCriteria.builder()
                .numeroAuto(StringFilter.buildEquals(numeroAuto))
                .sequencial(StringFilter.buildEquals(sequencial))
                .orgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .build();
        Long quantidade = this.historicoInfratorRepository.count(buildSpecification(criteria));
        if(quantidade > 0){
            return "S";
        }
        return "N";
    }

}
