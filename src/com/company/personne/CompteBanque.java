package com.company.personne;

import java.io.*;


public class CompteBanque implements Serializable{
    private int _numero;
    private String _ordre_payment;
    private double _solde;
    private double _decouvert_autorise;
    private String _code1;
    private String _code2;
    private static int _nb_CB;

    public CompteBanque(String ordre_payment, String code1, String code2){
        _nb_CB ++;
        _numero = _nb_CB;
        _ordre_payment = ordre_payment;
        _solde = 0;
        _decouvert_autorise = 0;
        _code1 = code1;
        _code2 = code2;
    }

    // getteurs

    public double get_decouvert_autorise() {
        return _decouvert_autorise;
    }

    public double get_solde() {
        return _solde;
    }

    public int get_numero() {
        return _numero;
    }

    public String get_client() {
        return _ordre_payment;
    }

    //setteurs

    public void set_decouvert_autorise(double decouvert_autorise, String code2) throws CBException{
        if (code2.equals(_code2)){
            _decouvert_autorise = decouvert_autorise;
        }
        else{
            throw new CodeCBException();
        }
    }

    public void set_solde(double solde, String code1) throws CBException{
        if (code1.equals(_code1)){
            _solde = solde;
        }
        else{
            throw new CodeCBException();
        }
    }

    // methodes

    public void versement (double montant, String code1) throws CBException{
        if (code1.equals(_code1)){
            _solde += montant;
        }
        else{
            throw new CodeCBException();
        }
    }

    public void retrait (double montant, String code1) throws CBException{
        if (code1.equals(_code1)){
            double solde_temp = _solde - montant;
            if (solde_temp < _decouvert_autorise){
                throw new RetraitCBException();
            }
            else{
                _solde -= montant;
            }
        }
        else{
            throw new CodeCBException();
        }
    }

    public void test_code(String code) throws CBException{
        if (!code.equals(_code1)){
            throw new CodeCBException();
        }
    }
}
