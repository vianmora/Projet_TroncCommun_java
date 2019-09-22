package com.company.personne;

public class Note {
    private String _matiere;
    private float _note;

    public Note(String matiere, int note){
        _matiere = matiere;
        _note = note;
    }

    public float get_note() {
        return _note;
    }

    public String get_matiere() {
        return _matiere;
    }

    public void set_note(float new_note){
        _note = new_note;
    }
}
