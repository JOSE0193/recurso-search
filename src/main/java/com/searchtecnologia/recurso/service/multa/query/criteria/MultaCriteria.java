package com.searchtecnologia.recurso.service.multa.query.criteria;

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
public class MultaCriteria implements Serializable {

    private StringFilter numero;
    private StringFilter sequencial;
    private StringFilter codigoOrgaoAutuador;
}