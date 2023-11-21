package com.searchtecnologia.recurso.model.recurso;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public enum TipoRecurso {

    DEFESA_PREVIA("D", "Defesa prévia"),
    RECURSO_JARI("J", "Recurso jari"),
    RECURSO_CETRAN("S", "Recurso cetran"),
    ADVERTENCIA("A", "Solicitação de advertência");

    private String valor;
    private String descricao;

    public static TipoRecurso get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoRecursoConverter implements AttributeConverter<TipoRecurso, String> {

        @Override
        public String convertToDatabaseColumn(TipoRecurso tipoRecurso) {
            return Optional.ofNullable(tipoRecurso)
                    .map(TipoRecurso::getValor)
                    .orElse(null);
        }

        @Override
        public TipoRecurso convertToEntityAttribute(String valor) {
            return TipoRecurso.get(valor);
        }
    }
}
