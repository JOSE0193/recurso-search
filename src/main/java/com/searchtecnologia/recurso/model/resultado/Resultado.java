package com.searchtecnologia.recurso.model.resultado;

import com.searchtecnologia.recurso.model.processo.Processo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(schema = "MULTA", name = "MMA1TREJ")
public class Resultado implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ResultadoPK id;

    @NotNull
    @Column(name = "MM_REJ_DESCRICAO")
    private String descricao;

    @Column(name = "MM_REJ_TIPO_JULGAMENTO")
    @Convert(converter = TipoJulgamentoResultado.TipoJulgamentoConverter.class)
    private TipoJulgamentoResultado tipoJulgamento;

    @Column(name = "MM_REJ_TIPO_RECURSO")
    @Convert(converter = TipoRecursoResultado.TipoRecursoResultadoConverter.class)
    private TipoRecursoResultado tipoRecurso;

    @Column(name = "MM_REJ_ATIVO")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao ativo;

    @Column(name = "MM_REJ_EXIGE_EDITAL")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao exigeEdital;

    @Column(name = "MM_REJ_REC_CONHECIDO_SN")
    @Convert(converter = DominioSimNao.Converter.class)
    private DominioSimNao conhecido;

    @Column(name = "MM_REJ_NOVO_PRAZO")
    @Convert(converter = NovoPrazo.NovoPrazoConverter.class)
    private NovoPrazo novoPrazo;

    @OneToMany(mappedBy = "resultado",  cascade = CascadeType.ALL)
    private List<MotivoResultado> motivosResultado;

    @OneToMany(mappedBy = "resultado",  cascade = CascadeType.ALL)
    private List<Processo> processos;

}
