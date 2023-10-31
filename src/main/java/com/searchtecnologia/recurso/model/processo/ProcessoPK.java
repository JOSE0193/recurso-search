package com.searchtecnologia.recurso.model.processo;

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
public class ProcessoPK implements Serializable {

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_PROC_PLACA")
    private String placa;

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_PROC_NUMERO")
    private String numero;

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_PROC_MUNICIPIO")
    private String municipio;

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_PROC_AUTO")
    private String numeroAuto;

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_PROC_SEQUENCIAL")
    private String sequencial;

}

