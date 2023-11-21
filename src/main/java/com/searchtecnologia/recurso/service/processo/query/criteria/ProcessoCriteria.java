package com.searchtecnologia.recurso.service.processo.query.criteria;

import com.searchtecnologia.recurso.service.resultado.query.filter.TipoJulgamentoResultadoFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.TipoRecursoResultadoFilter;
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
public class ProcessoCriteria implements Serializable{

    private StringFilter numeroProcesso;
    private StringFilter situacao;
    private TipoJulgamentoResultadoFilter tipoJulgamentoResultado;
    private TipoRecursoResultadoFilter tipoRecursoResultado;

}
