package com.company;
import com.company.enfant.Ecolier;
import com.company.enfant.Enfant;
import com.company.enfant.Lyceen;
import com.company.enfant.NiveauException;
import com.company.magasin.*;
import com.company.personne.*;
import com.company.personne.personnel.Enseignant;
import com.company.personne.etudiant.EtudiantDigital;

import java.util.*;

public class Main {

    public static void main(String[] args){
	    // gérer les personnes & les comptes bancaires

        /* créer une nouvelle personne : Vianney MORAIN*/
        Personne P1 = new Personne("MORAIN","Vianney");

        /* lui ajouter un numéro de sécurité social*/
        try {
            P1.set_numSecu("1960275112006");
        }
        catch (NumSecuException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Bonjour "+P1.get_prenom()+" "+P1.get_nom()+" tu as " + P1.get_age()+" ans car tu es né en "+P1.get_annee_naissance());

        /* lui affecter un compte bancaire */
        CompteBanque CB_Vianney = new CompteBanque(P1.get_nom(), "hellojesuisuncode", "hellomoiaussi");

        /*tests*/
        System.out.println("Le compte banquaire numero " + CB_Vianney.get_numero() + " appartient au signor " + CB_Vianney.get_client());
        System.out.println("solde : " + CB_Vianney.get_solde());
        System.out.println("que voulez vous faire ? \n1 : retirer de l'argent\n2 : verser de l'argent");

        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();

        //reponse = "NULL";

        if (reponse.equals("1")){
            System.out.println("Combien ? : ");
            String reponsecombien = sc.nextLine();
            float montant = Integer.valueOf(reponsecombien).floatValue();
            try{
                CB_Vianney.retrait(montant, "hellojesuisuncode");
            }
            catch (CBException e){}
            System.out.println("votre solde est désormais de "+CB_Vianney.get_solde());
        }
        else if (reponse.equals("2")){
            System.out.println("Combien ? : ");
            String reponsecombien = sc.nextLine();
            float montant = Integer.valueOf(reponsecombien).floatValue();
            try{
                CB_Vianney.versement(montant, "hellojesuisuncode");
            }
            catch (CBException e){}
            System.out.println("votre solde est désormais de "+CB_Vianney.get_solde()+"€");
        }
        else{
            System.out.println("désolé je n'ai pas compris... tant pis pour vous");
        }

        // notes étudiantes

        /*créer un etudiant digital*/
        EtudiantDigital ED1 = new EtudiantDigital(P1, 1612508765, 2016, 3);


        /* ajouter une note */
        Note N1 = new Note("maths", 13);
        ED1.ajout_note(N1);
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

        System.out.println("Bonjour "+E.get_nom()+" votre salaire du mois est de "+E.calculSalaire()+" €");

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
        Primeur A1 = new Primeur("Pomme", 1.30, 2.40);
        Habit A2 = new Habit("tee-shirt", 0.15, 5.00);
        Electromenager A3 = new Electromenager("machine a lave", 150, 300);

        String code1 = "code1";
        Magasin ma_boutique = new Magasin("Chez moi", code1);

        try{
           // ajout du capital

            ma_boutique.add_capital(15000);

            // ajout des articles au catalogue

            ma_boutique.addArticle(A1, 100);
            ma_boutique.addArticle(A2, 100);
            ma_boutique.addArticle(A3, 10);

            // personne P1 achète un tee-shirt
            System.out.println(A2.get_intitule()+" coute "+A2.get_prix()+"€");
            ma_boutique.achat(A2, 1, CB_Vianney, "hellojesuisuncode");

            // activer les soldes
            A2.active_solde(true);

            //P1 veut réacheter un tee-shirt
            System.out.println(A2.get_intitule()+" coute "+A2.get_prix()+"€");
            ma_boutique.achat(A2, 1, CB_Vianney, "hellojesuisuncode");

            //combien ai-je dans ma trésorerie ?
            System.out.println("la tresorerie du magasin vaut "+ma_boutique.get_tresorerie()+"€");

            //quelle est la valeur de mon stock ?
            System.out.println("le stock du magasin vaut "+ma_boutique.get_valeur_stock()+"€");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
