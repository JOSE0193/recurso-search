package com.searchtecnologia.recurso.service.relator.query.filter;

import com.searchtecnologia.recurso.model.jari.TipoJari;
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
public class TipoJariFilter extends Filter<TipoJari> {

    public static TipoJariFilter buildEquals(TipoJari value) {
        TipoJariFilter equalsFilter = new TipoJariFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static TipoJariFilter buildIn(List<TipoJari> values) {
        TipoJariFilter inFilter = new TipoJariFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
