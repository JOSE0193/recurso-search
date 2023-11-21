package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.advertencia.AdvertenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Recurso", description = "Apis para manipular advertências")
@RequestMapping("/api/v1/advertencias")
@AllArgsConstructor
@RestController
public class AdvertenciaController {

    private final AdvertenciaService advertenciaService;


    /** END POINTS DE VALIDAÇÃO **/
    @Operation(summary = "Validar", description = "Valida o processo")
    @GetMapping("/valida-concluir-solicitacao")
    public ResponseEntity<String> validaConcluirSolicitacao(@RequestParam String numeroProcesso, @RequestParam String orgaoAnalizador, @RequestParam String soIndeferido) {
        String retorno = advertenciaService.validaConcluirSolicitacao(numeroProcesso, orgaoAnalizador, soIndeferido);
        return ResponseEntity.ok(retorno);
    }

}
