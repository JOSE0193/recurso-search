package com.searchtecnologia.recurso.model.ocorrenciarenainf;

import com.searchtecnologia.recurso.util.persistence.type.LocalDateType;
import com.searchtecnologia.recurso.util.persistence.type.LocalTimeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class OcorrenciaRenainfPK implements Serializable {

    @NotNull
    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgaoAutuador;

    @NotNull
    @Column(name = "MU_MUL_NUMERO")
    private String numeroAutoInfracao;

    @NotNull
    @Column(name = "DT_INF_CODIGO")
    private String codigoInfracao; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA DT_INF_CODIGO DA PARA MAPEAR ENTIDADE?

    @NotNull
    @Column(name = "MM_OCOR_TIPO_OCORRENCIA")
    private String tipoOcorrencia; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA MM_OCOR_TIPO_OCORRENCIA DA PARA ENTIDADE OU ENUMERADOR?

    @NotNull
    @Column(name = "MM_OCOR_DATA_OCORRENCIA")
    @Type(LocalDateType.class)
    private LocalDate dataOcorrencia;

    @NotNull
    @Column(name = "MM_OCOR_HORA_OCORRENCIA")
    @Type(LocalTimeType.class)
    private LocalTime horaOcorrencia;

}