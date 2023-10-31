package com.searchtecnologia.recurso.model.processo;

import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1TSPR")
public class SituacaoProcesso implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Column(name = "MM_TSPR_CODIGO")
    @Type(StringEmptyType.class)
    private String codigo;

    @Column(name = "MM_TSPR_DESCRICAO")
    private String descricao;

}
