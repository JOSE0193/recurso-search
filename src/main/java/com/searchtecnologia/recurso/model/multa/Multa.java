package com.searchtecnologia.recurso.model.multa;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.uf.UF;
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
@Table(schema = "MULTA", name = "MMA1MULT")
public class Multa implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private MultaPK id;

    @Column(name = "SF_ORG_CODIGO")
    private String orgaoLotacao;

    @Column(name = "DT_INF_CODIGO")
    private String codigoInfracao; //TODO TABELA MULTA.MMA1MULT, COLUNA DT_INF_CODIGO  DA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "MU_SIT_CODIGO")
    private String situacao; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_SIT_CODIGO DA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "SF_BOR_SIT_CODIGO")
    private String situacaoFinanceira;

    @Column(name = "MU_MUL_TIPO")
    private String tipoDocumentoCondutor;

    @Column(name = "MU_REM_NUMERO")
    private String remessa; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_REM_NUMERO DA MAPEAR ENTIDADE? SE SIM É SÓ ESSA COLUNA O FK

    @Column(name = "MU_MUL_DATA_SITUACAO")
    @Type(LocalDateType.class)
    private LocalDate dataSF;

    @Column(name = "MU_MUL_DATA_NOTIFICACAO")
    @Type(LocalDateType.class)
    private LocalDate dataNotificacao;

    @Column(name = "MU_MUL_DATA")
    @Type(LocalDateType.class)
    private LocalDate data;

    @Column(name = "MU_MUL_HORA")
    @Type(LocalTimeType.class)
    private LocalTime hora;

    @Column(name = "MU_MUL_PLACA")
    private String placa;

    @Column(name = "MU_MUL_PLACA_UF")
    @Enumerated(EnumType.STRING)
    private UF ufPlaca;

    @Column(name = "MU_MUL_CHASSI")
    private String chassi;

    @Column(name = "MU_MUL_ESPECIE")
    private String especie;

    @Column(name = "MU_MUL_CATEGORIA")
    private String categoria;

    @Column(name = "MU_MUL_MARCA_MODELO")
    private String marcaModelo;

    @Column(name = "MU_MUL_RADAR")
    private String codigoRadar;

    @Column(name = "MU_MUL_CONTRATO")
    private String contrato;

    @Column(name = "MU_AGE_CODIGO")
    private String codigoAgente;

    @Column(name = "MU_MUL_CODIGO_LOCAL")
    private String codigoLocal;

    @Column(name = "MU_MUL_TIPO_CNH")
    private String tipoCnh;

    @Column(name = "MU_MUL_NUMERO_CNH")
    private String cnh;

    @Column(name = "MU_MUL_CNH_UF")
    @Enumerated(EnumType.STRING)
    private UF ufCnh;

    @Column(name = "MU_MUL_IDENTIFICACAO_BIN")
    private String cpfCondutorIdentificado;

    @Column(name = "MU_MUL_RETORNO_BIN")
    @Enumerated(EnumType.STRING)
    private UF ufCondutor;

    @Column(name = "MU_MUL_LOCAL")
    private String local;

    @Column(name = "MU_MUL_LOCAL_COMPLEMENTO")
    private String complementoLocal;

    @Column(name = "MU_MUL_OBS1")
    private String observacao;

    @Column(name = "MU_MUL_PENALIDADE")
    private DominioSimNao penalizado;

    @Column(name = "SF_BOR_TIPO_SERV")
    private String tipoServicoBordero;

    @Column(name = "SF_BOR_LOCAL")
    private String codigoLocalBordero;

    @Column(name = "SF_BOR_NUMERO")
    private String numeroBordero;

    @Column(name = "SF_BOR_VIA")
    private String viaBordero;

    @Column(name = "SF_BOR_DV")
    private String digitoBordero;

    @Column(name = "MU_MUL_CPF_CONDUTOR")
    private String cpfCondutor;

    @Column(name = "MU_MUL_CPF_CGC_INFRATOR")
    private String cpfInfratorResponsavel;

    @Column(name = "MU_MUL_NOME_INFRATOR")
    private String nomeInfrator;

    @Column(name = "MU_MUL_TIPO_VEICULO")
    private String tipoVeiculo;

    @Column(name = "MU_MUL_VALOR_PAGO_COMP")
    private String valorPagoComprovado;

    @Column(name = "MU_MUL_VALOR_PAGO_CONF")
    private String valorPago;

    @Column(name = "MU_MUL_DATA_COMP")
    @Type(LocalDateType.class)
    private LocalDate dataComprovacao;

    @Column(name = "MU_MUL_DATA_CONF")
    @Type(LocalDateType.class)
    private LocalDate dataPagamento;

    @Column(name = "MU_MUL_VALOR")
    private String valor;

    @Column(name = "MU_MUL_VALOR_COM_DESCONTO")
    private String valorComDesconto;

    @Column(name = "SF_ORGI_CODIGO")
    private String orgaoInterno;

    @Column(name = "SF_HMUT_CS_BORDERO")
    private String tipoInfracao;

    @Column(name = "SF_HMUT_VIA_CORREIO")
    @Convert(converter = SituacaoCorreio.Converter.class)
    private SituacaoCorreio situacaoCorreio; //TODO TABELA MULTA.MMA1MULT, COLUNA SF_HMUT_VIA_CORREIO DA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "SF_HMUT_DATA_VENC")
    @Type(LocalDateType.class)
    private LocalDate dataVencimento;

    @Column(name = "SF_HMUT_DATA_CREDITO")
    @Type(LocalDateType.class)
    private LocalDate dataCredito;

    @Column(name = "FI_TAR_NUMERO_TAREFA")
    private String numeroFaturamento;

    @Column(name = "MU_MUL_AUTO_PRF")
    private String numeroNotificacao;

    @Column(name = "MU_MUL_MEDICAO_REAL")
    private String medicao;

    @Column(name = "MU_MUL_LIMITE_PERMITIDO")
    private String limitePermitido;

    @Column(name = "MU_MUL_MEDICAO_CONSIDERADA")
    private String medicaoConsiderada;

    @Column(name = "MU_MUL_UNIDADE_MEDIDA")
    private String unidadeMedida;

    @Column(name = "MU_MUL_COD_MUNIC_INFRACAO")
    private String codMunicipioInfracao;

    @Column(name = "MU_MUL_DATA_AUTUACAO")
    @Type(LocalDateType.class)
    private LocalDate dataAutuacao;

    @Column(name = "MU_MUL_LIMITE_DEF_PREVIA")
    @Type(LocalDateType.class)
    private LocalDate dataLimiteDefesa;

    @Column(name = "MU_REM_NUMERO_NP")
    private String numeroRemessaNP;

    @Column(name = "COD_UNIDADE_AUTUADORA")
    private String codUnidadeAutuadora;

    @Column(name = "MU_MUL_COD_RENAINF")
    private String codigoRenainf; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_MUL_COD_RENAINF DA PARA MAPEAR EM ENTIDADE OU ENUMERADOR?

    @Column(name = "MU_MUL_INDICADOR_ASSINATURA")
    private String indicadorAssinatura;

    @Column(name = "MU_MUL_CONDUTOR_IDENTIFICADO")
    private DominioSimNao identificado;

    @Column(name = "DT_INF_DESDOBRAMENTO")
    private String codigoDesdobramento;

    @Column(name = "MU_MUL_DATA_CADASTRAMENTO")
    @Type(LocalDateType.class)
    private LocalDate dataCadastramento;

    @Column(name = "MU_MUL_NOME_CONDUTOR")
    private String nomeCondutor;

    @Column(name = "MU_MUL_TIPO_DOC_EMBARCADOR")
    private String tipoDocEmbarcador;

    @Column(name = "MU_MUL_NUM_DOC_EMBARCADOR")
    private String numeroDocEmbarcador;


    @Column(name = "REGISTRAR_NA_EDITAL")
    private String registrarNA;

    @Column(name = "REGISTRAR_NP_EDITAL")
    private String registrarNP;

    @Column(name = "MU_MUL_EM_RECURSO_TEMPESTIVO")
    private String recursoTempestivo;

    @Column(name = "MU_MUL_DT_INICIO_EXIGIBILIDADE")
    @Type(LocalDateType.class)
    private LocalDate dataInicioExigibilidade;

    @Column(name = "MU_MUL_INDICE_CORRECAO")
    private String indiceCorrecao;

    @Column(name = "MU_MUL_VALOR_CORRECAO")
    private String valorCorrecao;

    @Column(name = "MU_MUL_DATA_LIMITE_REC_CETRAN")
    @Type(LocalDateType.class)
    private LocalDate dataLimiteCetran;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAutuador;
}