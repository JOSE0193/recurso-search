package com.searchtecnologia.recurso.service.relator;

import com.searchtecnologia.recurso.service.relator.dto.CadastroRelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorSalvoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoSalvoDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RelatorService{

    List<RelatorDTO> listarRelatores(String codigoRelator, String descricaoRelator, String orgaoRelator, String codigoJari,
                                     String tipoJari, String ativo);

    String veirificarSeExiste(String codigo);

    String gerarCodigoRelator();

    RelatorSalvoDTO salvarRelator(@RequestBody @Valid CadastroRelatorDTO cadastroRelatorDTO);

}
