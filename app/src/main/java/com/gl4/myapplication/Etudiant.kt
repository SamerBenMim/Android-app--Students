package com.gl4.myapplication

class Etudiant(nom:String,prenom:String, presences : List<Presence>) {
    private val nom = nom;
    private val prenom = prenom;
    public val presences = presences;

    public fun getNom() : String {
        return this.nom;
    }
    public fun getPrenom() : String {
        return this.prenom;
    }

}
class Presence(matiere:String,presence:Boolean){
    public val matiere = matiere;
    public val presence = presence;
}