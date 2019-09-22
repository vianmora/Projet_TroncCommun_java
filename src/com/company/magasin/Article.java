package com.company.magasin;

abstract class Article implements IPublicite, ISolde, IVendre, IStock{
    private String _intitule;
    private double _prix;
    private double _prix_achat;
    private double _quantite;
    private double _tx_remise;

    public Article (String intitule, double prix_achat, double prix){
        _intitule = intitule;
        _prix = prix;
        _prix_achat = prix_achat;
        _quantite = 0;
        _tx_remise = 0;
    }

    // methodes pour vendre

    public String get_intitule() {
        return _intitule;
    }

    public double get_prix(){ return _prix*(1-_tx_remise/100);}

    public void retire_quantite (double quantite) throws PasAssezStockException{
        if(_quantite-quantite <0)
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

    protected void set_tx_remise(double tx_remise) throws PasEntre0et100Exception{
        if (tx_remise<0||tx_remise>100)
            throw new PasEntre0et100Exception();
        else
            _tx_remise = tx_remise;
    }
}
