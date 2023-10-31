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
@Table(schema = "MULTA", name = "MMA1LMUL")
public class LogMulta implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private LogMultaPK id;
    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
    private OrgaoAutuador orgaoAutuador;
    @Column(name = "MU_LMU_SITUACAO")
    private String situacao; //TODO TABELA MULTA.MMA1LMUL, COLUNA MU_LMU_SITUACAO DA MAPEAR ENTIDADE OU ENUMERADOR?
    @Column(name = "MU_LMU_OPERADOR")
    private String operador;
    @Column(name = "MU_LMU_ESTACAO")
    private String estacao;
    @Column(name = "MU_LMU_FUNCAO")
    private String funcao;
}