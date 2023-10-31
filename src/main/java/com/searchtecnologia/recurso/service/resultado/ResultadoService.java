package com.searchtecnologia.recurso.service.resultado;

import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.service.resultado.dto.CadastrarResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoSalvoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.TiposResultadoDTO;

import java.util.List;

public interface ResultadoService {

    List<ResultadoDTO> listarResultados(String codigoResultado, String descResultado, String tipoJulgamento,
                                        String tipoRecurso, String ativos , String orgaoAnalisador);

    List<TiposResultadoDTO> listarTiposResultado();

    String veirificarSeExiste(String codigo);

    ResultadoSalvoDTO salvarResultado(CadastrarResultadoDTO cadastrarResultadoDTO);

}