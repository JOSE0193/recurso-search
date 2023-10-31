package com.searchtecnologia.recurso.service.util.query.filter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Filter<FIELD_TYPE> implements Serializable {

    private FIELD_TYPE equals;
    private List<FIELD_TYPE> in;
}