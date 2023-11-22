package com.searchtecnologia.recurso.service.cancelamento.impl;

import com.searchtecnologia.recurso.repository.cancelamento.CancelamentoRepository;
import com.searchtecnologia.recurso.service.cancelamento.CancelamentoService;
import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;
import com.searchtecnologia.recurso.service.cancelamento.mapper.CancelamentoMapper;
import com.searchtecnologia.recurso.service.cancelamento.query.criteria.CancelamentoCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.cancelamento.query.specification.CancelamentoSpecification.buildSpecification;


@Service
@Transactional
@AllArgsConstructor
public class CancelamentoServiceImpl implements CancelamentoService {

    private CancelamentoRepository repository;
    private CancelamentoMapper mapper;

    /**
     * FUNÇÃO: PKG_SGM_INFRACAO_CONSULTA.FNC_POSSUI_CANCELAMENTO
     */
    @Override
    public String possuiCancelamento(String numeroAuto, String sequencial, String orgaoAutuador) {
       CancelamentoCriteria criteria = CancelamentoCriteria.builder()
                .numeroAuto(StringFilter.buildEquals(numeroAuto))
                .sequencial(StringFilter.buildEquals(sequencial))
                .orgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .build();
        Long quantidade = this.repository.count(buildSpecification(criteria));
        if(quantidade > 0){
            return "S";
        }
        return "N";
    }

    /**
     * FUNÇÃO: PKG_SGM_INFRACAO_CONSULTA.FNC_LISTAR_CANCELAMENTO
     */
    @Override
    public List<CancelamentoDTO> listarCancelamentos(String numeroAuto, String sequencial, String orgaoAutuador) {
        CancelamentoCriteria criteria = CancelamentoCriteria.builder()
                .numeroAuto(StringFilter.buildEquals(numeroAuto))
                .sequencial(StringFilter.buildEquals(sequencial))
                .orgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .build();
        return this.repository.findAll(buildSpecification(criteria))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}
