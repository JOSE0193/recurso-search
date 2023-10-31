package com.searchtecnologia.recurso.service.resultado.query.filter;

import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.model.resultado.SimNao;
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
public class AtivoFilter extends Filter<SimNao> {

    public static AtivoFilter buildEquals(SimNao value) {
        AtivoFilter equalsFilter = new AtivoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static AtivoFilter buildIn(List<SimNao> values) {
        AtivoFilter inFilter = new AtivoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
