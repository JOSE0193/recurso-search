package com.searchtecnologia.recurso.model.infrator;

import com.searchtecnologia.recurso.model.orgaoautuador.OrgaoAutuador;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "MMA1HINF", schema = "MULTA")
public class HistoricoInfrator implements Serializable {

        @Id
        @EmbeddedId
        private HistoricoInfratorPK id;

        @Column(name = "MU_MUL_NUMERO_CNH")
        private String numeroCnh;

        @Column(name = "MU_MUL_CNH_UF")
        private String ufCnh;

        @Column(name = "MU_MUL_CPF_CONDUTOR")
        private String cpfCondutor;

        @Column(name = "MU_MUL_DOC_INFORMANTE")
        private String documentoInformante;

        @Column(name = "MU_MUL_OF_INFORMANTE")
        private String oficioInformante;

        @Column(name = "MU_HIN_OPERADOR")
        private String operador;

        @Column(name = "MU_HIN_ESTACAO")
        private String estacao;

        @Column(name = "MU_HIN_FUNCAO")
        private String funcao;

        @Column(name = "MU_HIN_NUM_CNH_ANTERIOR")
        private String numCnhAnterior;

        @Column(name = "MU_HIN_CNH_UF_ANTERIOR")
        private String cnhUfAnterior;

        @Column(name = "MU_HIN_TIPO_NUM_CNH_ANT")
        private String tipoNumCnhAnt;

        @Column(name = "MU_HIN_LOTE")
        private String lote;

        @Column(name = "MU_HIN_TIPO_ARQUIVAMENTO")
        private String tipoArquivamento;

        @Column(name = "MU_HIN_OPERACAO")
        private String operacao;

        @Column(name = "MU_HIN_NOME_INFRATOR")
        private String nomeInfrator;

        @Column(name = "MU_HIN_DATA_APRESENTACAO")
        private String dataApresentacao;

        @Column(name = "MU_HIN_TIPO_CNH_ATUAL")
        private String tipoCnhAtual;

        @Column(name = "MU_HIN_OBS")
        private String observacao;

        @Column(name = "TIPO_DOC_COND_INDIC_SEM_CNH")
        private String tipoDocCondIndicSemCnh;

        @ManyToOne
        @JoinColumn(name = "MM_OAU_CODIGO", referencedColumnName = "MM_OAU_CODIGO")
        private OrgaoAutuador orgaoAutuador;

    }
