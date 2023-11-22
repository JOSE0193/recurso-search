package com.searchtecnologia.recurso.model.cancelamento;

import com.searchtecnologia.recurso.model.multa.DominioSimNao;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.uf.UF;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1LCAN")
public class CancelamentoMulta implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private CancelamentoPK id;

    @Column(name = "MU_MOT_CODIGO")
    private String motivo;

    @Column(name = "MU_CAN_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataOperacao;

    @Column(name = "MU_CAN_OBS1")
    private String observacao;

    @Column(name = "MU_CAN_OBS2")
    private String complementoObservacao;

    @Column(name = "MU_CAN_PROCESSO")
    private String numeroProcesso;

    @Column(name = "MU_CAN_DATA_PROCESSO")
    @Type(LocalDateType.class)
    private LocalDate dataProcesso;

    @Column(name = "MU_CAN_MATRICULA")
    private String matricula;

    @Column(name = "MU_CAN_SITUACAO_ANTERIOR")
    private String situacaoAnterior;

    @Column(name = "MU_CAN_DATA_SITUACAO_ANTERIOR")
    @Type(LocalDateType.class)
    private LocalDate dataSituacaoAnterior;

    @Column(name = "MU_CAN_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate logData;

    @Column(name = "MU_CAN_LOG_HORA_MIN_SEG")
    @Type(LocalTimeType.class)
    private LocalTime logHora;

    @Column(name = "MU_CAN_LOG_OPERADOR")
    private String operador;

    @Column(name = "MU_CAN_LOG_ESTACAO")
    private String estacao;

    @Column(name = "MU_CAN_LOG_FUNCAO")
    private String funcao;

    @Column(name = "MU_CAN_UF_OCORRENCIA")
    private UF uf;

    @Column(name = "MU_CAN_ORIGEM_OCORRENCIA")
    @Convert(converter = OrigemOcorrencia.Converter.class)
    private OrigemOcorrencia origemOcorrencia;

    @Column(name = "MU_MOT_CODIGO_EXCLUSAO")
    private BigDecimal motivoExclusao;

    @Column(name = "MU_CAN_ATIVO")
    private DominioSimNao ativo;

    @Column(name = "MU_CAN_OBS_REATIVACAO")
    private String observacaoReativacao;

    @Column(name = "MU_CAN_LOG_REAT_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataReativacao;

    @Column(name = "MU_CAN_LOG_REAT_HORA_MIN_SEG")
    @Type(LocalTimeType.class)
    private LocalTime horaReativacao;

    @Column(name = "MU_CAN_LOG_REAT_OPERADOR")
    private String operadorReativacao;

    @Column(name = "MU_CAN_LOG_REAT_ESTACAO")
    private String estacaoReativacao;

    @Column(name = "MU_CAN_LOG_REAT_FUNCAO")
    private String funcaoReativacao;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAutuador;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "DT_MUNIC_CODIGO", referencedColumnName = "DT_MUNIC_CODIGO")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "MU_MOT_CODIGO", referencedColumnName = "MU_MOT_CODIGO", insertable = false, updatable = false))
    })
    private MotivoCancelamento motivoCancelamento;

    @ManyToOne
    @JoinColumn(name = "MU_MOT_CODIGO_EXCLUSAO", referencedColumnName = "COD", insertable = false, updatable = false)
    private RinfMotivoCancelamento rinfMotivoCancelamento;
}
