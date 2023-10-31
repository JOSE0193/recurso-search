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
public class IntegerFilter extends RangeFilter<Integer> {

    public static IntegerFilter buildEquals(Integer value) {
        IntegerFilter equalsFilter = new IntegerFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static IntegerFilter buildIn(List<Integer> values) {
        IntegerFilter inFilter = new IntegerFilter();
        inFilter.setIn(values);
        return inFilter;
    }

    public static IntegerFilter buildGreaterOrEqualThan(Integer value) {
        IntegerFilter greaterOrEqualThanFilter = new IntegerFilter();
        greaterOrEqualThanFilter.setGreaterOrEqualThan(value);
        return greaterOrEqualThanFilter;
    }

    public static IntegerFilter buildGreaterThan(Integer value) {
        IntegerFilter greaterThanFilter = new IntegerFilter();
        greaterThanFilter.setGreaterThan(value);
        return greaterThanFilter;
    }

    public static IntegerFilter buildLessOrEqualThan(Integer value) {
        IntegerFilter lessOrEqualThanFilter = new IntegerFilter();
        lessOrEqualThanFilter.setLessOrEqualThan(value);
        return lessOrEqualThanFilter;
    }

    public static IntegerFilter buildLessThan(Integer value) {
        IntegerFilter lessThanFilter = new IntegerFilter();
        lessThanFilter.setLessThan(value);
        return lessThanFilter;
    }
}
