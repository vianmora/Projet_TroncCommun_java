package com.company.personne.personnel;

import com.company.personne.NumSecuException;
import com.company.personne.Personne;

public class Enseignant extends Personnel {
    private String _echelon;
    private double _fixe;
    private int _heure_travail;
    private int _tps_missions;
    private int _nb_heuresup;

    static double _prime = 100;
    static double _taux_heuresup = 1.15;
    static double _fixePRAG;
    static double _fixeMDC;
    static double _fixePROF;

    public Enseignant(String nom, String prenom, String num_secu, int annee_entree, boolean tps_plein, int temps_travail, String echelon, int tps_mission) throws NumSecuException {
        super(nom, prenom, num_secu, annee_entree, tps_plein, temps_travail);
        if(echelon.equals("PRAG")) {
            _fixe = _fixePRAG;
        }
        else if(echelon.equals("MDC")){
            _fixe = _fixeMDC;
        }
        else if(echelon.equals("PROF")){
            _fixe = _fixePROF;
        }

        _heure_travail = 0;
        _tps_missions = tps_mission;
        _echelon = echelon;
        _nb_heuresup = 0;
    }

    public Enseignant(Personne P, int annee_entree, boolean tps_plein, int temps_travail, String echelon, int tps_mission ){
        super(P, annee_entree, tps_plein, temps_travail);
        if(echelon.equals("PRAG")){
            _fixe = _fixePRAG;
        }
        else if(echelon.equals("MDC")){
            _fixe = _fixeMDC;
        }
        else if(echelon.equals("PROF")){
            _fixe = _fixePROF;
        }

        _heure_travail = 0;
        _tps_missions = tps_mission;
        _echelon = echelon;
        _nb_heuresup = 0;
    }

    public double calculSalaire(){
        double salaire = _fixe+(_taux_heuresup*_nb_heuresup);
        if (_echelon == "MDC" && _heure_travail >= 192-_tps_missions){
            salaire += _prime;
        }
        else if (_echelon == "PRAG" && _heure_travail >= 384-_tps_missions){
            salaire += _prime;
        }
        else if (_echelon == "PROF" && _heure_travail >= 96-_tps_missions){
            salaire += _prime;
        }
        return salaire;
    }

    public static void set_prime(double prime) {
        _prime = prime;
    }

    public static void set_fixeMDC(double fixeMDC) {
        _fixeMDC = fixeMDC;
    }
    public static void set_fixePRAG(double fixePRAG) {
        _fixePRAG = fixePRAG;
    }
    public static void set_fixePROF(double fixePROF) {
        _fixePROF = fixePROF;
    }

    public void set_heure_travail(int heure_travail) {
        this._heure_travail = heure_travail;
    }
}
