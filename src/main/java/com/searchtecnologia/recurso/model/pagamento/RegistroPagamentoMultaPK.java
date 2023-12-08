package com.searchtecnologia.recurso.model.pagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class RegistroPagamentoMultaPK implements Serializable {

    @Column(name = "MM_REN_NUMERO")
    private String numeroAutoInfracao;

    @Column(name = "DT_INF_CODIGO")
    private String codigoInfracao;

    @Column(name = "MM_OAU_CODIGO")
    private String codigoOrgaoAutuador;

    @Column(name = "MM_PGRN_SEQUENCIAL")
    private String sequencialPagamento;

}
