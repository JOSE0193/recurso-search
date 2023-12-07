package com.searchtecnologia.recurso.service.parcelamento.query.criteria;

import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AutoInfracaoParcelamentoCriteria implements Serializable {

    private StringFilter numeroAuto;
    private StringFilter sequencial;
    private StringFilter orgaoAutuador;

}
