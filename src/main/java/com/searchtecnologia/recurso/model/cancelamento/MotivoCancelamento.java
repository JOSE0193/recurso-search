package com.searchtecnologia.recurso.model.cancelamento;

import com.searchtecnologia.recurso.model.multa.DominioSimNao;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1TMOT")
public class MotivoCancelamento implements Serializable{

    @EmbeddedId
    @EqualsAndHashCode.Include
    private MotivoCancelamentoPK id;

    @Column(name = "MU_MOT_DESCRICAO")
    private String descricao;

    @Column(name = "MU_MOT_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;

    @Column(name = "MU_MOT_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;

    @Column(name = "MU_MOT_LOG_OPERADOR")
    private String operador;

    @Column(name = "MU_MOT_LOG_ESTACAO")
    private String estacao;

    @Column(name = "MU_MOT_LOG_FUNCAO")
    private String funcao;

    @Column(name = "MU_MOT_ATIVO")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao ativo;

    @Column(name = "COD_ORIGEM_OCORRENCIA")
    private String codigoOrigem;

}
