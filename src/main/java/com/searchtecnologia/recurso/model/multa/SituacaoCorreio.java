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
public enum SituacaoCorreio {

    VOLTOU("V", "Indica que o auto voltou de NP para NA"),
    NAO_NP("N", "Multa paga em fase autuação que não terá a NP emitida");

    private String valor;
    private String descricao;

    public static SituacaoCorreio get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<SituacaoCorreio, String> {

        @Override
        public String convertToDatabaseColumn(SituacaoCorreio simOuNao) {
            return Optional.ofNullable(simOuNao)
                    .map(SituacaoCorreio::getValor)
                    .orElse(null);
        }

        @Override
        public SituacaoCorreio convertToEntityAttribute(String valor) {
            return SituacaoCorreio.get(valor);
        }
    }

}
