package com.searchtecnologia.recurso.service.advertencia.query.criteria;

import com.searchtecnologia.recurso.service.util.query.filter.LongFilter;
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
public class AutoAutorizacaoCriteria implements Serializable {

    private StringFilter numeroMulta;
    private StringFilter orgaoAutuador;
    private StringFilter codigoInfracao;
    private LongFilter autorizacaoAdvertencia;

}
