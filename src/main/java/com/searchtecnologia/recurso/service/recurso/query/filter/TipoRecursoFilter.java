package com.searchtecnologia.recurso.service.recurso.query.filter;

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
public class TipoRecursoFilter extends Filter<TipoRecurso> {

    public static TipoRecursoFilter buildEquals(TipoRecurso value) {
        TipoRecursoFilter equalsFilter = new TipoRecursoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoRecursoFilter buildIn(List<TipoRecurso> values) {
        TipoRecursoFilter inFilter = new TipoRecursoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
