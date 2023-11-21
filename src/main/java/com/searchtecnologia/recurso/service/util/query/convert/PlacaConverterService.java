package com.searchtecnologia.recurso.service.util.query.convert;

import org.springframework.stereotype.Service;

@Service
public class PlacaConverterService {

    public String convertPlacaMercosul(String placa) {
        if (placa == null || placa.length() != 7) {
            return placa;
        }

        char fifthChar = placa.charAt(4);
        char newFifthChar;

        switch (fifthChar) {
            case '0':
                newFifthChar = 'A';
                break;
            case '1':
                newFifthChar = 'B';
                break;
            case '2':
                newFifthChar = 'C';
                break;
            case '3':
                newFifthChar = 'D';
                break;
            case '4':
                newFifthChar = 'E';
                break;
            case '5':
                newFifthChar = 'F';
                break;
            case '6':
                newFifthChar = 'G';
                break;
            case '7':
                newFifthChar = 'H';
                break;
            case '8':
                newFifthChar = 'I';
                break;
            case '9':
                newFifthChar = 'J';
                break;
            default:
                newFifthChar = fifthChar;
        }

        return placa.substring(0, 4) + newFifthChar + placa.substring(5, 7);
    }
}
