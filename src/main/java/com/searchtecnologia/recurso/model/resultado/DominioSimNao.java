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
public enum DominioSimNao {

    S("S", "Sim"),
    N("N", "Não");

    private String valor;
    private String descricao;

    public static DominioSimNao get(String valor) {
        return Arrays.stream(values())
                .filter(it -> it.valor.equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static class Converter implements AttributeConverter<DominioSimNao, String> {

        @Override
        public String convertToDatabaseColumn(DominioSimNao simOuNao) {
            return Optional.ofNullable(simOuNao)
                    .map(DominioSimNao::getValor)
                    .orElse(null);
        }

        @Override
        public DominioSimNao convertToEntityAttribute(String valor) {
            return DominioSimNao.get(valor);
        }
    }

}
