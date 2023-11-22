package com.searchtecnologia.recurso.model.cancelamento;

import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class MotivoCancelamentoPK implements Serializable {

    @NotNull
    @Column(name = "MU_MOT_CODIGO")
    @Type(StringEmptyType.class)
    private String codigo;

    @NotNull
    @Column(name = "DT_MUNIC_CODIGO")
    @Type(StringEmptyType.class)
    private String municipio; //TODO TABELA MULTA.MMA1MULT, COLUNA DT_MUNIC_CODIGO DA MAPEAR ENTIDADE?

}
