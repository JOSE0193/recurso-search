package com.searchtecnologia.recurso.model.processo;

import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.model.uf.UF;
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
@Table(schema = "MULTAWEB", name = "V_SGM_DADOS_PROCESSO")
public class DadosProcessoView implements Serializable {

    @Id
    @Column(name = "NUMERO_PROCESSO")
    private String numeroProcesso;

    @Column(name = "COD_ORGAO_RESPONSAVEL")
    private String codOrgaoResponsavel;

    @Column(name = "UF_ORGAO")
    private String ufOrgao;

    @Column(name = "COD_ORGAO_INTERNO")
    private String codOrgaoInterno;

    @Column(name = "COD_ORGAO_PROCESSO")
    private String codOrgaoProcesso;

    @Column(name = "DESC_ORGAO_PROCESSO")
    private String decricaoOrgaoProcesso;

    @Column(name = "COD_ORGAO_ANALIZADOR")
    private String codOrgaoAnalizador;
    @Column(name = "NOME_REQUERENTE")
    private String nomeRequerente;

    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;

    @Column(name = "NOME_MUNICICPIO")
    private String municipio;

    @Column(name = "UF_MUNICICPIO")
    private UF ufMunicipio;

    @Column(name = "DESC_ORGAO_ANALIZADOR")
    private String decricaoOrgaoAnalizador;

    @Column(name = "ENDERECO_REQUERENTE")
    private String endereco;

    @Column(name = "COMPLEMENTO_ENDERECO")
    private String complemento;

    @Column(name = "NUMERO_ENDERECO")
    private String numeroEndereco;

    @Column(name = "BAIRRO_REQUERENTE")
    private String bairro;

    @Column(name = "CIDADE_REQUERENTE")
    private String cidade;

    @Column(name = "UF_REQUERENTE")
    private UF ufRequerente;

    @Column(name = "CEP_REQUERENTE")
    private String cepRequerente;

    @Column(name = "NUMERO_AR")
    private String numeroAR;

    @Column(name = "COD_SITUACAO_PROCESSO")
    private String codSituacaoProcesso;

    @Column(name = "DESC_SITUACAO_PROCESSO")
    private String descricaoSituacaoProcesso;

    @Column(name = "COD_JARI")
    private String codJari;

    @Column(name = "DESC_JARI")
    private String descricaoJari;

    @Column(name = "COD_RELATOR")
    private String codRelator;

    @Column(name = "DESC_RELATOR")
    private String descricaoRelator;

    @Column(name = "COD_RESULTADO")
    private String codResultado;

    @Column(name = "DESC_RESULTADO")
    private String descricaoResultado;

    @Column(name = "TIPO_RESULTADO")
    private String tipoResultado;

    @Column(name = "COD_STATUS_PROCESSO")
    private String codStatusProcesso;

    @Column(name = "DESC_STATUS_PROCESSO")
    private String descricaoStatusProcesso;

    @Column(name = "DATA_PROTOCOLO")
    private String dataProtocolo;

    @Column(name = "DATA_CADASTRAMENTO")
    private String dataCadastramento;

    @Column(name = "DATA_CADASTRAMENTO_DB")
    private String dataCadastramentoDB;

    @Column(name = "HORA_CADASTRAMENTO")
    private String horaCadastramento;

    @Column(name = "DATA_CONCLUSAO")
    private String dataConclusao;

    @Column(name = "TIPO_RECURSO")
    private String tipoRecurso;

    @Column(name = "DESC_TIPO_RECURSO")
    private String descricaoTipoRecurso;

    @Column(name = "COD_OPERADOR")
    private String codOperador;

    @Column(name = "COD_ESTACAO")
    private String codEstacao;

    @Column(name = "COD_FUNCAO")
    private String codFuncao;

    @Column(name = "COD_ORGAO_INTERNO_ANALIZADOR")
    private String codOrgaoInternoAnalizador;

    @Column(name = "DATA_CIENCIA")
    private String dataCiencia;

    @Column(name = "NUM_REQUERIMENTO_SITE")
    private String numeroRequerimentoSite;

    @ManyToOne
    @JoinColumn(name = "NUMERO_PROCESSO", referencedColumnName = "MU_IDPR_CODIGO", insertable = false, updatable = false)
    private ProcessoView processoView;

}

