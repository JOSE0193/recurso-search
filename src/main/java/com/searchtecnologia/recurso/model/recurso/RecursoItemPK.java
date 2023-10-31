package com.searchtecnologia.recurso.model.recurso;

import com.searchtecnologia.recurso.model.uf.UF;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class RecursoItemPK implements Serializable {

    @Column(name = "MU_PROC_PLACA")
    private String placa;
    @Column(name = "MU_PROC_NUMERO")
    private String numeroRecurso;
    @Column(name = "SF_UF")
    @Enumerated(EnumType.STRING)
    private UF ufRecurso;
    @Column(name = "SF_ORGI_CODIGO")
    private String orgaoInternoRecurso; //TODO TABELA MULTA.MMA1PROM, COLUNA SF_ORGI_CODIGO DA PARA MAPEAR ENTIDADE OU ENUMERADOR?
    @Column(name = "MU_PROC_MUNICIPIO")
    private String municipioAuto;
    @Column(name = "MU_PROC_AUTO")
    private String numeroAuto;
    @Column(name = "MU_PROC_SEQUENCIAL")
    private String sequencialAuto;
}