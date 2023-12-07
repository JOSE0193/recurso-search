package com.searchtecnologia.recurso.service.parcelamento.impl;

import com.searchtecnologia.recurso.repository.cancelamento.CancelamentoRepository;
import com.searchtecnologia.recurso.repository.parcelamento.AutoInfracaoParcelamentoRepository;
import com.searchtecnologia.recurso.service.cancelamento.CancelamentoService;
import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;
import com.searchtecnologia.recurso.service.cancelamento.mapper.CancelamentoMapper;
import com.searchtecnologia.recurso.service.cancelamento.query.criteria.CancelamentoCriteria;
import com.searchtecnologia.recurso.service.parcelamento.ParcelamentoService;
import com.searchtecnologia.recurso.service.parcelamento.query.criteria.AutoInfracaoParcelamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.parcelamento.query.specification.AutoInfracaoParcelamentoSpecification.buildSpecification;


@Service
@Transactional
@AllArgsConstructor
public class ParcelamentoServiceImpl implements ParcelamentoService {

    private AutoInfracaoParcelamentoRepository autoInfracaoParcelamentoRepository;

    /**
     * FUNÇÃO: PKG_SGM_INFRACAO_CONSULTA. FNC_POSSUI_PARCELAMENTO
     */
    @Override
    public String possuiParcelamento(String numeroAuto, String sequencial, String orgaoAutuador) {
       AutoInfracaoParcelamentoCriteria criteria = AutoInfracaoParcelamentoCriteria.builder()
                .numeroAuto(StringFilter.buildEquals(numeroAuto))
                .sequencial(StringFilter.buildEquals(sequencial))
                .orgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .build();
        Long quantidade = this.autoInfracaoParcelamentoRepository.count(buildSpecification(criteria));
        if(quantidade > 0){
            return "S";
        }
        return "N";
    }

}
