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
public enum NovoPrazo {
    N("N", "O resultado não determina novo prazo"),
    D("D", "O resultado determina novo prazo para defesa prévia"),
    J("J", "O resultado determina novo prazo para recurso Jari");

    private String valor;
    private String descricao;

    public static NovoPrazo get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class NovoPrazoConverter implements AttributeConverter<NovoPrazo, String> {

        @Override
        public String convertToDatabaseColumn(NovoPrazo novoPrazo) {
            return Optional.ofNullable(novoPrazo)
                    .map(NovoPrazo::getValor)
                    .orElse(null);
        }

        @Override
        public NovoPrazo convertToEntityAttribute(String valor) {
            return NovoPrazo.get(valor);
        }
    }

}
