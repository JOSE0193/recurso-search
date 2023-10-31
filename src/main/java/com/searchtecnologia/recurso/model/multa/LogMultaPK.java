package com.searchtecnologia.recurso.model.multa;

import com.searchtecnologia.recurso.util.persistence.type.LocalDateEmptyType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeEmptyType;
import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class LogMultaPK implements Serializable {

    @Column(name = "DT_MUNIC_CODIGO")
    @Type(StringEmptyType.class)
    private String municipio; //TODO TABELA MULTA.MMA1LMUL, COLUNA DT_MUNIC_CODIGO DA MAPEAR ENTIDADE?
    @Column(name = "MU_MUL_NUMERO")
    @Type(StringEmptyType.class)
    private String numero;
    @Column(name = "MU_MUL_SEQUENCIAL")
    @Type(StringEmptyType.class)
    private String sequencial;
    @Column(name = "MU_LMU_DATA")
    @Type(LocalDateEmptyType.class)
    private LocalDate data;
    @Column(name = "MU_LMU_HORA_MIN_SEG")
    @Type(LocalTimeEmptyType.class)
    private LocalTime hora;
}