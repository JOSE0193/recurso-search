package com.searchtecnologia.recurso.service.resultado.query.filter;

import com.searchtecnologia.recurso.model.resultado.TipoRecursoResultado;
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
public class TipoRecursoResultadoFilter extends Filter<TipoRecursoResultado> {

    public static TipoRecursoResultadoFilter buildEquals(TipoRecursoResultado value) {
        TipoRecursoResultadoFilter equalsFilter = new TipoRecursoResultadoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoRecursoResultadoFilter buildIn(List<TipoRecursoResultado> values) {
        TipoRecursoResultadoFilter inFilter = new TipoRecursoResultadoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
