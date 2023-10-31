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
public enum TipoJulgamento {

    INTERNO("I", "Interno(análise no órgão do operador)"),
    EXTERNO("E", "Externo (análise fora do órgão do operador)");


    private String valor;
    private String descricao;

    public static TipoJulgamento get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoJulgamentoConverter implements AttributeConverter<TipoJulgamento, String> {

        @Override
        public String convertToDatabaseColumn(TipoJulgamento tipoJulgamento) {
            return Optional.ofNullable(tipoJulgamento)
                    .map(TipoJulgamento::getValor)
                    .orElse(null);
        }

        @Override
        public TipoJulgamento convertToEntityAttribute(String valor) {
            return TipoJulgamento.get(valor);
        }
    }

}
