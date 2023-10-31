package com.searchtecnologia.recurso.model.processo;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.recurso.RecursoView;
import com.searchtecnologia.recurso.model.resultado.Resultado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTAWEB", name = "MMA1PROC")
public class ProcessoView implements Serializable {

    @Id
    @NotNull
    @EqualsAndHashCode.Include
    @Column(name = "MU_IDPR_CODIGO")
    private String codigoRecurso;

    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgao;

    @NotNull
    @Column(name = "MU_MUL_NUMERO")
    private String numeroAuto; //TODO FAZER O RERLACIONAMENTO

    @NotNull
    @Column(name = "MU_MUL_SEQUENCIAL")
    private String sequencial; //TODO FAZER O RERLACCCCIONAMENTO

    @NotNull
    @Column(name = "MU_PROC_PLACA")
    private String placa;

    @Column(name = "MU_PROC_LOCAL_RESULTADO1")
    private String localResultado1;

    @Column(name = "MU_PROC_LOCAL_RESULTADO2")
    private String localResultado2;

    @NotNull
    @Column(name = "MU_PROC_SITUACAO1")
    private String situacao1;

    @Column(name = "MU_PROC_SITUACAO2")
    private String situacao2;

    @Column(name = "MU_PROC_MOTIVO_REQUERIMENTO")
    private String motivoRequerimento;

    @Column(name = "MU_PROC_RESULTADO_RECURSO1")
    private String resultadoRecurso1;

    @Column(name = "MU_PROC_RESULTADO_RECURSO2")
    private String resultadoRecurso2;

    @NotNull
    @Column(name = "MU_PROC_LOG_DATA_CADASTRO")
    private String logDataCadastro;

    @NotNull
    @Column(name = "MU_PROC_LOG_HORA_CADASTRO")
    private String logHoraCadastro;

    @NotNull
    @Column(name = "MU_PROC_LOG_OPERADOR_CADASTRO")
    private String logOperadorCadastro;

    @NotNull
    @Column(name = "MU_PROC_LOG_TERMINAL_CADASTRO")
    private String logTerminalCadastro;

    @NotNull
    @Column(name = "MU_PROC_LOG_FUNCAO_CADASTRO")
    private String logFuncaoCadastro;

    @Column(name = "MU_PROC_LOG_DATA_RESULTAD1")
    private String logDataResultado1;

    @Column(name = "MU_PROC_LOG_HORA_RESULTAD1")
    private String logHoraResultado1;

    @Column(name = "MU_PROC_LOG_OPERADOR_RESULTAD1")
    private String logOperadorResultado1;

    @Column(name = "MU_PROC_LOG_TERMINAL_RESULTAD1")
    private String logTerminalResultado1;

    @Column(name = "MU_PROC_LOG_FUNCAO_RESULTAD1")
    private String logFuncaoResultado1;

    @Column(name = "MU_PROC_LOG_DATA_RESULTAD2")
    private String logDataResultado2;

    @Column(name = "MU_PROC_LOG_HORA_RESULTAD2")
    private String logHoraResultado2;

    @Column(name = "MU_PROC_LOG_OPERADOR_RESULTAD2")
    private String logOperadorResultado2;

    @Column(name = "MU_PROC_LOG_TERMINAL_RESULTAD2")
    private String logTerminalResultado2;

    @Column(name = "MU_PROC_LOG_FUNCAO_RESULTAD2")
    private String logFuncaoResultado2;

    @Column(name = "MU_PROC_LOG_DEV_DATA")
    private String logDevData;

    @Column(name = "MU_PROC_LOG_DEV_HORA")
    private String logDevHora;

    @Column(name = "MU_PROC_LOG_DEV_OPERADOR")
    private String logDevOperador;

    @Column(name = "MU_PROC_LOG_DEV_TERMINAL")
    private String logDevTerminal;

    @Column(name = "MU_PROC_LOG_DEV_FUNCAO")
    private String logDevFuncao;

    @Column(name = "MU_PROC_DEV_DATA")
    private String devData;

    @Column(name = "MU_PROC_DEV_VALOR")
    private String devValor;

    @Column(name = "MU_PROC_DEV_BENEFICIARIO")
    private String devBeneficiario;

    @Column(name = "MU_PROC_DEV_BAN_AGENCIA")
    private String devBanAgencia;

    @Column(name = "MU_PROC_SUSP_PGU_REGISTRO")
    private String suspPguRegistro;

    @Column(name = "MU_PROC_SUSP_INSTRUCAO_SERVICO")
    private String suspInstrucaoServico;

    @Column(name = "MU_PROC_SUSP_MOTIVO")
    private String suspMotivo;

    @Column(name = "MU_PROC_SUSP_DATA_INICIO")
    private String suspDataInicio;

    @Column(name = "MU_PROC_SUSP_DATA_FIM")
    private String suspDataFim;

    @Column(name = "MU_PROC_LOG_SUSP_DATA")
    private String logSuspData;

    @Column(name = "MU_PROC_LOG_SUSP_HORA")
    private String logSuspHora;

    @Column(name = "MU_PROC_LOG_SUSP_OPERADOR")
    private String logSuspOperador;

    @Column(name = "MU_PROC_LOG_SUSP_TERMINAL")
    private String logSuspTerminal;

    @Column(name = "MU_PROC_LOG_SUSP_FUNCAO")
    private String logSuspFuncao;

    @Column(name = "MU_PROC_DEV_DATA_LIQUIDACAO")
    private String devDataLiquidacao;

    @Column(name = "MM_MOJ_CODIGO")
    private String mojCodigo;

    @Column(name = "MM_REL_CODIGO")
    private String relCodigo;

    @Column(name = "MM_PROC_DATA_REUNIAO")
    private String dataReuniao;

    @Column(name = "MM_PROC_NUM_REUNIAO")
    private String numeroReuniao;

    @Column(name = "MM_PROC_DECISAO_UNANIME")
    private Character decisaoUnanime;

    @Column(name = "MM_PROC_MOJ_DESCRICAO", length = 560)
    private String mojDescricao;

    @Column(name = "MM_OAU_CODIGO_ANALISADOR")
    private String codigoOrgaoAnalisador;

    @ManyToOne
    @JoinColumn(name = "MU_IDPR_CODIGO", referencedColumnName = "MU_IDPR_NUMERO", insertable = false, updatable = false)
    private RecursoView recursoView;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO_ANALISADOR", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAnalisador;

    @ManyToOne
    @JoinColumn(name = "MU_PROC_SITUACAO1", referencedColumnName = "MM_REJ_CODIGO", insertable = false, updatable = false)
    private Resultado resultado;

}
