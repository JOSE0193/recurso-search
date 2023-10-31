package com.searchtecnologia.recurso.service.orgaoautuador;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;

import java.util.Optional;

public interface OrgaoAutuadorService {

    Optional<OrgaoAutuador> obterPorCodigo(String codigo);
}
