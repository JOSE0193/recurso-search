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
public enum TipoRecursoResultado {

    JARI("J", "Recurso jari"),
    ADVERTENCIA("A", "Solicitação de advertência"),
    DEFESA_PREVIA("D", "Defesa prévia"),
    SEGUNDA_INSTANCIA("S", "Segunda Instância");    ;

    private String valor;
    private String descricao;

    public static TipoRecursoResultado get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class TipoRecursoResultadoConverter implements AttributeConverter<TipoRecursoResultado, String> {

        @Override
        public String convertToDatabaseColumn(TipoRecursoResultado tipoRecurso) {
            return Optional.ofNullable(tipoRecurso)
                    .map(TipoRecursoResultado::getValor)
                    .orElse(null);
        }

        @Override
        public TipoRecursoResultado convertToEntityAttribute(String valor) {
            return TipoRecursoResultado.get(valor);
        }
    }

}
