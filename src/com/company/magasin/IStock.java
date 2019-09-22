package com.company.magasin;

public interface IStock {
    void set_intitule(String _intitule);
    double get_prix_achat();
    void ajout_quantite(double _quantite);
    double get_quantite();
}
