package com.searchtecnologia.recurso.model.multa;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
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
@Table(schema = "MULTA", name = "MMA1MULT")
public class Multa implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private MultaPK id;
    @Column(name = "MU_MUL_COD_RENAINF")
    private String codigoRenainf; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_MUL_COD_RENAINF DA PARA MAPEAR EM ENTIDADE OU ENUMERADOR?
    @Column(name = "DT_INF_CODIGO")
    private String codigoInfracao; //TODO TABELA MULTA.MMA1MULT, COLUNA DT_INF_CODIGO  DA MAPEAR ENTIDADE OU ENUMERADOR?
    @Column(name = "MU_SIT_CODIGO")
    private String situacao; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_SIT_CODIGO DA MAPEAR ENTIDADE OU ENUMERADOR?
    @Column(name = "SF_HMUT_VIA_CORREIO")
    private String situacaoCorreio; //TODO TABELA MULTA.MMA1MULT, COLUNA SF_HMUT_VIA_CORREIO DA MAPEAR ENTIDADE OU ENUMERADOR?
    @Column(name = "MU_REM_NUMERO")
    private String remessa; //TODO TABELA MULTA.MMA1MULT, COLUNA MU_REM_NUMERO DA MAPEAR ENTIDADE? SE SIM É SÓ ESSA COLUNA O FK
    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAutuador;
}