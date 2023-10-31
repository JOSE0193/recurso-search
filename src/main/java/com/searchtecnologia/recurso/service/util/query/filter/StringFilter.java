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
public class StringFilter extends Filter<String> {

    private String contains;

    public static StringFilter buildEquals(String value) {
        StringFilter equalsFilter = new StringFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static StringFilter buildIn(List<String> values) {
        StringFilter inFilter = new StringFilter();
        inFilter.setIn(values);
        return inFilter;
    }

    public static StringFilter buildContains(String value) {
        StringFilter containsFilter = new StringFilter();
        containsFilter.setContains(value);
        return containsFilter;
    }
}
