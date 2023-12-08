package com.searchtecnologia.recurso.model.infrator;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class HistoricoInfratorPK {

    @Column(name = "DT_MUNIC_CODIGO")
    private String codigoMunicipio;

    @Column(name = "MU_MUL_NUMERO")
    private String numeroMulta;

    @Column(name = "MU_MUL_SEQUENCIAL")
    private String sequencial;

    @Column(name = "MU_HIN_DATA")
    private String data;

    @Column(name = "MU_HIN_HORA")
    private String hora;

}
