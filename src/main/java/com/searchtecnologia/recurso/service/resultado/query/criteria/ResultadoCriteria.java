package com.searchtecnologia.recurso.service.resultado.query.criteria;

import com.searchtecnologia.recurso.service.resultado.query.filter.AtivoFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.TipoJulgamentoFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.TipoRecursoResultadoFilter;
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
public class ResultadoCriteria implements Serializable {

    private StringFilter codigoResultado;
    private StringFilter descricaoResultado;
    private StringFilter tipoRecurso;
    private StringFilter ativoResultado;
    private StringFilter ativoMotivo;
    private StringFilter tipoJulgamento;
    private StringFilter orgaoAnalisador;

}
