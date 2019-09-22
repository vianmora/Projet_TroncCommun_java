package com.company.enfant;

import java.util.Arrays;
import java.util.List;

public class Ecolier extends Enfant implements Scolaire {
    public static String _niveauList [] = {"CP", "CE1", "CE2", "CM1", "CM2"};
    public String _niveau;

    public Ecolier(String nom, String prenom, char sexe, int annee_naissance, int mois_naissance, int dept_naissance, String niveau) throws NiveauException{
        super(nom, prenom, sexe, annee_naissance, mois_naissance, dept_naissance);
        try{
            set_niveau(niveau);
        }
        catch (NiveauException e){
            throw e;
        }

    }

    public Ecolier(Enfant E, String niveau) throws NiveauException{
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
        }
    }

    //interface

    public boolean petit() {
        return _niveau.equals("CP");
    }

    public boolean grand() {
        return (!_niveau.equals("CM2")&&!_niveau.equals("CP"));
    }

    public boolean moyen() {
        return _niveau.equals("CM2");
    }
}
