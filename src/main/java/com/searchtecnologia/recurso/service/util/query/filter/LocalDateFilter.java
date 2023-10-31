package com.searchtecnologia.recurso.service.util.query.filter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class LocalDateFilter extends RangeFilter<LocalDate> {

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setEquals(LocalDate equals) {
        super.setEquals(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setGreaterOrEqualThan(LocalDate greaterOrEqualThan) {
        super.setGreaterOrEqualThan(greaterOrEqualThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setGreaterThan(LocalDate greaterThan) {
        super.setGreaterThan(greaterThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setLessOrEqualThan(LocalDate lessOrEqualThan) {
        super.setLessOrEqualThan(lessOrEqualThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setLessThan(LocalDate lessThan) {
        super.setLessThan(lessThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.DATE_TIME)
    public void setIn(List<LocalDate> in) {
        super.setIn(in);
    }

    public static LocalDateFilter buildEquals(LocalDate value) {
        LocalDateFilter equalsFilter = new LocalDateFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static LocalDateFilter buildIn(List<LocalDate> values) {
        LocalDateFilter inFilter = new LocalDateFilter();
        inFilter.setIn(values);
        return inFilter;
    }

    public static LocalDateFilter buildGreaterOrEqualThan(LocalDate value) {
        LocalDateFilter greaterOrEqualThanFilter = new LocalDateFilter();
        greaterOrEqualThanFilter.setGreaterOrEqualThan(value);
        return greaterOrEqualThanFilter;
    }

    public static LocalDateFilter buildGreaterThan(LocalDate value) {
        LocalDateFilter greaterThanFilter = new LocalDateFilter();
        greaterThanFilter.setGreaterThan(value);
        return greaterThanFilter;
    }

    public static LocalDateFilter buildLessOrEqualThan(LocalDate value) {
        LocalDateFilter lessOrEqualThanFilter = new LocalDateFilter();
        lessOrEqualThanFilter.setLessOrEqualThan(value);
        return lessOrEqualThanFilter;
    }

    public static LocalDateFilter buildLessThan(LocalDate value) {
        LocalDateFilter lessThanFilter = new LocalDateFilter();
        lessThanFilter.setLessThan(value);
        return lessThanFilter;
    }
}