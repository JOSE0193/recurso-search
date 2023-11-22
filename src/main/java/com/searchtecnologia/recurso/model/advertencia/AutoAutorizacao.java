package com.searchtecnologia.recurso.model.advertencia;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MM_AUTO_AUTORIZACAO_ADVERT")
public class AutoAutorizacao implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID_AUTO_AUTORIZACAO")
    private Long id;

    @Column(name = "MU_MUL_NUMERO")
    private String numeroMulta;

    @Column(name = "MM_OAU_CODIGO")
    private String orgaoAutuador;

    @Column(name = "DT_INF_CODIGO")
    private String codigoInfracao;

    @ManyToOne
    @JoinColumn(name = "ID_AUTORIZACAO", referencedColumnName = "ID_AUTORIZACAO")
    private AutorizacaoAdvertencia autorizacaoAdvertencia;

}
