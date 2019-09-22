package com.company.enfant;

public class BB extends Enfant {

    public BB(String nom, String prenom, char sexe, int annee_naissance, int mois_naissance, int dept_naissance){
        super(nom, prenom, sexe, annee_naissance, mois_naissance, dept_naissance);
    }

    public BB(Enfant E){
        super(E.get_nom(), E.get_prenom(), E.get_sexe(), E.get_annee_naissance(), E.get_mois_naissance(), E.get_dept_naissance());
    }
}
