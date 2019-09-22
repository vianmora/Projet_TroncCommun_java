package com.company.personne.personnel;

import com.company.personne.NumSecuException;

public class IATOS extends Personnel {
    private int _fixe;
    private int _nb_heuresup;
    private int _taux_heuresup;

    public IATOS(String nom, String prenom, String num_secu, int date_entree, boolean tps_plein, int tps_travail, int fixe, int taux_heuresup) throws NumSecuException {
        super(nom, prenom, num_secu, date_entree, tps_plein, tps_travail);
        _fixe = fixe;
        _nb_heuresup = 0;
        _taux_heuresup = taux_heuresup;
    }

    public double calculSalaire(){
        return _fixe+(_taux_heuresup*_nb_heuresup);
    }
}
