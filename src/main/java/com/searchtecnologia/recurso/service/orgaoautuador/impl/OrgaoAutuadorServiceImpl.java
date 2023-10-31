package com.searchtecnologia.recurso.service.orgaoautuador.impl;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.repository.orgaoautuador.OrgaoAutuadorRepository;
import com.searchtecnologia.recurso.service.orgaoautuador.OrgaoAutuadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrgaoAutuadorServiceImpl implements OrgaoAutuadorService {

    private OrgaoAutuadorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<OrgaoAutuador> obterPorCodigo(String codigo) {
        return this.repository.findById(codigo);
    }
}
