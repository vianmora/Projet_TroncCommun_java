package com.company.magasin;

import com.company.magasin.magasin_exceptions.MagasinException;
import com.company.magasin.magasin_exceptions.PasAssezStockException;
import com.company.personne.CBException;
import com.company.personne.CompteBanque;

import java.util.ArrayList;

public class Magasin {
    private String _nom;
    private ArrayList<Article> _catalogue;
    private int _nb_vendeur;
    private CompteBanque _CB;
    private String _codeCB;

    public Magasin (String nom, String code, int nb_vendeur){
        _nom = nom;
        _CB = new CompteBanque(nom, code, "1234");
        _codeCB = code;
        _catalogue = new ArrayList<>();
        _nb_vendeur = nb_vendeur;
    }

    public String get_nom() {
        return _nom;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }

    public CompteBanque get_CB() {
        return _CB;
    }

    public void add_capital (double montant){
        try {
            _CB.versement(montant, _codeCB);
        }
        catch (Exception e){}
    }

    public double get_tresorerie(){
        return _CB.get_solde();
    }

    public void addArticle(Article art, double quantite) throws CBException {
        try{
            _CB.retrait(art.get_prix_achat()*quantite, _codeCB);
            art.ajout_quantite(quantite);
            _catalogue.add(art);
        }
        catch (CBException e){
            throw e;
        }
    }

    public void achat (Article art, double quantite, CompteBanque CB_client, String code_client, int age_client) throws CBException, MagasinException{
        if (_catalogue.contains(art)){
            Article article = _catalogue.get(_catalogue.indexOf(art));
            double prix = art.get_prix()*quantite;

            try {
                art.retire_quantite(quantite, age_client);
                CB_client.retrait(prix, code_client);
                _CB.versement(prix, _codeCB);
                System.out.println("Achat effectué");
            }
            catch (CBException e){
                art.ajout_quantite(quantite);
                throw e;
            }
            catch (MagasinException ex){
                throw ex;
            }
        }
        else
            throw new PasAssezStockException();
    }

    public double get_valeur_stock(){
        double valeur = 0;
        for (Article art:_catalogue) {
            valeur += art.get_prix()*art.get_quantite();
        }
        return valeur;
    }
}
