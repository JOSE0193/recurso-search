package com.searchtecnologia.recurso.service.multa;

import com.searchtecnologia.recurso.model.multa.LogMulta;
import com.searchtecnologia.recurso.model.multa.Multa;

import java.util.Optional;

public interface MultaService {

    Multa salvar(Multa multa);

    Optional<Multa> obterPorCodigoOrgaoAutuador(String codigoOrgaoAutuador, String numero, String sequencial);

    LogMulta salvarLog(LogMulta logMulta);


}