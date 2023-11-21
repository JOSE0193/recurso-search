package com.searchtecnologia.recurso.service.processo.impl;

import com.searchtecnologia.recurso.controller.exception.ObjectNotFoundException;
import com.searchtecnologia.recurso.model.processo.DadosProcessoView;
import com.searchtecnologia.recurso.model.processo.OrgaoLotacaoTipoProcesso;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.repository.processo.DadosProcessoRepository;
import com.searchtecnologia.recurso.repository.processo.OrgaoLotacaoTipoProcessoRepository;
import com.searchtecnologia.recurso.service.processo.ProcessoService;
import com.searchtecnologia.recurso.service.processo.dto.DadosProcessoDTO;
import com.searchtecnologia.recurso.service.processo.dto.TipoProcessoDTO;
import com.searchtecnologia.recurso.service.processo.mapper.DadosProcessoMapper;
import com.searchtecnologia.recurso.service.processo.mapper.TipoProcessoMapper;
import com.searchtecnologia.recurso.service.processo.query.criteria.DadosProcessoCriteria;
import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
import com.searchtecnologia.recurso.service.util.query.convert.PlacaConverterService;
import com.searchtecnologia.recurso.service.util.query.filter.LocalDateFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.searchtecnologia.recurso.service.processo.query.specification.DadosProcessoSpecification.buildSpecification;

@Service
@Transactional
@AllArgsConstructor
public class ProcessoServiceImpl implements ProcessoService {

    private final DadosProcessoRepository dadosProcessoRepository;
    private final PlacaConverterService placaConverterService;
    private final DadosProcessoMapper dadosProcessoMapper;
    private final OrgaoLotacaoTipoProcessoRepository orgaoLotacaoTipoProcessoRepository;
    private final TipoProcessoMapper tipoProcessoMapper;

    public List<DadosProcessoDTO> consultarProcesso(String numeroProcesso, String placa, String numeroAuto,
                                                    String situacao, String relator, String dataInicio, String dataFim,
                                                    String nomeRequerente, String orgaoInterno, String tipoRecurso,
                                                    String orgaoProcesso, String orgaoAnalisador) {
        String placaConvertida = placaConverterService.convertPlacaMercosul(placa);

        if (numeroProcesso != null && !numeroProcesso.isEmpty()) {
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (placa != null && !placa.isEmpty()) {
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .placa(StringFilter.buildEquals(placaConvertida))
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoInterno(StringFilter.buildEquals(orgaoInterno))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (numeroAuto != null && !numeroAuto.isEmpty()) {
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .numeroAuto(StringFilter.buildEquals(numeroAuto))
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoInterno(StringFilter.buildEquals(orgaoInterno))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (situacao != null && !situacao.isEmpty()) {
            LocalDate dataInicioFormatada = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("ddMMyyyy"));
            LocalDate dataFimFormatada = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("ddMMyyyy"));
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .situacao(StringFilter.buildEquals(situacao))
                    .dataInicio(LocalDateFilter.buildGreaterOrEqualThan(dataInicioFormatada))
                    .dataFim(LocalDateFilter.buildLessOrEqualThan(dataFimFormatada))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoInterno(StringFilter.buildEquals(orgaoInterno))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (orgaoAnalisador != null && !orgaoAnalisador.isEmpty()) {
            LocalDate dataInicioFormatada = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("ddMMyyyy"));
            LocalDate dataFimFormatada = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("ddMMyyyy"));
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                    .dataInicio(LocalDateFilter.buildGreaterOrEqualThan(dataInicioFormatada))
                    .dataFim(LocalDateFilter.buildLessOrEqualThan(dataFimFormatada))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (relator != null && !relator.isEmpty()) {
            LocalDate dataInicioFormatada = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("ddMMyyyy"));
            LocalDate dataFimFormatada = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("ddMMyyyy"));
            List<DadosProcessoView> processos = dadosProcessoRepository.findProcessos(relator, String.valueOf(dataInicioFormatada),
                    String.valueOf(dataFimFormatada), tipoRecurso);
            return processos.stream().map(dadosProcessoMapper::toDTO).collect(Collectors.toList());
        }
        if (dataInicio != null && !dataInicio.trim().isEmpty() && dataFim != null && !dataFim.trim().isEmpty()) {
            LocalDate dataInicioFormatada = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("ddMMyyyy"));
            LocalDate dataFimFormatada = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("ddMMyyyy"));
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .dataInicio(LocalDateFilter.buildGreaterOrEqualThan(dataInicioFormatada))
                    .dataFim(LocalDateFilter.buildLessOrEqualThan(dataFimFormatada))
                    .numeroProcesso(StringFilter.buildEquals(numeroProcesso))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoAnalisador(StringFilter.buildEquals(orgaoAnalisador))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if (nomeRequerente.trim() != null && !nomeRequerente.trim().isEmpty()) {
            DadosProcessoCriteria criteria = DadosProcessoCriteria.builder()
                    .nomeRequerente(StringFilter.buildContains(nomeRequerente))
                    .tipoRecurso(TipoRecursoFilter.buildEquals(TipoRecurso.get(tipoRecurso)))
                    .orgaoProcesso(StringFilter.buildEquals(orgaoProcesso))
                    .orgaoInterno(StringFilter.buildEquals(orgaoInterno))
                    .build();
            return dadosProcessoRepository.findAll(buildSpecification(criteria))
                    .stream()
                    .map(dadosProcessoMapper::toDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<TipoProcessoDTO> listaRequerimentoPermitido(String orgao) {
        List<OrgaoLotacaoTipoProcesso> lista = orgaoLotacaoTipoProcessoRepository.findByCodigoOrgaoOrderByTipoProcesso(orgao);
        if (lista.isEmpty()) {
            throw new ObjectNotFoundException("Não foi possivel encontrar requerimentos permitidos no órgão buscado.");
        }
        return lista.stream().map(tipoProcessoMapper::toDTO).collect(Collectors.toList());
    }

}
