package com.searchtecnologia.recurso.model.parcelamento;

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
public class AutoInfracaoParcelamentoPK implements Serializable  {

    @NotNull
    @Column(name = "FI_UCCV_CHASSI")
    @Type(StringEmptyType.class)
    private String chassi;

    @NotNull
    @Column(name = "FI_IDPC_NUM_PARCELAMENTO")
    @Type(StringEmptyType.class)
    private String numeroParcelamento;

    @NotNull
    @Column(name = "FI_IDPC_NUM_REVISAO")
    @Type(StringEmptyType.class)
    private String numeroRevisao;

    @NotNull
    @Column(name = "FI_GRPC_GRUPO")
    @Type(StringEmptyType.class)
    private String grupo;

    @NotNull
    @Column(name = "FI_AUTO_MUNICIPIO")
    @Type(StringEmptyType.class)
    private String autoMunicipio;

    @NotNull
    @Column(name = "FI_AUTO_NUMERO")
    @Type(StringEmptyType.class)
    private String autoNumero;

    @Column(name = "FI_AUTO_SEQUENCIAL")
    @Type(StringEmptyType.class)
    private String autoSequencial;

}
