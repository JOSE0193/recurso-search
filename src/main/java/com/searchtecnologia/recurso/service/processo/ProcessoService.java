package com.searchtecnologia.recurso.service.processo;

import com.searchtecnologia.recurso.service.processo.dto.DadosProcessoDTO;
import com.searchtecnologia.recurso.service.processo.dto.TipoProcessoDTO;

import java.util.List;
public interface ProcessoService {

    List<DadosProcessoDTO> consultarProcesso (String numeroProcesso, String placa, String numeroAuto, String situacao,
                                              String relator, String dataInicio, String dataFim, String nomeRequerente,
                                              String orgaoInterno, String tipoRecurso, String orgaoProcesso, String orgaoAnalisador);

    List<TipoProcessoDTO> listaRequerimentoPermitido(String orgao);

}