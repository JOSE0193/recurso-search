package com.searchtecnologia.recurso.model.relator;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class RelatorPK implements Serializable {

    @NotNull
    @Column(name = "MM_REL_CODIGO")
    private String codigo;

    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgaoAutuador;

}