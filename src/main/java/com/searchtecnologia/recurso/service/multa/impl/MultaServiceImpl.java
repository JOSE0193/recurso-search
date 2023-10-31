package com.searchtecnologia.recurso.service.multa.impl;

import com.searchtecnologia.recurso.model.multa.LogMulta;
import com.searchtecnologia.recurso.model.multa.Multa;
import com.searchtecnologia.recurso.repository.multa.LogMultaRepository;
import com.searchtecnologia.recurso.repository.multa.MultaRepository;
import com.searchtecnologia.recurso.service.multa.MultaService;
import com.searchtecnologia.recurso.service.multa.query.criteria.MultaCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.searchtecnologia.recurso.service.multa.query.specification.MultaSpecification.buildEspecification;

@Service
@Transactional
@AllArgsConstructor
public class MultaServiceImpl implements MultaService {

    private MultaRepository repository;
    private LogMultaRepository logRepository;

    @Override
    public Multa salvar(Multa multa) {
        return this.repository.save(multa);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Multa> obterPorCodigoOrgaoAutuador(String codigoOrgaoAutuador, String numero, String sequencial) {
        MultaCriteria criteria = MultaCriteria.builder()
                .codigoOrgaoAutuador(StringFilter.buildEquals(codigoOrgaoAutuador))
                .numero(StringFilter.buildEquals(numero))
                .sequencial(StringFilter.buildEquals(sequencial))
                .build();
        return this.repository.findOne(buildEspecification(criteria));
    }

    @Override
    public LogMulta salvarLog(LogMulta logMulta) {
        return this.logRepository.save(logMulta);
    }
}