package com.searchtecnologia.recurso.service.veiculo.impl;

import com.searchtecnologia.recurso.service.veiculo.VeiculoService;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Override
    public String conversorPlacaMercosul(String placa) {

        if (placa.length() != 7) {
            return placa;
        }
        char temp;
        char quintoCaractere = placa.charAt(4);

        switch (quintoCaractere) {
            case '0':
                temp = 'A';
                break;
            case '1':
                temp = 'B';
                break;
            case '2':
                temp = 'C';
                break;
            case '3':
                temp = 'D';
                break;
            case '4':
                temp = 'E';
                break;
            case '5':
                temp = 'F';
                break;
            case '6':
                temp = 'G';
                break;
            case '7':
                temp = 'H';
                break;
            case '8':
                temp = 'I';
                break;
            case '9':
                temp = 'J';
                break;
            default:
                temp = quintoCaractere;
                break;
        }

        String saida = placa.substring(0, 4) + temp + placa.substring(5, 7);

        return saida;
    }

}
