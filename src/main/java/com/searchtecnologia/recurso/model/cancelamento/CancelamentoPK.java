package com.searchtecnologia.recurso.model.cancelamento;

import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class CancelamentoPK implements Serializable {

    @Column(name = "MU_MUL_NUMERO")
    @Type(StringEmptyType.class)
    private String numeroAuto;

    @Column(name = "MU_MUL_SEQUENCIAL")
    @Type(StringEmptyType.class)
    private String sequencial;

    @Column(name = "DT_MUNIC_CODIGO")
    @Type(StringEmptyType.class)
    private String municipio; //TODO TABELA MULTA.MMA1MULT, COLUNA DT_MUNIC_CODIGO DA MAPEAR ENTIDADE?

    @Column(name = "SF_BOR_SIT_CODIGO")
    @Type(StringEmptyType.class)
    private String situacaoFinanceira;

}