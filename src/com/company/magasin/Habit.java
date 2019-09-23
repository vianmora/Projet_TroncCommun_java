package com.company.magasin;

import com.company.magasin.magasin_exceptions.PasEntre0et100Exception;

public class Habit extends Article {
    private static double _tx_remise = 10;

    public Habit (String intitule, double prix_achat_unit, double prix_unit){
        super(intitule, prix_achat_unit, prix_unit, false, true);
    }

    //pour la pub
    public String message_pub() {
        return "Pas encore pret pour le nudisme ? Habillez vous !";
    }

    //pour les soldes

    public void active_solde(boolean oui) throws PasEntre0et100Exception {
        if(oui)
            try{
                set_taux_remise(_tx_remise);
            }
            catch (PasEntre0et100Exception e){
                throw e;
            }
        else
            set_taux_remise(0);
    }

    public double get_taux_remise(){
        return _tx_remise;
    }

    public void set_taux_remise(double tx_remise) throws PasEntre0et100Exception {
        if(tx_remise<0||tx_remise>100)
            throw new PasEntre0et100Exception();
        else
            _tx_remise = tx_remise;
    }
}
