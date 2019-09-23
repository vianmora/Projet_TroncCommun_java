package com.company.personne;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Personne {
    protected String _nom;
    protected String _prenom;
    protected String _num_secu;
    protected int _mois_naissance;
    protected int _annee_naissance;
    protected char _sexe;
    protected int _dept_naissance;

    // constructeurs

    public Personne(){

    }

    public Personne(String nom, String prenom){
        _nom = nom;
        _prenom = prenom;
        _mois_naissance = 0;
        _annee_naissance = 0;
        _num_secu = "0000000";
        _sexe = 'n';
        _dept_naissance = 0;
    }

    public Personne(Personne P){
        _nom = P.get_nom();
        _prenom = P.get_prenom();
        _mois_naissance = P.get_mois_naissance();
        _annee_naissance = P.get_annee_naissance();
        _num_secu = P.get_num_secu();
        _sexe = P.get_sexe();
        _dept_naissance = P.get_dept_naissance();
    }

    public Personne(String nom, String prenom, String num_secu) throws NumSecuException{
        _nom = nom;
        _prenom = prenom;
        set_numSecu(num_secu);
    }

    // private methodes

    private int SecuToAnneeNaissance(String num_secu){

        return Integer.parseInt("19"+num_secu.substring(1, 3));
    }

    private int SecuToMoisNaissance(String num_secu){
        return Integer.parseInt(num_secu.substring(3, 5));
    }

    private char SecuTosexe(String num_secu) throws NumSecuException{
        int i = Integer.parseInt(num_secu.substring(0,1));
        if (i==1){
            return 'M';
        }
        else if (i==2){
            return 'F';
        }
        else{
            throw new NumSecuException();
        }
    }

    private int SecuToDeptNaissance(String num_secu){
        return Integer.parseInt(num_secu.substring(5, 6));
    }

    //setteurs

    public void set_numSecu(String num_secu) throws NumSecuException {
        if (num_secu.length()!=13) {
            set_numSecu("1111111111111");
            throw new NumSecuException();
        }

        _num_secu = num_secu;
        try {
            _sexe = SecuTosexe(num_secu);
        }
        catch (NumSecuException e){
            throw new NumSecuException();
        }
        _annee_naissance = SecuToAnneeNaissance(num_secu);
        _mois_naissance = SecuToMoisNaissance(num_secu);
        _dept_naissance = SecuToDeptNaissance(num_secu);
    }

    public void set_nom(String nom){
        _nom = nom;
    }

    public void set_prenom(String prenom){
        _prenom = prenom;
    }

    //getteur

    public String get_nom(){
        return _nom;
    }

    public String get_prenom(){
        return _prenom;
    }

    public int get_age(){ return CalculAge();}

    public int get_annee_naissance(){ return _annee_naissance;}

    public int get_mois_naissance() {
        return _mois_naissance;
    }

    public char get_sexe() {
        return _sexe;
    }

    public int get_dept_naissance() {
        return _dept_naissance;
    }

    public String get_num_secu() {
        return _num_secu;
    }

    // methodes

    private int CalculAge(){
        java.util.Date J = new java.util.Date();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY");
        String annee = ft.format(J);
        return Integer.parseInt(annee) - _annee_naissance;
    }
}
