package com.searchtecnologia.recurso.model.advertencia;

import com.searchtecnologia.recurso.util.persistence.type.LocalDateTimeType;
import com.searchtecnologia.recurso.util.persistence.type.StringEmptyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MM_AUTORIZACAO_ADVERTENCIA")
public class AutorizacaoAdvertencia implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Column(name = "ID_AUTORIZACAO")
    private Long id;

    @Column(name = "NUM_OFICIO_AUTORIZACAO")
    @Type(StringEmptyType.class)
    private String numeroOficio;

    @NotNull
    @Column(name = "DTA_AUTORIZACAO")
    @Type(LocalDateTimeType.class)
    private LocalDateTime data;

    @NotNull
    @Column(name = "ID_SESSAO")
    private Long idSessao;

    @NotNull
    @Column(name = "ID_HISTSERVICOSISTEMA")
    private Long idServicoSistema;

    @NotNull
    @Column(name = "ID_HISTOPERADOR")
    private Long idOperador;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "OPERADOR")
    private String operador;

}
