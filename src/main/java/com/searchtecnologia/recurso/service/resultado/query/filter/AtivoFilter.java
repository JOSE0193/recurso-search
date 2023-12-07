package com.searchtecnologia.recurso.service.resultado.query.filter;

import com.searchtecnologia.recurso.model.resultado.DominioSimNao;
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
public class AtivoFilter extends Filter<DominioSimNao> {

    public static AtivoFilter buildEquals(DominioSimNao value) {
        AtivoFilter equalsFilter = new AtivoFilter();
        equalsFilter.setEquals(value);
        return equalsFilter;
    }

    public static AtivoFilter buildIn(List<DominioSimNao> values) {
        AtivoFilter inFilter = new AtivoFilter();
        inFilter.setIn(values);
        return inFilter;
    }

}
