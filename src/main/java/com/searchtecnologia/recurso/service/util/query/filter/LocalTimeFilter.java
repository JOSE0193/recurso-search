package com.searchtecnologia.recurso.service.util.query.filter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class LocalTimeFilter extends RangeFilter<LocalTime> {

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setEquals(LocalTime equals) {
        super.setEquals(equals);
    }

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setGreaterOrEqualThan(LocalTime greaterOrEqualThan) {
        super.setGreaterOrEqualThan(greaterOrEqualThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setGreaterThan(LocalTime greaterThan) {
        super.setGreaterThan(greaterThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setLessOrEqualThan(LocalTime lessOrEqualThan) {
        super.setLessOrEqualThan(lessOrEqualThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setLessThan(LocalTime lessThan) {
        super.setLessThan(lessThan);
    }

    @Override
    @DateTimeFormat(iso = ISO.TIME)
    public void setIn(List<LocalTime> in) {
        super.setIn(in);
    }

    public static LocalTimeFilter buildEquals(LocalTime value) {
        LocalTimeFilter equalsFilter = new LocalTimeFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static LocalTimeFilter buildIn(List<LocalTime> values) {
        LocalTimeFilter inFilter = new LocalTimeFilter();
        inFilter.setIn(values);
        return inFilter;
    }

    public static LocalTimeFilter buildGreaterOrEqualThan(LocalTime value) {
        LocalTimeFilter greaterOrEqualThanFilter = new LocalTimeFilter();
        greaterOrEqualThanFilter.setGreaterOrEqualThan(value);
        return greaterOrEqualThanFilter;
    }

    public static LocalTimeFilter buildGreaterThan(LocalTime value) {
        LocalTimeFilter greaterThanFilter = new LocalTimeFilter();
        greaterThanFilter.setGreaterThan(value);
        return greaterThanFilter;
    }

    public static LocalTimeFilter buildLessOrEqualThan(LocalTime value) {
        LocalTimeFilter lessOrEqualThanFilter = new LocalTimeFilter();
        lessOrEqualThanFilter.setLessOrEqualThan(value);
        return lessOrEqualThanFilter;
    }

    public static LocalTimeFilter buildLessThan(LocalTime value) {
        LocalTimeFilter lessThanFilter = new LocalTimeFilter();
        lessThanFilter.setLessThan(value);
        return lessThanFilter;
    }
}