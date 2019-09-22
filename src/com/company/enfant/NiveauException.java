package com.company.enfant;

public class NiveauException extends Exception {

    @Override
    public String getMessage() {
        return "Le niveau renseigné ne correspond pas à la classe choisie";
    }
}
