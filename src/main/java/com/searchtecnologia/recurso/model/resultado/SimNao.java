package com.searchtecnologia.recurso.model.resultado;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public enum SimNao {

    S("S", "Sim"),
    N("N", "Não");

    private String valor;
    private String descricao;

    public static SimNao get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<SimNao, String> {

        @Override
        public String convertToDatabaseColumn(SimNao simOuNao) {
            return Optional.ofNullable(simOuNao)
                    .map(SimNao::getValor)
                    .orElse(null);
        }

        @Override
        public SimNao convertToEntityAttribute(String valor) {
            return SimNao.get(valor);
        }
    }

}
