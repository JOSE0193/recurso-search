package com.searchtecnologia.recurso.service.processo.query.filter;

import com.searchtecnologia.recurso.model.processo.TipoProcesso;
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
public class TipoProcessoFilter extends Filter<TipoProcesso> {

    public static TipoProcessoFilter buildEquals(TipoProcesso value) {
        TipoProcessoFilter equalsFilter = new TipoProcessoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoProcessoFilter buildIn(List<TipoProcesso> values) {
        TipoProcessoFilter inFilter = new TipoProcessoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
