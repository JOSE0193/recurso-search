package com.searchtecnologia.recurso.service.relator.query.criteria;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.service.recurso.query.filter.TipoRecursoFilter;
import com.searchtecnologia.recurso.service.relator.query.filter.TipoJariFilter;
import com.searchtecnologia.recurso.service.resultado.query.filter.AtivoFilter;
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
public class RelatorCriteria implements Serializable {

    private StringFilter codigo;
    private StringFilter nome;
    private StringFilter jari;
    private StringFilter tipoJari;
    private StringFilter orgaoAutuador;
    private StringFilter ativo;

}