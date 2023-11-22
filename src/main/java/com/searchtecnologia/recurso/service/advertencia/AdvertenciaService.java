package com.searchtecnologia.recurso.service.advertencia;

import com.searchtecnologia.recurso.service.advertencia.dto.AdvertenciaDTO;

import java.util.List;

public interface AdvertenciaService {

    List<AdvertenciaDTO> listarAdvertencias(String numeroAuto, String codigoOrgao, String codigoInfracao);

    String validaConcluirSolicitacao(String numeroProcesso, String orgaoAnalizador, String indeferido);

}