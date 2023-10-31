package com.searchtecnologia.recurso.model.resultado;

import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class ResultadoGeralPK {

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MM_TRGE_CODIGO")
    private String codigo;

}
