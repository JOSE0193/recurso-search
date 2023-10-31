package com.searchtecnologia.recurso.model.ocorrenciarenainf;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import com.searchtecnologia.recurso.model.uf.UF;
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
@Table(schema = "MULTA", name = "MM_RINF_OCORRENCIAS_OCOR")
public class OcorrenciaRenainf implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private OcorrenciaRenainfPK id;

    @ManyToOne
    @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO", insertable = false, updatable = false)
    private OrgaoAutuador orgaoAutuador;

    @Column(name = "MU_MUL_SEQUENCIAL")
    private String sequencialAutoInfracao;

    @Column(name = "MM_OCOR_ORIGEM_OCORRENCIA")
    private String orgaoOrigemOcorrencia; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA MM_OCOR_ORIGEM_OCORRENCIA DA PARA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "MM_OCOR_CODIGO_RETORNO")
    private String resultadoExecucao; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA MM_OCOR_CODIGO_RETORNO DA PARA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "MM_OCOR_NUMERO_PROCESSO")
    private String numeroProcesso;

    @Column(name = "MM_OCOR_TIPO_LANCAMENTO")
    private String tipoLancamento; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA MM_OCOR_TIPO_LANCAMENTO DA PARA MAPEAR ENTIDADE OU ENUMERADOR?

    @Column(name = "MM_OCOR_UF_OCORRENCIA")
    @Enumerated(EnumType.STRING)
    private UF ufOcorrencia;

    @Column(name = "MM_OCOR_TRASACAO_REALIZADA")
    private String transacaoRealizada; //TODO TABELA MULTA.MM_RINF_OCORRENCIAS_OCOR, COLUNA MM_OCOR_TIPO_LANCAMENTO DA PARA MAPEAR ENTIDADE OU ENUMERADOR?

}
