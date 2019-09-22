package com.company.enfant;

import java.util.Arrays;
import java.util.List;

public class Lyceen extends Enfant implements Scolaire{
    private static String [] _niveauList = {"2nd", "1ere", "terminale"};
    private String _niveau;
    private boolean _aura_examens;

    public Lyceen(String nom, String prenom, char sexe, int annee_naissance, int mois_naissance, int dept_naissance, String niveau) throws NiveauException{
        super(nom, prenom, sexe, annee_naissance, mois_naissance, dept_naissance);
        try{
            set_niveau(niveau);
        }
        catch (NiveauException e){
            throw e;
        }
    }

    public Lyceen(Enfant E, String niveau) throws NiveauException{
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

    public boolean is_aura_examens() {
        return _aura_examens;
    }

    public void set_niveau(String niveau) throws NiveauException{
        List<String> list = Arrays.asList(_niveauList);
        if (!list.contains(niveau)){
            throw new NiveauException();
        }
        else {
            _niveau = niveau;
            _aura_examens = (grand()||moyen());
        }
    }

    //interface

    public boolean petit() {
        return _niveau.equals("2nd");
    }

    public boolean grand() {
        return (!_niveau.equals("terminale")&&!_niveau.equals("2nd"));
    }

    public boolean moyen() {
        return _niveau.equals("terminale");
    }
}

