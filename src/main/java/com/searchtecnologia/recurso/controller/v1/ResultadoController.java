package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.resultado.ResultadoService;
import com.searchtecnologia.recurso.service.resultado.dto.CadastrarResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.ResultadoSalvoDTO;
import com.searchtecnologia.recurso.service.resultado.dto.TiposResultadoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Recurso", description = "Apis para manipular recursos")
@RequestMapping("/api/v1/resultados")
@AllArgsConstructor
@RestController
public class ResultadoController {

    private final ResultadoService resultadoService;

    /** END POINTS DE CONSULTA **/
    @Operation(summary = "Listar", description = "Listar resultados de recursos")
    @GetMapping("/listar-resultados")
    public ResponseEntity<List<ResultadoDTO>> listarResultados(@RequestParam(required = false) String codigoResultado,
                                                               @RequestParam(required = false)String descricaoResultado,
                                                               @RequestParam(required = false)String tipoRecurso,
                                                               @RequestParam(required = false)String tipoJulgamento,
                                                               @RequestParam(required = false)String ativos,
                                                               @RequestParam(required = false)String orgaoAnalisador) {
        List<ResultadoDTO> resultados = resultadoService.listarResultados(codigoResultado, descricaoResultado, tipoJulgamento,
                tipoRecurso, ativos, orgaoAnalisador);
        if (resultados != null) {
            return ResponseEntity.ok(resultados);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Listar", description = "Listar tipos de resultados de recursos")
    @GetMapping("/listar-tipos-resultados")
    public ResponseEntity<List<TiposResultadoDTO>> listarTiposResultado() {
        List<TiposResultadoDTO> resultados = resultadoService.listarTiposResultado();
        if (resultados != null) {
            return ResponseEntity.ok(resultados);
        }
        return ResponseEntity.notFound().build();
    }

    /** END POINTS DE VALIDAÇÃO **/
    @Operation(summary = "Verificar", description = "Verifica se o resuiltado existe")
    @GetMapping("/verifica-existencia")
    public ResponseEntity<?> listarResultados(@RequestParam(required = false) String codigoResultado) {
        String resultado = resultadoService.veirificarSeExiste(codigoResultado);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }

    /** END POINTS DE CADASTRO**/
    @Operation(summary = "Cadastrar", description = "Cadastra um resultado de recurso")
    @PostMapping("/resultado")
    public ResponseEntity<ResultadoSalvoDTO> salvarResultado(@RequestBody @Valid CadastrarResultadoDTO cadastrarResultadoDTO) {
        ResultadoSalvoDTO resultadoSalvoDTO = resultadoService.salvarResultado(cadastrarResultadoDTO);
        return ResponseEntity.ok(resultadoSalvoDTO);
    }

}
