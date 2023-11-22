package com.searchtecnologia.recurso.service.cancelamento;

import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;

import java.util.List;

public interface CancelamentoService {

    String possuiCancelamento(String numeroAuto, String numeroSequencial, String orgaoAutuador);

    List<CancelamentoDTO> listarCancelamentos(String numeroAuto, String sequencial, String orgaoAutuador);

}
