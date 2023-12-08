package com.searchtecnologia.recurso.model.pagamento;

import com.searchtecnologia.recurso.model.multa.MultaPK;
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
@Table(name = "MMA1PGRN", schema = "MULTA")
public class RegistroPagamentoMulta implements Serializable {


    @EmbeddedId
    @EqualsAndHashCode.Include
    private RegistroPagamentoMultaPK id;

    @Column(name = "MM_PGRN_SIT_CODIGO")
    private String situacaoPagamento;

    @Column(name = "MM_PGRN_CODIGO_BARRA")
    private String codigoBarras;

    @Column(name = "MM_PGRN_VALOR_PAGO_COMP")
    private Double valorPagoComprovado;

    @Column(name = "MM_PGRN_VALOR_PAGO_CONF")
    private Double valorPagoConfirmado;

    @Column(name = "MM_PGRN_DATA_COMP")
    private String dataComprovacao;

    @Column(name = "MM_PGRN_DATA_CONF")
    private String dataConfirmacao;

    @Column(name = "MM_PGRN_PAGO")
    private String pagamento;

    @Column(name = "MM_PGRN_DATA_CREDITO")
    private String dataCredito;

    @Column(name = "MM_PGRN_LOTE_BANCO")
    private String loteBanco;

    @Column(name = "MM_PGRN_BANCO")
    private String codigoBanco;

    @Column(name = "MM_PGRN_AGENCIA")
    private String agenciaBanco;

    @Column(name = "MM_PGRN_POSTO")
    private String postoBancario;

    @Column(name = "MM_PGRN_AUTENTICACAO")
    private String numeroAutenticacao;

    @Column(name = "MM_PGRN_DATA_REPASSE")
    private String dataRepasse;

    @Column(name = "MM_PGRN_VALOR_REPASSE")
    private Double valorRepasse;

    @Column(name = "MM_PGRN_TIPO_PAGAMENTO")
    private String tipoPagamento;

    @Column(name = "MM_PGRN_PROCESSO_LEILAO")
    private String numeroProcessoLeilao;

    @Column(name = "MM_PGRN_NUM_LEILAO")
    private String numeroLeilao;

    @Column(name = "MM_PGRN_BORDERO")
    private String numeroBordero;

    @Column(name = "MM_PGRN_SEQUENCIAL_BANCO")
    private String sequencialBanco;

    @Column(name = "MM_PGRN_TERMINAL_PAGAMENTO")
    private String terminalPagamento;

    @Column(name = "MM_PGRN_DATA_PROCESSAMENTO")
    private String dataProcessamento;

    @Column(name = "COD_UNIDADE_AUTUADORA")
    private String codigoUnidadeAutuadora;

}
