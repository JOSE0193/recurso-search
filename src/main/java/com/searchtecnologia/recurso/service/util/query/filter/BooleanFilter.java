package com.searchtecnologia.recurso.service.util.query.filter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class BooleanFilter extends Filter<Boolean> {

    public static BooleanFilter buildEquals(Boolean value) {
        BooleanFilter equalsFilter = new BooleanFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static BooleanFilter buildIn(List<Boolean> values) {
        BooleanFilter inFilter = new BooleanFilter();
        inFilter.setIn(values);
        return inFilter;
    }
}
