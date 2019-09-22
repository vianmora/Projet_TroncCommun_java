package com.company.personne;

public class RetraitCBException extends CBException {

    public String getMessage() {
        return "désolé, vous avez atteind le découvert authorisé";
    }

    public String getMessage(CompteBanque CB) {
        return "désolé, le compte bancaire "+CB.get_client()+" a atteind le découvert autorisé";
    }
}
