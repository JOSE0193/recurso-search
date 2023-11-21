package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.ocorrenciarenainf.OcorrenciaRenainfService;
import com.searchtecnologia.recurso.service.processo.ProcessoService;
import com.searchtecnologia.recurso.service.processo.dto.DadosProcessoDTO;
import com.searchtecnologia.recurso.service.processo.dto.TipoProcessoDTO;
import com.searchtecnologia.recurso.service.recurso.RecursoService;
import com.searchtecnologia.recurso.service.recurso.dto.CadastrarRecursoDTO;
import com.searchtecnologia.recurso.service.recurso.dto.RecursoDTO;
import com.searchtecnologia.recurso.service.relator.RelatorService;
import com.searchtecnologia.recurso.service.relator.dto.CadastroRelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorSalvoDTO;
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
@RequestMapping("/api/v1/recursos")
@AllArgsConstructor
@RestController
public class RecursoController {

    private final RecursoService service;
    private final ResultadoService resultadoService;
    private final RelatorService relatorService;
    private final OcorrenciaRenainfService ocorrenciaRenainfService;
    private final ProcessoService processoService;

    /** END POINTS DE CONSULTA **/
    @Operation(summary = "Listar", description = "Listar resultados de recursos")
    @GetMapping("/listar-resultados")
    public ResponseEntity<List<ResultadoDTO>> listarResultados( @RequestParam(required = false) String codigoResultado,
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

    @Operation(summary = "Listar", description = "Listar relatores")
    @GetMapping("/listar-relatores")
    public ResponseEntity<List<RelatorDTO>> listaRelatores(@RequestParam(required = false)String codigoRelator,
                                                           @RequestParam(required = false)String descricaoRelator,
                                                           @RequestParam(required = false)String orgaoRelator,
                                                           @RequestParam(required = false)String codigoJari,
                                                           @RequestParam(required = false)String tipoJari,
                                                           @RequestParam(required = false)String ativo) {
        List<RelatorDTO> relatores = relatorService.listarRelatores(codigoRelator, descricaoRelator, orgaoRelator, codigoJari,
                tipoJari, ativo);
        if (relatores != null) {
            return ResponseEntity.ok(relatores);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Consultar ", description = "Buscar dados de um processo")
    @GetMapping("/consultar-processo")
    public ResponseEntity<?> consulta(@RequestParam(required = false) String numeroProcesso,
                                      @RequestParam(required = false) String placa,
                                      @RequestParam(required = false) String numeroAuto,
                                      @RequestParam(required = false) String situacao,
                                      @RequestParam(required = false) String relator,
                                      @RequestParam(required = false) String dataInicio,
                                      @RequestParam(required = false) String dataFim,
                                      @RequestParam(required = false) String nomeRequerente,
                                      @RequestParam(required = false) String orgaoInterno,
                                      @RequestParam(required = false) String tipoRecurso,
                                      @RequestParam(required = false) String orgaoProcesso,
                                      @RequestParam(required = false) String orgaoAnalisador
    ) {
        List<DadosProcessoDTO> processos = processoService.consultarProcesso(numeroProcesso, placa, numeroAuto, situacao,
                relator, dataInicio, dataFim, nomeRequerente, orgaoInterno, tipoRecurso, orgaoProcesso, orgaoAnalisador);
        if (processos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/requerimentos-permitidos")
    public ResponseEntity<List<?>> requerimentosPermitidos(@RequestParam String codigoOrgao){
        List<TipoProcessoDTO> lista = processoService.listaRequerimentoPermitido(codigoOrgao);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    /** END POINTS DE VALIDAÇÃO **/

    @GetMapping("/possui-ocorrencia-valida")
    public ResponseEntity<?> possuiOcorrenciaValida(String orgaoAutuador, String numeroAuto, String numeroSequencial,
                                                    String tipoOcorrencia){
        String ocorrencia = ocorrenciaRenainfService.possuiOcorrenciaValida(orgaoAutuador, numeroAuto, numeroSequencial, tipoOcorrencia);
        if (ocorrencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ocorrencia);
    }

    /** END POINTS DE CADASTRO**/
    @Operation(summary = "Cadastrar", description = "Cadastra um recurso")
    @PostMapping("/recurso")
    public ResponseEntity<RecursoDTO> cadastrar(@RequestBody @Valid CadastrarRecursoDTO cadastrarRecursoDTO) {
        RecursoDTO recursoDTO = this.service.cadastrarRecurso(cadastrarRecursoDTO);
        return ResponseEntity.ok(recursoDTO);
    }

    @Operation(summary = "Cadastrar Resultado", description = "Cadastra um resultado de recurso")
    @PostMapping("/resultado")
    public ResponseEntity<ResultadoSalvoDTO> salvarResultado(@RequestBody @Valid CadastrarResultadoDTO cadastrarResultadoDTO) {
        ResultadoSalvoDTO resultadoSalvoDTO = resultadoService.salvarResultado(cadastrarResultadoDTO);
        return ResponseEntity.ok(resultadoSalvoDTO);
    }

    @Operation(summary = "Cadastrar relator", description = "Cadastra ou atualizar relator")
    @PostMapping("/relator")
    public ResponseEntity<RelatorSalvoDTO> salvarRelator(@RequestBody @Valid CadastroRelatorDTO cadastroRelatorDTO) {
        RelatorSalvoDTO salvarRelator = relatorService.salvarRelator(cadastroRelatorDTO);
        return ResponseEntity.ok(salvarRelator);
    }



}