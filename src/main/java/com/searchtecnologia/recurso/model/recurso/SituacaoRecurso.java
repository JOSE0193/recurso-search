package com.searchtecnologia.recurso.model.recurso;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum SituacaoRecurso {

    EM_ABERTO("0", "Em aberto"),
    CONCLUIDO("1", "Concluído"),
    CANCELADO("3", "Cancelado"),
    NOTIFICACAO_RESULTADO_EMITIDA("5", "Notificação do resultado emitida"),
    CIENTE_RESULTADO("7", "Ciente do resultado");

    private String valor;
    private String descricao;

    public static SituacaoRecurso get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class SituacaoRecursoConverter implements AttributeConverter<SituacaoRecurso, String> {

        @Override
        public String convertToDatabaseColumn(SituacaoRecurso situacaoRecurso) {
            return Optional.ofNullable(situacaoRecurso)
                    .map(SituacaoRecurso::getValor)
                    .orElse(null);
        }

        @Override
        public SituacaoRecurso convertToEntityAttribute(String valor) {
            return SituacaoRecurso.get(valor);
        }
    }
}