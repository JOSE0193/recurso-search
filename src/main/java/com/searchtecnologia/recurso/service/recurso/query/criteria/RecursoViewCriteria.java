package com.searchtecnologia.recurso.service.recurso.query.criteria;

import com.searchtecnologia.recurso.service.recurso.query.filter.StatusRecursoFilter;
import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
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
public class RecursoViewCriteria implements Serializable {

    private StringFilter numeroProcesso;
    private StringFilter orgaoAnalisador;
    private TipoRecursoFilter tipoRecurso;
    private StatusRecursoFilter statusRecurso;

}
