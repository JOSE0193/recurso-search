package com.searchtecnologia.recurso.service.recurso.query.filter;

import com.searchtecnologia.recurso.model.recurso.StatusRecurso;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.service.util.query.filter.Filter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class StatusRecursoFilter extends Filter<StatusRecurso> {
    public static StatusRecursoFilter buildEquals(StatusRecurso value) {
        StatusRecursoFilter equalsFilter = new StatusRecursoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static StatusRecursoFilter buildIn(List<StatusRecurso> values) {
        StatusRecursoFilter inFilter = new StatusRecursoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
