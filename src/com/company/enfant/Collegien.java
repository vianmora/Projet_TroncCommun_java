package com.company.enfant;

import java.util.Arrays;
import java.util.List;

public class Collegien extends Enfant {
    private static String []_niveauList = {"6e", "5e", "4e", "3e"};
    private String _niveau;
    private boolean _aura_examens;

    public Collegien(String nom, String prenom, char sexe, int annee_naissance, int mois_naissance, int dept_naissance, String niveau) throws NiveauException{
        super(nom, prenom, sexe, annee_naissance, mois_naissance, dept_naissance);
        try{
            set_niveau(niveau);
        }
        catch (NiveauException e){
            throw e;
        }

    }

    public Collegien(Enfant E, String niveau) throws NiveauException{
        super(E.get_nom(), E.get_prenom(), E.get_sexe(), E.get_annee_naissance(), E.get_mois_naissance(), E.get_dept_naissance());
        try{
            set_niveau(niveau);
        }
        catch (NiveauException e){
            throw e;
        }
    }

    public String get_niveau() {
        return _niveau;
    }

    public void set_niveau(String niveau) throws NiveauException{
        List<String> list = Arrays.asList(_niveauList);
        if (!list.contains(niveau)){
            throw new NiveauException();
        }
        else {
            _niveau = niveau;
            _aura_examens = grand();
        }
    }

    //interface

    public boolean petit() {
        return _niveau.equals("6eme");
    }

    public boolean grand() {
        return (!_niveau.equals("6eme")&&!_niveau.equals("3eme"));
    }

    public boolean moyen() {
        return _niveau.equals("3eme");
    }
}
