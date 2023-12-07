package com.searchtecnologia.recurso.controller.v1;

import com.searchtecnologia.recurso.service.advertencia.AdvertenciaService;
import com.searchtecnologia.recurso.service.advertencia.dto.AdvertenciaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Advertencia", description = "Apis para manipular advertências")
@RequestMapping("/api/v1/advertencias")
@AllArgsConstructor
@RestController
public class AdvertenciaController {

    private final AdvertenciaService advertenciaService;

    /** END POINTS DE CONSULTA **/
    @Operation(summary = "Listar", description = "lista as advertências de determinado auto")
    @GetMapping("/listar-advertencias")
    public ResponseEntity<List<AdvertenciaDTO>> listarAdvertencias(@RequestParam(required = false) String numeroAuto,
                                                                   @RequestParam(required = false) String codigoOrgao,
                                                                   @RequestParam(required = false) String codigoInfracao){
        List<AdvertenciaDTO> advertencias = advertenciaService.listarAdvertencias(numeroAuto, codigoOrgao,codigoInfracao);
        if (advertencias != null) {
            return ResponseEntity.ok(advertencias);
        }
        return ResponseEntity.notFound().build();
    }

    /** END POINTS DE VALIDAÇÃO **/
    @Operation(summary = "Validar", description = "Valida o processo")
    @GetMapping("/valida-concluir-solicitacao")
    public ResponseEntity<String> validaConcluirSolicitacao(@RequestParam String numeroProcesso, @RequestParam String orgaoAnalizador, @RequestParam String soIndeferido) {
        String retorno = advertenciaService.validaConcluirSolicitacao(numeroProcesso, orgaoAnalizador, soIndeferido);
        return ResponseEntity.ok(retorno);
    }

}
