package com.company.magasin.magasin_exceptions;

public class AgeVenteException extends MagasinException{
    public String getMessage(){
        return "désolé, vous etes trop jeune pour acheter...";
    }
}
