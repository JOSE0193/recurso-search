package com.searchtecnologia.recurso.service.resultado.query.filter;

import com.searchtecnologia.recurso.model.resultado.TipoJulgamentoResultado;
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
public class TipoJulgamentoResultadoFilter extends Filter<TipoJulgamentoResultado> {

    public static TipoJulgamentoResultadoFilter buildEquals(TipoJulgamentoResultado value) {
        TipoJulgamentoResultadoFilter equalsFilter = new TipoJulgamentoResultadoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoJulgamentoResultadoFilter buildIn(List<TipoJulgamentoResultado> values) {
        TipoJulgamentoResultadoFilter inFilter = new TipoJulgamentoResultadoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
