package com.searchtecnologia.recurso.model.jari;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.resultado.DominioSimNao;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
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
@Table(schema = "MULTA", name = "MMA1TJAR")
public class Jari {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private JariPK id;

    @NotNull
    @Column(name = "MM_TJAR_DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "MM_TJAR_ATIVO")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao ativo;

    @NotNull
    @Column(name = "MM_TJAR_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;

    @NotNull
    @Column(name = "MM_TJAR_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;

    @NotNull
    @Column(name = "MM_TJAR_LOG_OPERADOR")
    private String operadorCadastro;

    @NotNull
    @Column(name = "MM_TJAR_LOG_ESTACAO")
    private String estacaoCadastro;

    @NotNull
    @Column(name = "MM_TJAR_LOG_FUNCAO")
    private String funcaoCadastro;

    @Column(name = "MM_TJAR_ATUAL")
    private String jariAtual;

    @Column(name = "MM_TJAR_TIPO")
    @Convert(converter = TipoJari.TipoJariConverter.class)
    private TipoJari tipoJari;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAutuador;

}