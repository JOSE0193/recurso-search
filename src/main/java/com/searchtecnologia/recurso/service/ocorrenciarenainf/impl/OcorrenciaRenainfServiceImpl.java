package com.searchtecnologia.recurso.service.ocorrenciarenainf.impl;

import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainf;
import com.searchtecnologia.recurso.model.ocorrenciarenainf.OcorrenciaRenainfPK;
import com.searchtecnologia.recurso.repository.ocorrenciarenainf.OcorrenciaRenainfRepository;
import com.searchtecnologia.recurso.service.ocorrenciarenainf.OcorrenciaRenainfService;
import com.searchtecnologia.recurso.service.ocorrenciarenainf.query.criteria.OcorrenciaRenainfCriteria;
import com.searchtecnologia.recurso.service.util.query.filter.LocalDateFilter;
import com.searchtecnologia.recurso.service.util.query.filter.LocalTimeFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.searchtecnologia.recurso.service.ocorrenciarenainf.query.specification.OcorrenciaRenainfSpecification.buildEspecification;

@Service
@Transactional
@AllArgsConstructor
public class OcorrenciaRenainfServiceImpl implements OcorrenciaRenainfService {

    private OcorrenciaRenainfRepository repository;

    @Override
    public OcorrenciaRenainf salvar(OcorrenciaRenainf ocorrenciaRenainf) {
        return this.repository.save(ocorrenciaRenainf);
    }

    /**
     * FUNCTION: PKG_SGM_RECURSO_CONTROLE.FNC_BUSCA_PROCESSO_ORIGINAL
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OcorrenciaRenainf> obterProcessoOriginal(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia, Boolean recursoCetran) {
        Optional<LocalDateTime> dataOcorrencia = this.obterDataValida(codigoOrgaoAutuador, numeroAutoInfracao, sequenciaAutoInfracao, tipoOcorrencia, recursoCetran);

        if (dataOcorrencia.isPresent()) {
            OcorrenciaRenainfCriteria criteria = OcorrenciaRenainfCriteria.builder()
                    .codigoOrgaoAutuador(StringFilter.buildEquals(codigoOrgaoAutuador))
                    .numeroAutoInfracao(StringFilter.buildEquals(numeroAutoInfracao))
                    .sequencialAutoInfracao(StringFilter.buildEquals(sequenciaAutoInfracao))
                    .tipoOcorrencia(StringFilter.buildEquals(tipoOcorrencia))
                    .resultadoExecucao(StringFilter.buildEquals("000"))
                    .dataOcorrencia(LocalDateFilter.buildEquals(dataOcorrencia.get().toLocalDate()))
                    .horaOcorrencia(LocalTimeFilter.buildEquals(dataOcorrencia.get().toLocalTime()))
                    .build();

            ;
            return this.repository.findOne(buildEspecification(criteria));
        }

        return Optional.empty();
    }

    /**
     * FUNCTION: PKG_SGM_RECURSO_CONTROLE.FNC_BUSCA_PROCESSO_ORIGINAL
     * <p>
     * Obs.: recursoCetran igual a false
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OcorrenciaRenainf> obterProcessoOriginal(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia) {
        return this.obterProcessoOriginal(codigoOrgaoAutuador, numeroAutoInfracao, sequenciaAutoInfracao, tipoOcorrencia, false);
    }

    /**
     * FUNCTION: PKG_SGM_RECURSO_CONTROLE.FNC_PEGAR_DATA_OCOR_VALIDA
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LocalDateTime> obterDataValida(String codigoOrgaoAutuador, String numeroAutoInfracao, String sequenciaAutoInfracao, String tipoOcorrencia, Boolean recursoCetran) {

        OcorrenciaRenainfCriteria criteria = OcorrenciaRenainfCriteria.builder()
                .codigoOrgaoAutuador(StringFilter.buildEquals(codigoOrgaoAutuador))
                .numeroAutoInfracao(StringFilter.buildEquals(numeroAutoInfracao))
                .tipoOcorrencia(StringFilter.buildEquals(tipoOcorrencia))
                .sequencialAutoInfracao(StringFilter.buildEquals(sequenciaAutoInfracao))
                .orgaoOrigemOcorrencia(recursoCetran ? StringFilter.buildEquals("2") : null)
                .build();

        List<OcorrenciaRenainf> ocorrenciaRenainfs = this.repository.findAll(buildEspecification(criteria));

        LocalDate maiorData = ocorrenciaRenainfs.stream()
                .map(OcorrenciaRenainf::getId)
                .map(OcorrenciaRenainfPK::getDataOcorrencia)
                .max(LocalDate::compareTo)
                .orElse(null);

        if (Objects.isNull(maiorData)) return Optional.empty();

        LocalTime maiorHora = ocorrenciaRenainfs.stream()
                .filter(it -> it.getId().getDataOcorrencia().equals(maiorData))
                .map(OcorrenciaRenainf::getId)
                .map(OcorrenciaRenainfPK::getHoraOcorrencia)
                .max(LocalTime::compareTo)
                .orElse(null);

        if (Objects.isNull(maiorHora)) return Optional.empty();

        return Optional.of(LocalDateTime.of(maiorData, maiorHora));
    }

    /**
     * FUNCTION: PKG_SGM_RECURSO_CONTROLE.FNC_POSSUI_OCORRENCIA_VALIDA
     */
    @Override
    public String possuiOcorrenciaValida(String orgaoAutuador, String numeroAuto, String numeroSequencial, String tipoOcorrencia) {
        String retorno = "N";
        Optional<LocalDateTime> dataOcorrencia = obterDataValida(orgaoAutuador, numeroAuto, numeroSequencial, tipoOcorrencia, false);

        if (dataOcorrencia != null) {
            String tipoLancamento = buscarTipoLancamento(orgaoAutuador, numeroAuto, numeroSequencial, tipoOcorrencia, String.valueOf(dataOcorrencia));

            if (tipoLancamento.equals("1")) {
                retorno = "S";
            }
        }
        return retorno;
    }

    private String buscarTipoLancamento(String orgaoAutuador, String numeroAuto, String numeroSequencial, String tipoOcorrencia, String dataOcorrencia) {

        OcorrenciaRenainfCriteria criteria = OcorrenciaRenainfCriteria.builder()
                .codigoOrgaoAutuador(StringFilter.buildEquals(orgaoAutuador))
                .numeroAutoInfracao(StringFilter.buildEquals(numeroAuto))
                .sequencialAutoInfracao(StringFilter.buildEquals(numeroSequencial))
                .tipoOcorrencia(StringFilter.buildEquals(tipoOcorrencia))
                .dataOcorrencia(LocalDateFilter.buildEquals(LocalDate.parse(dataOcorrencia)))
                .horaOcorrencia(LocalTimeFilter.buildEquals(LocalTime.parse(dataOcorrencia)))
                .build();
        List<OcorrenciaRenainf> ocorrencias = repository.findAll(buildEspecification(criteria));

        if (!ocorrencias.isEmpty()) {
            OcorrenciaRenainf ocorrencia = ocorrencias.get(0);
            return ocorrencia.getTipoLancamento();
        }
        return "0";
    }

}