package com.searchtecnologia.recurso.model.processo;

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
@Table(name = "MM_RECU_LOTACAO_RECURSO", schema = "MULTA")
public class OrgaoLotacaoTipoProcesso implements Serializable {

    @Id
    @Column(name = "COD_ORGAO")
    private String codigoOrgao;

    @Column(name = "TIPO_PROCESSO")
    @Convert(converter = TipoProcesso.TipoProcessoConverter.class)
    private TipoProcesso tipoProcesso;

}
