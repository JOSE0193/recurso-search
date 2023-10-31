package com.searchtecnologia.recurso.model.recurso;

import com.searchtecnologia.recurso.model.jari.Jari;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.relator.Relator;
import com.searchtecnologia.recurso.model.resultado.ResultadoGeral;
import com.searchtecnologia.recurso.model.uf.UF;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
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
@Table(schema = "MULTAWEB", name = "MMA1IDPR")
public class RecursoView implements Serializable {

    @Id
    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "MU_IDPR_NUMERO")
    private String numero;

    @NotNull
    @Column(name = "SF_UF")
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotNull
    @Type(StringEmptyType.class)
    @Column(name = "SF_ORGI_CODIGO")
    private String orgaoInterno; //TODO TABELA MULTA.MMA1IDPR, COLUNA SF_ORGI_CODIGO DA PARA MAPEAR ENTID

    @NotNull
    @Column(name = "MU_IDPR_LOCAL")
    private String orgaoLotacao; //TODO TABELA MULTA.MMA1IDPR, COLUNA MU_IDPR_LOCAL DA PARA MAPEAR ENTIDADE OU ENUMERADOR?

    @NotNull
    @Column(name = "MU_IDPR_REQUERENTE")
    private String nome;

    @Column(name = "MU_IDPR_DEV_ENDERECO")
    private String endereco;

    @Column(name = "MU_IDPR_DEV_END_COMPLEMENTO")
    private String complementoEndereco;

    @Column(name = "MU_IDPR_DEV_BAIRRO")
    private String bairroEndereco;

    @Column(name = "MU_IDPR_DEV_CIDADE")

    private String cidadeEndereco;

    @Column(name = "MU_IDPR_DEV_UF")
    @Enumerated(EnumType.STRING)
    private UF ufEndereco;

    @Column(name = "MU_IDPR_DEV_CEP")
    private String cepEndereco;

    @Column(name = "MU_IDPR_DEV_BANCO")
    private String banco;

    @Column(name = "MU_IDPR_DEV_AGENCIA")
    private String agencia;

    @Column(name = "MU_IDPR_DEV_CONTA_CORRENTE")
    private String contaCorrente;

    @Column(name = "MM_AVISO_NUMERO_AR")
    private String avisoNumeroAR;

    @NotNull
    @Column(name = "MU_IDPR_STATUS_PROCESSO")
    @Convert(converter = SituacaoRecurso.SituacaoRecursoConverter.class)
    private SituacaoRecurso situacao;

    @NotNull
    @Column(name = "MU_IDPR_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataLog;

    @NotNull
    @Column(name = "MU_IDPR_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaLog;

    @NotNull
    @Column(name = "MU_IDPR_LOG_OPERADOR")
    private String operadorLog;

    @NotNull
    @Column(name = "MU_IDPR_LOG_ESTACAO")
    private String estacaoLog;

    @NotNull
    @Column(name = "MU_IDPR_LOG_FUNCAO")
    private String funcaoLog;

    @Column(name = "MM_IDPR_TIPO_RECURSO")
    @Convert(converter = TipoRecurso.TipoRecursoConverter.class)
    private TipoRecurso tipoRecurso;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "MM_TJAR_CODIGO", referencedColumnName = "MM_TJAR_CODIGO"))
    })
    private Jari jari;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula = @JoinFormula(value = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")),
            @JoinColumnOrFormula(column = @JoinColumn(name = "MM_TREL_CODIGO", referencedColumnName = "MM_REL_CODIGO"))
    })
    private Relator relator;

    @Column(name = "MM_IDPR_DATA_PROTOCOLO")
    @Type(LocalDateType.class)
    private LocalDate dataProtocolo;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAutuador;

    @Column(name = "MM_IDPR_LOG_DATA_CADASTRO")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;

    @Column(name = "MM_IDPR_LOG_HORA_CADASTRO")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;

    @Column(name = "MM_IDPR_LOG_OPERADOR_CADASTRO")
    private String operadorCadastro;

    @Column(name = "MM_IDPR_LOG_ESTACAO_CADASTRO")
    private String estacaoCadastro;

    @Column(name = "MM_IDPR_LOG_FUNCAO_CADASTRO")
    private String funcaoCadastro;

    @Column(name = "MM_IDPR_TIPO_JULGAMENTO")
    @Convert(converter = TipoRecurso.TipoRecursoConverter.class)
    private TipoJulgamento tipoJulgamento;

    @ManyToOne
    @JoinColumn(name = "MM_TRGE_CODIGO", referencedColumnName = "MM_TRGE_CODIGO")
    private ResultadoGeral resultado;

    @Column(name = "MM_TSPR_CODIGO")
    @Convert(converter = StatusRecurso.StatusRecursoConverter.class)
    private StatusRecurso status;

    @Column(name = "MU_IDPR_DATA_CONCLUSAO")
    @Type(LocalDateType.class)
    private LocalDate dataConclusao;

    @Column(name = "MM_IDPR_DATA_CIENCIA_RESULTADO")
    private String cienciaResultado;

    @Column(name = "MM_IDPR_DATA_LIMITE_REC_CETRAN")
    @Type(LocalDateType.class)
    private LocalDate dataLimiteRecCetran;

    @Column(name = "MM_IDPR_DATA_NOTIFICACAO")
    @Type(LocalDateType.class)

    private LocalDate dataNotificacao;

    @Column(name = "MU_IDPR_DEV_END_NUMERO")
    private String devEndNumero;

    @Column(name = "NUM_REQUERIMENTO_SITE")
    private String numRequerimentoSite;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO_ANALISADOR", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAnalizador;

}
