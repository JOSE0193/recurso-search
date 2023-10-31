package com.searchtecnologia.recurso.model.jari;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public enum TipoJari {

    JARI("J", "Jari"),
    AUTUACAO("A", "Autuacao");


    private String valor;
    private String descricao;

    public static TipoJari get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoJariConverter implements AttributeConverter<TipoJari, String> {

        @Override
        public String convertToDatabaseColumn(TipoJari tipoJari) {
            return Optional.ofNullable(tipoJari)
                    .map(TipoJari::getValor)
                    .orElse(null);
        }

        @Override
        public TipoJari convertToEntityAttribute(String valor) {
            return TipoJari.get(valor);
        }
    }

}
