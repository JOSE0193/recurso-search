package com.searchtecnologia.recurso.service.resultado.query.filter;

import com.searchtecnologia.recurso.model.resultado.TipoJulgamentoResultado;
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
public class TipoJulgamentoFilter extends Filter<TipoJulgamentoResultado> {

    public static TipoJulgamentoFilter buildEquals(TipoJulgamentoResultado value) {
        TipoJulgamentoFilter equalsFilter = new TipoJulgamentoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoJulgamentoFilter buildIn(List<TipoJulgamentoResultado> values) {
        TipoJulgamentoFilter inFilter = new TipoJulgamentoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
