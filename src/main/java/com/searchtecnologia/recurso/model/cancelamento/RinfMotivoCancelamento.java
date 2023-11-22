package com.searchtecnologia.recurso.model.cancelamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MM_RINF_MOTIVO_CANCEL")
public class RinfMotivoCancelamento implements Serializable {

    @Id
    @NotNull
    @Column(name = "COD")
    private String codigo;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;

}
