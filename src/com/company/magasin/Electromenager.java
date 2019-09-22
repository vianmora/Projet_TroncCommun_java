package com.company.magasin;

public class Electromenager extends Article{
    private static double _tx_remise = 10;
    public Electromenager (String intitule, double prix_achat, double prix){
        super(intitule, prix_achat, prix);
    }

    //pour la pub
    public String message_pub() {
        return "Envie d'une belle maison ? N'essayer plus, vivez dans la rue.";
    }

    //pour les soldes
    public void active_solde(boolean oui) throws PasEntre0et100Exception{
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
