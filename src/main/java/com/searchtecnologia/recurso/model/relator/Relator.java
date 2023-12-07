package com.searchtecnologia.recurso.model.relator;

import com.searchtecnologia.recurso.model.jari.Jari;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.resultado.DominioSimNao;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
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
@Table(schema = "MULTA", name = "MMA1TREL")
public class Relator implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private RelatorPK id;

    @NotNull
    @Column(name = "MM_REL_NOME")
    private String nome;

    @NotNull
    @Column(name = "MM_REL_MATRICULA")
    private String maricula;

    @Column(name = "MM_REL_CPF")
    private String cpf;

    @NotNull
    @Column(name = "MM_REL_ATIVO")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao ativo;

    @NotNull
    @Column(name = "MM_REL_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;

    @NotNull
    @Column(name = "MM_REL_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;

    @NotNull
    @Column(name = "MM_REL_LOG_OPERADOR")
    private String operador;

    @NotNull
    @Column(name = "MM_REL_LOG_ESTACAO")
    private String estacao;

    @NotNull
    @Column(name = "MM_REL_LOG_FUNCAO")
    private String funcao;

    @NotNull
    @Column(name = "MM_TJAR_CODIGO")
    private String codigoJari;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAutuador;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "MM_TJAR_CODIGO", referencedColumnName = "MM_TJAR_CODIGO",
                    insertable = false, updatable = false))
    })
    private Jari jari;

}