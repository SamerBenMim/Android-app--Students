package com.gl4.myapplication

class Etudiant(nom:String,prenom:String, presences : Boolean) {
    private val nom = nom;
    private val prenom = prenom;
    public var presences = presences;

    public fun getNom() : String {
        return this.nom;
    }
    public fun getPrenom() : String {
        return this.prenom;
    }


}
