package com.searchtecnologia.recurso.model.processo;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.processo.ProcessoPK;
import com.searchtecnologia.recurso.model.recurso.Recurso;
import com.searchtecnologia.recurso.model.resultado.Resultado;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1PROC")
public class Processo implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ProcessoPK id;

    @Column(name = "MU_PROC_LOCAL")
    private String local;

    @Column(name = "MU_PROC_LOCAL_RESULTADO1")
    private String localResultado1;

    @Column(name = "MU_PROC_LOCAL_RESULTADO2")
    private String localResultado2;

    @Column(name = "MU_PROC_SITUACAO1")
    private String situacao1;

    @Column(name = "MU_PROC_SITUACAO2")
    private String situacao2;

    @Column(name = "MU_PROC_REQUERENTE")
    private String requerente;

    @Column(name = "MU_PROC_DATA_REQUERIMENTO")
    private String dataRequerimento;

    @Column(name = "MU_PROC_MOTIVO_REQUERIMENTO")
    private String motivoRequerimento;

    @Column(name = "MU_PROC_RESULTADO_RECURSO1")
    private String resultadoRecurso1;

    @Column(name = "MU_PROC_RESULTADO_RECURSO2")
    private String resultadoRecurso2;

    @Column(name = "MU_PROC_LOG_DATA_CADASTRO")
    private String dataCadastro;

    @Column(name = "MU_PROC_LOG_HORA_CADASTRO")
    private String horaCadastro;

    @Column(name = "MU_PROC_LOG_OPERADOR_CADASTRO")
    private String operadorCadastro;

    @Column(name = "MU_PROC_LOG_TERMINAL_CADASTRO")
    private String terminalCadastro;

    @Column(name = "MU_PROC_LOG_FUNCAO_CADASTRO")
    private String funcaoCadastro;

    @Column(name = "MU_PROC_LOG_DATA_RESULTAD1")
    private String dataResultado1;

    @Column(name = "MU_PROC_LOG_HORA_RESULTAD1")
    private String horaResultado1;

    @Column(name = "MU_PROC_LOG_OPERADOR_RESULTAD1")
    private String operadorResultado1;

    @Column(name = "MU_PROC_LOG_TERMINAL_RESULTAD1")
    private String terminalResultado1;

    @Column(name = "MU_PROC_LOG_FUNCAO_RESULTAD1")
    private String funcaoResultado1;

    @Column(name = "MU_PROC_LOG_DATA_RESULTAD2")
    private String dataResultado2;

    @Column(name = "MU_PROC_LOG_HORA_RESULTAD2")
    private String horaResultado2;

    @Column(name = "MU_PROC_LOG_OPERADOR_RESULTAD2")
    private String operadorResultado2;

    @Column(name = "MU_PROC_LOG_TERMINAL_RESULTAD2")
    private String terminalResultado2;

    @Column(name = "MU_PROC_LOG_FUNCAO_RESULTAD2")
    private String funcaoResultado2;

    @Column(name = "MU_PROC_RELATOR")
    private String relator;

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
    private String devBancoAgencia;

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
    private String suspData;

    @Column(name = "MU_PROC_LOG_SUSP_HORA")
    private String suspHora;

    @Column(name = "MU_PROC_LOG_SUSP_OPERADOR")
    private String suspOperador;

    @Column(name = "MU_PROC_LOG_SUSP_TERMINAL")
    private String suspTerminal;

    @Column(name = "MU_PROC_LOG_SUSP_FUNCAO")
    private String suspFuncao;

    @Column(name = "MU_PROC_DEV_ENDERECO")
    private String devEndereco;

    @Column(name = "MU_PROC_DEV_CEP")
    private String devCep;

    @Column(name = "MU_PROC_DEV_CONTA_CORRENTE")
    private String devContaCorrente;

    @Column(name = "MU_PROC_DEV_DATA_LIQUIDACAO")
    private String dataLiquidacao;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAutuador;

}


