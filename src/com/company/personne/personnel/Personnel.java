package com.company.personne.personnel;

import com.company.personne.NumSecuException;
import com.company.personne.Personne;

abstract class Personnel extends Personne {
    private int _annee_entree;
    private int _temps_travail;
    private boolean _tps_plein;

    public Personnel (String nom, String prenom, String num_secu, int annee_entree, boolean tps_plein, int temps_travail) throws NumSecuException {
        super(nom, prenom, num_secu);
        _annee_entree = annee_entree;
        _tps_plein = tps_plein;
        if (tps_plein==true){
            _temps_travail = 100;
        }
        else{
            _temps_travail = temps_travail;
        }
    }

    public Personnel (Personne P, int annee_entree, boolean tps_plein, int temps_travail){
        super(P);
        _annee_entree = annee_entree;
        _tps_plein = tps_plein;
        if (tps_plein){
            _temps_travail = 100;
        }
        else{
            _temps_travail = temps_travail;
        }
    }

    abstract double calculSalaire();
}
