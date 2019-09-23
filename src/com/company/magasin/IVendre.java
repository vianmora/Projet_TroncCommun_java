package com.company.magasin;

import com.company.magasin.magasin_exceptions.AgeVenteException;
import com.company.magasin.magasin_exceptions.MagasinException;
import com.company.magasin.magasin_exceptions.PasAssezStockException;
import com.company.magasin.magasin_exceptions.VenteEntierException;

public interface IVendre {
    String get_intitule();
    double get_prix ();
    void retire_quantite (double quantite, int age)  throws MagasinException;
}
