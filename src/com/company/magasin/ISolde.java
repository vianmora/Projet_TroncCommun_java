package com.company.magasin;

public interface ISolde {

    void active_solde(boolean oui) throws PasEntre0et100Exception;
    double get_taux_remise();
    void set_taux_remise(double remise) throws PasEntre0et100Exception;
}
