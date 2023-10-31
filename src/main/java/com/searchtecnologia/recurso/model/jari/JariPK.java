package com.searchtecnologia.recurso.model.jari;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class JariPK {

    @NotNull
    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgaoAutuador;

    @NotNull
    @Column(name = "MM_TJAR_CODIGO")
    private String codigo;

}
