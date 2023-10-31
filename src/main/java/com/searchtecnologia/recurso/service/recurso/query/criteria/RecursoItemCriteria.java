package com.searchtecnologia.recurso.service.recurso.query.criteria;

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
public class RecursoItemCriteria implements Serializable {

    private StringFilter codigoOrgaoAutuador;
    private StringFilter numeroAutoInfracao;
    private StringFilter sequencialAutoInfracao;
    private StringFilter codigoOrgaoAnalisadorRecurso;
    private TipoRecursoFilter tipoRecurso;

}