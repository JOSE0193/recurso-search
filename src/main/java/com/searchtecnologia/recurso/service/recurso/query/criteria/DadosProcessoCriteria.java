package com.searchtecnologia.recurso.service.recurso.query.criteria;

import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DadosProcessoCriteria {

    private StringFilter numeroProcesso;
    private StringFilter placa;
    private StringFilter numeroAuto;
    private StringFilter situacao;
    private StringFilter relator;
    private StringFilter dataInicio;
    private StringFilter dataFim;
    private StringFilter nomeRequerente;
    private StringFilter orgaoInterno;
    private StringFilter  tipoRecurso;
    private StringFilter  orgaoProcesso;
    private StringFilter  orgaoAnalizador;

}
