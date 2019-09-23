package com.company.magasin.magasin_exceptions;

public class VenteEntierException extends MagasinException{
    public String getMessage(){
        return "attention, vous ne pouvez acheter qu'un nombre entier de cet article";
    }
}
