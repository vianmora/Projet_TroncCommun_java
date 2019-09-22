package com.company.enfant;

public class Enfant {
    protected String _nom;
    protected String _prenom;
    protected int _mois_naissance;
    protected int _annee_naissance;
    protected char _sexe;
    protected int _dept_naissance;

    public Enfant(String nom, String prenom, char sexe, int annee_naissance, int mois_naissance, int dept_naissance){
        _nom = nom;
        _prenom = prenom;
        _sexe = sexe;
        _annee_naissance = annee_naissance;
        _mois_naissance = mois_naissance;
        _dept_naissance = dept_naissance;
    }

    public String get_nom() {
        return _nom;
    }

    public char get_sexe() {
        return _sexe;
    }

    public int get_annee_naissance() {
        return _annee_naissance;
    }

    public int get_dept_naissance() {
        return _dept_naissance;
    }

    public int get_mois_naissance() {
        return _mois_naissance;
    }

    public String get_prenom() {
        return _prenom;
    }

    public void set_prenom(String _prenom) {
        this._prenom = _prenom;
    }
}
