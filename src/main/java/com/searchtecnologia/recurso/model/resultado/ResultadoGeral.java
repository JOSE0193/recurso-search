package com.searchtecnologia.recurso.model.resultado;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1TRGE")
public class ResultadoGeral {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ResultadoGeralPK id;
    @NotNull
    @Column(name = "MM_TRGE_DESCRICAO")
    private String descricao;
    @NotNull
    @Column(name = "MM_TRGE_TIPO_JULGAMENTO")
    private String tipoJulgamento;

}
