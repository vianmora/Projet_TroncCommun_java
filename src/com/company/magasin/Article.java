package com.company.magasin;

import com.company.magasin.IPublicite;
import com.company.magasin.ISolde;
import com.company.magasin.IStock;
import com.company.magasin.IVendre;
import com.company.magasin.magasin_exceptions.*;

abstract class Article implements IPublicite, ISolde, IVendre, IStock {
    private String _intitule;
    private double _prix;
    private double _prix_achat;
    private double _quantite;
    private double _tx_remise;
    private boolean _vente_au_kilo;
    private boolean _vente_aux_mineur;

    public Article (String intitule, double prix_achat, double prix, boolean vente_au_kilo, boolean vente_aux_mineurs){
        _intitule = intitule;
        _prix = prix;
        _prix_achat = prix_achat;
        _quantite = 0;
        _tx_remise = 0;
        _vente_au_kilo = vente_au_kilo;
        _vente_aux_mineur = vente_aux_mineurs;
    }

    // methodes pour vendre

    public String get_intitule() {
        return _intitule;
    }

    public double get_prix(){ return _prix*(1-_tx_remise/100);}

    public void retire_quantite (double quantite, int age) throws MagasinException {
        int iquantite = (int)quantite;
        double dquantite = (double)iquantite;

        if((!_vente_aux_mineur && age<18) || age<10) {
            throw new AgeVenteException();
        }
        else if (!_vente_au_kilo && dquantite != quantite)
            throw new VenteEntierException();

        else if (_quantite - quantite < 0)
            throw new PasAssezStockException();

        else
            _quantite -= quantite;

    }

    //public void set_prix_art(double prix){_prix = prix;}

    //methodes pour gérer les stocks

    public double get_prix_achat() {
        return _prix_achat;
    }

    public void ajout_quantite(double _quantite) {
        this._quantite += _quantite;
    }

    public void set_intitule(String _intitule) {
        this._intitule = _intitule;
    }

    public double get_quantite() {
        return _quantite;
    }

    //methode pour les solde

    protected void set_tx_remise(double tx_remise) throws PasEntre0et100Exception {
        if (tx_remise<0||tx_remise>100)
            throw new PasEntre0et100Exception();
        else
            _tx_remise = tx_remise;
    }
}
