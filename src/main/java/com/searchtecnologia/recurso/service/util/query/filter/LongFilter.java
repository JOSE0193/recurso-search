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
public class LongFilter extends Filter<Long> {

    public static LongFilter buildEquals(Long value) {
        LongFilter equalsFilter = new LongFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static LongFilter buildIn(List<Long> values) {
        LongFilter inFilter = new LongFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
