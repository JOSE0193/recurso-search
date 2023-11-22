package com.searchtecnologia.recurso.model.cancelamento;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;


@AllArgsConstructor
@Getter
public enum OrigemOcorrencia {


    JARI("1", "Jari"),
    CETRAN("2", "Concluído"),
    ORGAO_AUTUADOR("3", "Cancelado"),
    PODER_JUDICIARIO("4", "Poder Judiciário"),
    DETRAN_PROTOCOLO("5", "Detran de Protocolo");

    private String valor;
    private String descricao;

    public static OrigemOcorrencia get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<OrigemOcorrencia, String> {

        @Override
        public String convertToDatabaseColumn(OrigemOcorrencia ocorrencia) {
            return Optional.ofNullable(ocorrencia)
                    .map(OrigemOcorrencia::getValor)
                    .orElse(null);
        }

        @Override
        public OrigemOcorrencia convertToEntityAttribute(String valor) {
            return OrigemOcorrencia.get(valor);
        }
    }

}
