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
public enum IndicadorAssinatura {

    ASSINADO("1", "Assinado"),
    NAO_ASSINADO("2", "Não assinado");

    private String valor;
    private String descricao;

    public static IndicadorAssinatura get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<IndicadorAssinatura, String> {

        @Override
        public String convertToDatabaseColumn(IndicadorAssinatura simOuNao) {
            return Optional.ofNullable(simOuNao)
                    .map(IndicadorAssinatura::getValor)
                    .orElse(null);
        }

        @Override
        public IndicadorAssinatura convertToEntityAttribute(String valor) {
            return IndicadorAssinatura.get(valor);
        }
    }

}
