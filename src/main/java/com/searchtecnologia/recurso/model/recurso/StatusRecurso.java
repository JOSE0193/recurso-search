package com.searchtecnologia.recurso.model.recurso;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum StatusRecurso {

    EM_ABERTO("00", "Em Aberto"),
    EM_ANALISE("01", "Em análise"),
    RESULTADOS_LANCADOS("02", "Resultados lançados"),
    ANALISE_CONCLUIDA("03", "Análise concluída"),
    CARTA_RESULTADO_EMITIDA("05", "Carta de resultado emitida"),
    CANCELADO("06", "Cancelado"),
    CIENTE_RESULTADO("07", "Ciente do resultado");

    private String valor;
    private String descricao;

    public static StatusRecurso get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class StatusRecursoConverter implements AttributeConverter<StatusRecurso, String> {

        @Override
        public String convertToDatabaseColumn(StatusRecurso statusRecurso) {
            return Optional.ofNullable(statusRecurso)
                    .map(StatusRecurso::getValor)
                    .orElse(null);
        }

        @Override
        public StatusRecurso convertToEntityAttribute(String valor) {
            return StatusRecurso.get(valor);
        }
    }
}
