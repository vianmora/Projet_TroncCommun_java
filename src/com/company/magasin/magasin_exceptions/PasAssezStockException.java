package com.company.magasin.magasin_exceptions;

public class PasAssezStockException extends MagasinException{
    public String getMessage(){
        return "Il n'y a pas assez de marchandise pour le vendre";
    }
}
