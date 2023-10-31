package com.searchtecnologia.recurso.model.orgaoautuador;

import com.searchtecnologia.recurso.model.resultado.SimNao;
import com.searchtecnologia.recurso.model.uf.UF;
import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
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
@Table(schema = "MULTA", name = "MMA1TOAU")
public class OrgaoAutuador implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "MM_OAU_CODIGO")
    @Type(StringEmptyType.class)
    private String codigo;

    @Column(name = "MM_OAU_DESCRICAO")
    @Type(StringEmptyType.class)
    private String descricao;

    @Column(name = "MM_OAU_SIGLA")
    @Type(StringEmptyType.class)
    private String sigla;

    @Column(name = "SF_ORG_CODIGO")
    @Type(StringEmptyType.class)
    private String orgaoLotacao;

    @Column(name = "SF_ORGI_CODIGO")
    @Type(StringEmptyType.class)
    private String orgaoInterno;

    @Column(name = "MM_OAU_LOG_DATA")
    @Type(LocalDateType.class)
    private LocalDate dataRegistro;

    @Column(name = "MM_OAU_LOG_HORA")
    @Type(LocalTimeType.class)
    private LocalTime horaRegistro;

    @Column(name = "MM_OAU_LOG_OPERADOR")
    private String operadorRegistro;

    @Column(name = "MM_OAU_LOG_ESTACAO")
    private String estacaoRegistro;

    @Column(name = "MM_OAU_LOG_FUNCAO")
    private String funcaoRegistro;

    @Column(name = "MM_OAU_CODIGO_DENATRAN")
    private String codigoDenatran;

    @Column(name = "DT_MUNIC_CODIGO")
    private String municipio;

    @Column(name = "MM_OAU_ESFERA")
    @Convert(converter = Esfera.EsferaConverter.class)
    private Esfera esfera;

    @Column(name = "MM_OAU_UF")
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(name = "MM_OAU_ATIVO")
    @Convert(converter = SimNao.Converter.class)
    private SimNao ativo;

    @Column(name = "MM_OAU_DESCRICAO_EXTENSO")
    private String descricaoExetenso;

    @Column(name = "MM_OAU_TELEFONE")
    private String telefone;

}
