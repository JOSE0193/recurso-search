package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.relator.RelatorService;
import com.searchtecnologia.recurso.service.relator.dto.CadastroRelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorDTO;
import com.searchtecnologia.recurso.service.relator.dto.RelatorSalvoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Relator", description = "Apis para manipular relatores")
@RequestMapping("/api/v1/relatores")
@AllArgsConstructor
@RestController
public class RelatorController {

    private final RelatorService relatorService;

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
    @Operation(summary = "Verificar", description = "Verifica se o relator existe")
    @GetMapping("/verificar-se-existe")
    public ResponseEntity<String> veirificarSeExiste(String codigo){
        String resultado = relatorService.veirificarSeExiste(codigo);
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Cadastrar", description = "Gerar codigo do relator")
    @PostMapping("/gerar-codigo")
    public ResponseEntity<?> gerarCodigoRelator() {
        String resultado = relatorService.gerarCodigoRelator();
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Cadastrar", description = "Cadastra ou atualizar relator")
    @PostMapping("/salvar-relator")
    public ResponseEntity<RelatorSalvoDTO> salvarRelator(@RequestBody @Valid CadastroRelatorDTO cadastroRelatorDTO) {
        RelatorSalvoDTO salvarRelator = relatorService.salvarRelator(cadastroRelatorDTO);
        return ResponseEntity.ok(salvarRelator);
    }

}
