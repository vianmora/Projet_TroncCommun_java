package com.company.magasin;

public interface IVendre {
    String get_intitule();
    double get_prix ();
    void retire_quantite (double quantite)  throws PasAssezStockException;
}
