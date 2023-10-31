package com.searchtecnologia.recurso.model.resultado;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1MREJ")
public class MotivoResultado {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private MotivoResultadoPK id;

    @Column(name = "MM_MREJ_ATIVO")
    @Convert(converter = SimNao.Converter.class)
    private SimNao ativo;

    @Column(name = "MM_MREJ_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;

    @Column(name = "MM_MREJ_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;

    @Column(name = "MM_MREJ_LOG_OPERADOR")
    private String operadorCadastro;

    @Column(name = "MM_MREJ_LOG_ESTACAO")
    private String estacaoCadastro;

    @Column(name = "MM_MREJ_LOG_FUNCAO")
    private String funcaoCadastro;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false )
    private OrgaoAutuador orgaoAnalisador;

    @ManyToOne
    @JoinColumn(name = "MM_REJ_CODIGO", referencedColumnName = "MM_REJ_CODIGO", insertable = false, updatable = false)
    private Resultado resultado;

}
