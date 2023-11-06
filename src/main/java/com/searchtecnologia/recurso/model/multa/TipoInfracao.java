package com.searchtecnologia.recurso.model.multa;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public enum TipoInfracao {

    PF_PJ("E", "Infracao PF/PJ"),
    ESTRANGEIRO("F", "Veículo Estrangeiro");

    private String valor;
    private String descricao;

    public static TipoInfracao get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<TipoInfracao, String> {

        @Override
        public String convertToDatabaseColumn(TipoInfracao simOuNao) {
            return Optional.ofNullable(simOuNao)
                    .map(TipoInfracao::getValor)
                    .orElse(null);
        }

        @Override
        public TipoInfracao convertToEntityAttribute(String valor) {
            return TipoInfracao.get(valor);
        }
    }

}
