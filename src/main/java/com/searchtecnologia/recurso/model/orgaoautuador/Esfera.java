package com.searchtecnologia.recurso.model.orgaoautuador;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum Esfera {

    FEDERAL("F", "Federal"),
    ESTADUAL("E", "Estadual"),
    MUNICIPAL("M", "Municipal");

    private String valor;
    private String descricao;

    public static Esfera get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class EsferaConverter implements AttributeConverter<Esfera, String> {

        @Override
        public String convertToDatabaseColumn(Esfera esfera) {
            return Optional.ofNullable(esfera)
                    .map(Esfera::getValor)
                    .orElse(null);
        }

        @Override
        public Esfera convertToEntityAttribute(String valor) {
            return Esfera.get(valor);
        }
    }

}