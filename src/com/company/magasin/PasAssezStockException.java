package com.company.magasin;

public class PasAssezStockException extends Exception{
    public String get_message(){
        return "Il n'y a pas assez de marchandise pour le vendre";
    }
}
