package com.company.personne.etudiant;

import com.company.personne.Note;
import com.company.personne.NumSecuException;
import com.company.personne.Personne;

import java.util.ArrayList;

public class EtudiantDigital extends Etudiant{
    private ArrayList <Note> _bulletin;
    private int _compteur_note;

    public EtudiantDigital (String nom, String prenom, String num_secu, int ine, int promo, int annee) throws NumSecuException {
        super(nom, prenom, num_secu, ine, promo, annee);
        _bulletin = new ArrayList<>();
        _compteur_note = 0;
    }

    public EtudiantDigital (Personne P, int ine, int promo, int annee){
        super(P, ine, promo, annee);
        _bulletin = new ArrayList<>();
        _compteur_note = 0;
    }

    //methodes

    public void ajout_note(Note note){
        _bulletin.add(note);
        _compteur_note++;
    }

    public boolean valide(String matiere){
        float moyenne = 0;
        int compt = 0;

        for (Note note:_bulletin){
            if (note.get_matiere().equals(matiere)){
                moyenne += note.get_note();
                compt ++;
            }
        }
        if (compt>0){
            return moyenne/compt>10;
        }
        return false;
    }
}
