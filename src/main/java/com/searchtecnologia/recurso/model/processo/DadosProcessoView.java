package com.searchtecnologia.recurso.model.processo;

import com.searchtecnologia.recurso.model.recurso.TipoRecurso;
import com.searchtecnologia.recurso.model.resultado.Resultado;
import com.searchtecnologia.recurso.model.uf.UF;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateBrType;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "V_SGM_DADOS_PROCESSO", schema = "MULTAWEB")
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
    private String descOrgaoProcesso;

    @Column(name = "COD_ORGAO_ANALIZADOR")
    private String codOrgaoAnalizador;

    @Column(name = "NOME_REQUERENTE")
    private String nomeRequerente;

    @Column(name = "TIPO_REQUERENTE")
    private String tipoRequerente;

    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;

    @Column(name = "NOME_MUNICICPIO")
    private String nomeMunicipio;

    @Column(name = "UF_MUNICICPIO")
    private String ufMunicipio;

    @Column(name = "DESC_ORGAO_ANALIZADOR")
    private String descOrgaoAnalizador;

    @Column(name = "ENDERECO_REQUERENTE")
    private String enderecoRequerente;

    @Column(name = "COMPLEMENTO_ENDERECO")
    private String complementoEndereco;

    @Column(name = "NUMERO_ENDERECO")
    private String numeroEndereco;

    @Column(name = "BAIRRO_REQUERENTE")
    private String bairroRequerente;

    @Column(name = "CIDADE_REQUERENTE")
    private String cidadeRequerente;

    @Column(name = "UF_REQUERENTE")
    private String ufRequerente;

    @Column(name = "CEP_REQUERENTE")
    private String cepRequerente;

    @Column(name = "NUMERO_AR")
    private String numeroAr;

    @Column(name = "COD_SITUACAO_PROCESSO")
    private String codSituacaoProcesso;

    @Column(name = "DESC_SITUACAO_PROCESSO")
    private String descSituacaoProcesso;

    @Column(name = "COD_JARI")
    private String codJari;

    @Column(name = "DESC_JARI")
    private String descJari;

    @Column(name = "COD_RELATOR")
    private String codRelator;

    @Column(name = "DESC_RELATOR")
    private String descRelator;

    @Column(name = "COD_RESULTADO")
    private String codResultado;

    @Column(name = "DESC_RESULTADO")
    private String descResultado;

    @Column(name = "TIPO_RESULTADO")
    private String tipoResultado;

    @Column(name = "COD_STATUS_PROCESSO")
    private String codStatusProcesso;

    @Column(name = "DESC_STATUS_PROCESSO")
    private String descStatusProcesso;

    @Column(name = "DATA_PROTOCOLO")
    @Type(LocalDateBrType.class)
    private LocalDate dataProtocolo;

    @Column(name = "DATA_CADASTRAMENTO")
    @Type(LocalDateBrType.class)
    private LocalDate dataCadastramento;

    @Column(name = "DATA_CADASTRAMENTO_DB")
    @Type(LocalDateType.class)
    private LocalDate dataCadastramentoDb;

    @Column(name = "HORA_CADASTRAMENTO")
    @Type(LocalTimeType.class)
    private LocalTime horaCadastramento;

    @Column(name = "DATA_CONCLUSAO")
    @Type(LocalDateBrType.class)
    private LocalDate dataConclusao;

    @Column(name = "TIPO_RECURSO")
    @Convert(converter = TipoRecurso.TipoRecursoConverter.class)
    private TipoRecurso tipoRecurso;

    @Column(name = "DESC_TIPO_RECURSO")
    private String descTipoRecurso;

    @Column(name = "COD_OPERADOR")
    private String codOperador;

    @Column(name = "COD_ESTACAO")
    private String codEstacao;

    @Column(name = "COD_FUNCAO")
    private String codFuncao;

    @Column(name = "COD_ORGAO_INTERNO_ANALIZADOR")
    private String codOrgaoInternoAnalizador;

    @Column(name = "DATA_CIENCIA")
    @Type(LocalDateType.class)
    private LocalDate dataCiencia;

    @Column(name = "NUM_REQUERIMENTO_SITE")
    private String numRequerimentoSite;

    @Column(name = "RECURSO_JULGADO_NO_SGPAM")
    private String recursoJulgadoNoSgpam;

    @OneToMany(mappedBy = "dadosProcesso")
    private List<ProcessoView> processos;

}

