package com.searchtecnologia.recurso.model.recurso;

import com.searchtecnologia.recurso.model.uf.UF;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class RecursoPK implements Serializable {

    @NotNull
    @Column(name = "MU_IDPR_NUMERO")
    private String numero;
    @NotNull
    @Column(name = "SF_UF")
    @Enumerated(EnumType.STRING)
    private UF uf;
    @NotNull
    @Column(name = "SF_ORGI_CODIGO")
    private String orgaoInterno; //TODO TABELA MULTA.MMA1IDPR, COLUNA SF_ORGI_CODIGO DA PARA MAPEAR ENTIDADE OU ENUMERADOR?
}