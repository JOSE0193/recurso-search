package com.searchtecnologia.recurso.model.resultado;

import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class MotivoResultadoPK implements Serializable {

    @Type(StringEmptyType.class)
    @EqualsAndHashCode.Include
    @Column(name = "MM_MOJ_CODIGO")
    private String codigoMotivo;

    @Type(StringEmptyType.class)
    @EqualsAndHashCode.Include
    @Column(name = "MM_REJ_CODIGO")
    private String codigoResultado;

    @Type(StringEmptyType.class)
    @EqualsAndHashCode.Include
    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgao;

}
