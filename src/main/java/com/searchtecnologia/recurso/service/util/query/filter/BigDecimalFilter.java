package com.searchtecnologia.recurso.service.util.query.filter;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class BigDecimalFilter extends RangeFilter<BigDecimal> {

    public static BigDecimalFilter buildEquals(BigDecimal value) {
        BigDecimalFilter equalsFilter = new BigDecimalFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static BigDecimalFilter buildIn(List<BigDecimal> values) {
        BigDecimalFilter inFilter = new BigDecimalFilter();
        inFilter.setIn(values);
        return inFilter;
    }

    public static BigDecimalFilter buildGreaterOrEqualThan(BigDecimal value) {
        BigDecimalFilter greaterOrEqualThanFilter = new BigDecimalFilter();
        greaterOrEqualThanFilter.setGreaterOrEqualThan(value);
        return greaterOrEqualThanFilter;
    }

    public static BigDecimalFilter buildGreaterThan(BigDecimal value) {
        BigDecimalFilter greaterThanFilter = new BigDecimalFilter();
        greaterThanFilter.setGreaterThan(value);
        return greaterThanFilter;
    }

    public static BigDecimalFilter buildLessOrEqualThan(BigDecimal value) {
        BigDecimalFilter lessOrEqualThanFilter = new BigDecimalFilter();
        lessOrEqualThanFilter.setLessOrEqualThan(value);
        return lessOrEqualThanFilter;
    }

    public static BigDecimalFilter buildLessThan(BigDecimal value) {
        BigDecimalFilter lessThanFilter = new BigDecimalFilter();
        lessThanFilter.setLessThan(value);
        return lessThanFilter;
    }
}
