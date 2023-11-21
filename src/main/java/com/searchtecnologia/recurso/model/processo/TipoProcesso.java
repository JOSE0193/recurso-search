package com.searchtecnologia.recurso.model.processo;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public enum TipoProcesso {

    D("D", "Defesa prévia"),
    J("J", "Recurso jari"),
    S("S", "Recurso cetran"),
    A("A", "Solicitação de advertência");

    private String valor;
    private String descricao;

    public static TipoProcesso get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoProcessoConverter implements AttributeConverter<TipoProcesso, String> {

        @Override
        public String convertToDatabaseColumn(TipoProcesso tipoRecurso) {
            return Optional.ofNullable(tipoRecurso)
                    .map(TipoProcesso::getValor)
                    .orElse(null);
        }

        @Override
        public TipoProcesso convertToEntityAttribute(String valor) {
            return TipoProcesso.get(valor);
        }
    }

}
