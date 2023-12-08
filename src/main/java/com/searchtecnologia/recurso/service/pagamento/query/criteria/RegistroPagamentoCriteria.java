package com.searchtecnologia.recurso.service.pagamento.query.criteria;

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
public class RegistroPagamentoCriteria implements Serializable {

    private StringFilter numeroAuto;
    private StringFilter codigoInfracao;
    private StringFilter orgaoAutuador;

}
