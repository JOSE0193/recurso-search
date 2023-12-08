package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.cancelamento.CancelamentoService;
import com.searchtecnologia.recurso.service.cancelamento.dto.CancelamentoDTO;
import com.searchtecnologia.recurso.service.infrator.InfratorService;
import com.searchtecnologia.recurso.service.multa.MultaService;
import com.searchtecnologia.recurso.service.pagamento.RegistroPagamentoService;
import com.searchtecnologia.recurso.service.parcelamento.ParcelamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Multa", description = "Apis para manipular multas")
@RestController
@RequestMapping("/api/v1/multas")
@AllArgsConstructor
public class MultaController {

    private MultaService service;
    private CancelamentoService cancelamentoService;
    private ParcelamentoService parcelamentoService;
    private InfratorService infratorService;
    private RegistroPagamentoService registroPagamentoService;

    /** END POINTS DE CONSULTA **/
    @Operation(summary = "Listar", description = "lista cancelamentos ocorridos")
    @GetMapping("/listar-cancelamentos")
    public ResponseEntity<List<?>> listarCancelamentos(@RequestParam(required = false) String numeroAuto,
                                                       @RequestParam(required = false) String sequencial,
                                                       @RequestParam(required = false) String orgaoAutuador) {
        List<CancelamentoDTO> cancelamentos = cancelamentoService.listarCancelamentos(numeroAuto, sequencial, orgaoAutuador);
        if (cancelamentos != null) {
            return ResponseEntity.ok(cancelamentos);
        }
        return ResponseEntity.notFound().build();
    }

    /** END POINTS DE VALIDAÇÃO **/
    @Operation(summary = "Verificar", description = "Verifica se a multa possui cancelamento")
    @GetMapping("/possui-cancelamento")
    public ResponseEntity<?> possuiCancelamento(@RequestParam(required = false) String numeroAuto,
                                                @RequestParam(required = false) String sequencial,
                                                @RequestParam(required = false) String orgaoAutuador) {
        String cancelamento = cancelamentoService.possuiCancelamento(numeroAuto, sequencial, orgaoAutuador);
        if (cancelamento != null) {
            return ResponseEntity.ok(cancelamento);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Verificar", description = "Verifica se a multa possui parcelamento")
    @GetMapping("/possui-parcelamento")
    public ResponseEntity<?> possuiParcelamento(@RequestParam(required = false) String numeroAuto,
                                                @RequestParam(required = false) String sequencial,
                                                @RequestParam(required = false) String orgaoAutuador) {
        String resultado = parcelamentoService.possuiParcelamento(numeroAuto, sequencial, orgaoAutuador);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Verificar", description = "Verifica se histórico do infrator")
    @GetMapping("/possui-hist-infrator")
    public ResponseEntity<?> possuiHistInfrator(@RequestParam(required = false) String numeroAuto,
                                                @RequestParam(required = false) String sequencial,
                                                @RequestParam(required = false) String orgaoAutuador) {
        String resultado = infratorService.possuiHistoricoInfrator(numeroAuto, sequencial, orgaoAutuador);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Verificar", description = "Verifica se histórico do infrator")
    @GetMapping("/possui-hist-pagamento")
    public ResponseEntity<?> possuiHistPagamento(@RequestParam(required = false) String numeroAuto,
                                                @RequestParam(required = false) String codigoInfracao,
                                                @RequestParam(required = false) String orgaoAutuador) {
        String resultado = registroPagamentoService.possuiHistoricoPagamento(numeroAuto, codigoInfracao, orgaoAutuador);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }


}
