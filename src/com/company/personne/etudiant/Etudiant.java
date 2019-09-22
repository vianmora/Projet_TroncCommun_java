package com.company.personne.etudiant;
import com.company.personne.NumSecuException;
import com.company.personne.Personne;

abstract class Etudiant extends Personne {

    protected int _ine;
    protected int _promo;
    protected int _annee;

    public Etudiant (String nom, String prenom, String num_secu, int ine, int promo, int annee) throws NumSecuException {
        super(nom, prenom, num_secu);
        _ine = ine;
        _promo = promo;
        _annee = annee;
    }

    public Etudiant (Personne P, int ine, int promo, int annee){
        super(P);
        _ine = ine;
        _promo = promo;
        _annee = annee;
    }
}
