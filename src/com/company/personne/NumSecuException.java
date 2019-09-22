package com.company.personne;

public class NumSecuException extends Exception {

    public String getMessage() {
        return "le numéro de sécurité social entré est invalide...";
    }
}
