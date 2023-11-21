package com.searchtecnologia.recurso.service.processo.query.criteria;

import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
import com.searchtecnologia.recurso.service.util.query.filter.LocalDateFilter;
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
public class DadosProcessoCriteria implements Serializable {

    private StringFilter numeroProcesso;
    private StringFilter placa;
    private StringFilter numeroAuto;
    private StringFilter situacao;
    private StringFilter relator;
    private LocalDateFilter dataInicio;
    private LocalDateFilter dataFim;
    private StringFilter nomeRequerente;
    private StringFilter orgaoInterno;
    private TipoRecursoFilter tipoRecurso;
    private StringFilter orgaoProcesso;
    private StringFilter orgaoAnalisador;

}
