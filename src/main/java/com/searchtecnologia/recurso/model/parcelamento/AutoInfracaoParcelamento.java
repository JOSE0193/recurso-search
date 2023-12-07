package com.searchtecnologia.recurso.model.parcelamento;

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
@Table(schema = "MULTA", name = "FIPAAUTO")
public class AutoInfracaoParcelamento implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private AutoInfracaoParcelamentoPK id;

    @Column(name = "FI_UCCV_PLACA")
    private String placa;

    @Column(name = "FI_AUTO_LOG_DATA")
    private String data;

    @Column(name = "FI_AUTO_LOG_HORA")
    private String hora;

    @Column(name = "FI_AUTO_LOG_OPERADOR")
    private String operador;

    @Column(name = "FI_AUTO_LOG_FUNCAO")
    private String funcao;

    @Column(name = "FI_AUTO_LOG_ESTACAO")
    private String estacao;

    @Column(name = "FI_AUTO_ORGAO_AUTUADOR")
    private String autoOrgaoAutuador;

    @Column(name = "FI_AUTO_VALOR_MULTA")
    private Double valorMulta;

    @Column(name = "FI_AUTO_VALOR_FUNSET")
    private Double autoValorFunset;

}
