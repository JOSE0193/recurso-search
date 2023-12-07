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
public enum TipoJulgamentoResultado {

    DEFERIDO("D", "Deferido"),
    INDEFERIDO("I", "Indeferido");

    private String valor;
    private String descricao;

    public static TipoJulgamentoResultado get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoJulgamentoConverter implements AttributeConverter<TipoJulgamentoResultado, String> {

        @Override
        public String convertToDatabaseColumn(TipoJulgamentoResultado tipoJulgamento) {
            return Optional.ofNullable(tipoJulgamento)
                    .map(TipoJulgamentoResultado::getValor)
                    .orElse(null);
        }

        @Override
        public TipoJulgamentoResultado convertToEntityAttribute(String valor) {
            return TipoJulgamentoResultado.get(valor);
        }
    }

}
