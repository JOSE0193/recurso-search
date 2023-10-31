package com.searchtecnologia.recurso.service.ocorrenciarenainf;

import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OcorrenciaRenainfService {

    OcorrenciaRenainf salvar(OcorrenciaRenainf ocorrenciaRenainf);

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_CONTROLE.FNC_BUSCA_PROCESSO_ORIGINAL
     */
    Optional<OcorrenciaRenainf> obterProcessoOriginal(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia, Boolean recursoCetran);

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_CONTROLE.FNC_BUSCA_PROCESSO_ORIGINAL
     */
    Optional<OcorrenciaRenainf> obterProcessoOriginal(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia);

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_CONTROLE.FNC_PEGAR_DATA_OCOR_VALIDA
     */
    Optional<LocalDateTime> obterDataValida(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia, Boolean recursoCetran);

    /**
     * FUNÇÃO: PKG_SGM_RECURSO_CONTROLE.FNC_POSSUI_OCORRENCIA_VALIDA
     */
    String possuiOcorrenciaValida(String orgaoAutuador, String numeroAuto, String numeroSequencial, String tipoOcorrencia);

}