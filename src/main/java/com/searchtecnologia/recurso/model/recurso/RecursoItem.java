package com.searchtecnologia.recurso.model.recurso;

import com.searchtecnologia.recurso.model.multa.Multa;
import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
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
@Table(schema = "MULTA", name = "MMA1PROM")
public class RecursoItem implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private RecursoItemPK id;
    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAutuador;
    @Column(name = "MU_PROC_LOG_DATA_CADASTRO")
    @Type(LocalDateType.class)
    private LocalDate dataCadastro;
    @Column(name = "MU_PROC_LOG_HORA_CADASTRO")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastro;
    @Column(name = "MU_PROC_LOG_OPERADOR_CADASTRO")
    private String operadorCadastro;
    @Column(name = "MU_PROC_LOG_TERMINAL_CADASTRO")
    private String terminalCadastro;
    @Column(name = "MU_PROC_LOG_FUNCAO_CADASTRO")
    private String funcaoCadastro;
    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO_ANALISADOR", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAnalisador;
    @Column(name = "MU_PROC_SITUACAO1")
    private String situacao1; //TODO TABELA MULTA.MMA1PROC, COLUNA MU_PROC_SITUACAO1 DA PARA MAPEAR ENTIDADE OU ENUMERADOR?
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MU_PROC_NUMERO", referencedColumnName = "MU_IDPR_NUMERO", insertable = false, updatable = false),
            @JoinColumn(name = "SF_UF", referencedColumnName = "SF_UF", insertable = false, updatable = false),
            @JoinColumn(name = "SF_ORGI_CODIGO", referencedColumnName = "SF_ORGI_CODIGO", insertable = false, updatable = false)
    })
    private Recurso recurso; //TODO VALIDAR SE O JOIN E POR ESSES CAMPOS MESMO

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "MU_PROC_AUTO", referencedColumnName = "MU_MUL_NUMERO", insertable = false, updatable = false),
            @JoinColumn(name = "MU_PROC_SEQUENCIAL", referencedColumnName = "MU_MUL_SEQUENCIAL", insertable = false, updatable = false),
            @JoinColumn(name = "MU_PROC_MUNICIPIO", referencedColumnName = "DT_MUNIC_CODIGO", insertable = false, updatable = false)
    })
    private Multa multa;
}