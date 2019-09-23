package com.company;
import com.company.enfant.Enfant;
import com.company.enfant.Lyceen;
import com.company.enfant.NiveauException;
import com.company.magasin.*;
import com.company.magasin.Electromenager;
import com.company.magasin.Habit;
import com.company.magasin.Primeur;
import com.company.personne.*;
import com.company.personne.personnel.Enseignant;
import com.company.personne.etudiant.EtudiantDigital;

import java.util.*;

public class Main {

    public static void main(String[] args){
	    // gérer les personnes & les comptes bancaires

        /* créer une nouvelle personne : Vianney MORAIN*/
        Personne moi = new Personne("MORAIN","Vianney");
        System.out.println("Bonjour "+moi.get_prenom()+" "+moi.get_nom());

        /* lui ajouter un numéro de sécurité social*/
        try {
            moi.set_numSecu("1960275112006");
        }
        catch (NumSecuException e){
            System.out.println(e.getMessage());
        }

        System.out.println("le numero de securité social ajouté est le :  "+moi.get_num_secu());

        /* lui affecter un compte bancaire */
        CompteBanque CB_moi = new CompteBanque(moi.get_nom(), "hellojesuisuncode", "hellomoiaussi");

        System.out.println("vous avez le compte bancaire numero :  "+CB_moi.get_numero());

        /*mettre de l'argent (au black) sur son compte*/
        System.out.println("solde : " + CB_moi.get_solde()+"€");
        System.out.println("que voulez vous faire ? \n1 : retirer de l'argent\n2 : verser de l'argent");

        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        if (reponse.equals("1")){
            System.out.println("Combien ? : ");
            String reponsecombien = sc.nextLine();
            float montant = Integer.valueOf(reponsecombien).floatValue();
            try{
                CB_moi.retrait(montant, "hellojesuisuncode");
            }
            catch (CBException e){}
            System.out.println("votre solde est désormais de "+CB_moi.get_solde()+"€");
        }
        else if (reponse.equals("2")){
            System.out.println("Combien ? : ");
            String reponsecombien = sc.nextLine();
            float montant = Integer.valueOf(reponsecombien).floatValue();
            try{
                CB_moi.versement(montant, "hellojesuisuncode");
            }
            catch (CBException e){}
            System.out.println("votre solde est désormais de "+CB_moi.get_solde()+"€");
        }
        else{
            System.out.println("désolé je n'ai pas compris... tant pis pour vous");
        }

        // notes étudiantes

        /*créer un etudiant digital*/
        EtudiantDigital ED1 = new EtudiantDigital(moi, 1612508765, 2016, 3);


        /* ajouter une note */
        Note N1 = new Note("maths", 13);
        ED1.ajout_note(N1);
        System.out.println("La note de "+N1.get_note()+" en "+N1.get_matiere()+" a été ajouté au bulletin de " + ED1.get_prenom());

        if (ED1.valide("maths")){
            System.out.println("Bonjour "+ED1.get_prenom()+" vous validez en maths, félicitation !");
        }
        else{
            System.out.println("Bonjour "+ED1.get_prenom()+" désolé vous ne validez pas en maths...");
        }


        // salaires des profs

        /* créer un prof Enseignant */

        Personne Jean = new Personne("Jean", "Marc");
        Enseignant E = new Enseignant(Jean, 1998, true, 100, "PROF", 0);

        Enseignant.set_prime(150);
        E.set_heure_travail(112);

        System.out.println("\nBonjour "+E.get_nom()+" votre salaire du mois est de "+E.calculSalaire()+" €");

        // systeme scolaire

        /* créer un écolier*/
        Enfant petit_jean = new Enfant("Dupont", "jean", 'M', 2004, 2, 75);
        try {
            Lyceen Ecolier1 = new Lyceen(petit_jean, "1ere");
            System.out.println(Ecolier1.get_prenom() + " est en "+Ecolier1.get_niveau());
        }
        catch (NiveauException e){
            System.out.println(e.getMessage());
        }

        // créer 3 articles et un magasin
        Primeur pomme = new Primeur("Pomme", 1.30, 2.40);
        Habit tee_shirt = new Habit("tee-shirt", 0.15, 5.00);
        Electromenager machine_a_laver = new Electromenager("machine a laver", 150, 300);
        Alcool vodka = new Alcool("Vodka", 20, 30);

        String code1 = "code1";
        Magasin ma_boutique = new Magasin("Chez moi", code1, 2);

        try{
           // ajout du capital

            ma_boutique.add_capital(15000);

            // ajout des articles au catalogue

            ma_boutique.addArticle(pomme, 100);
            ma_boutique.addArticle(tee_shirt, 100);
            ma_boutique.addArticle(machine_a_laver, 10);
            ma_boutique.addArticle(vodka, 20);

            // personne moi achète un tee-shirt
            System.out.println(tee_shirt.get_intitule()+" coute "+tee_shirt.get_prix()+"€");
            ma_boutique.achat(tee_shirt, 1, CB_moi, "hellojesuisuncode", moi.get_age());

            // activer les soldes
            tee_shirt.active_solde(true);
            System.out.println("solde activées");

            //moi veut réacheter un tee-shirt
            System.out.println(tee_shirt.get_intitule()+" coute "+tee_shirt.get_prix()+"€");
            ma_boutique.achat(tee_shirt, 1, CB_moi, "hellojesuisuncode", moi.get_age());

            //combien ai-je dans ma trésorerie ?
            System.out.println("la tresorerie du magasin vaut "+ma_boutique.get_tresorerie()+"€");

            //quelle est la valeur de mon stock ?
            System.out.println("le stock du magasin vaut "+ma_boutique.get_valeur_stock()+"€");

            //petit_jean veut acheter une pomme avec ma carte bancaire
            System.out.println(pomme.get_intitule()+" coute "+tee_shirt.get_prix()+"€");
            ma_boutique.achat(pomme, 10.5, CB_moi, "hellojesuisuncode", petit_jean.get_age());

            //et une vodka ?
            System.out.println(vodka.get_intitule()+" coute "+tee_shirt.get_prix()+"€");
            ma_boutique.achat(vodka, 10.5, CB_moi, "hellojesuisuncode", petit_jean.get_age());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
