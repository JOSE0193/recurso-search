package com.searchtecnologia.recurso.service.ocorrenciarenainf.query.criteria;

import com.searchtecnologia.recurso.service.util.query.filter.LocalDateFilter;
import com.searchtecnologia.recurso.service.util.query.filter.LocalTimeFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OcorrenciaRenainfCriteria implements Serializable {

    private StringFilter codigoOrgaoAutuador;
    private StringFilter numeroAutoInfracao;
    private StringFilter sequencialAutoInfracao;
    private StringFilter tipoOcorrencia;
    private StringFilter orgaoOrigemOcorrencia;
    private StringFilter resultadoExecucao;
    private LocalDateFilter dataOcorrencia;
    private LocalTimeFilter horaOcorrencia;
}