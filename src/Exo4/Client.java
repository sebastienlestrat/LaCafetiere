package Exo4;

public class Client {

    Tasse tasse ;
    Cafe commandeCafe ;
    String nom ;
    double valeurFacture ;

     Client (String nom, Cafe commandeCafe, boolean isWithTasse) {
        if (isWithTasse) {
            this.tasse = new Tasse(100) ;
        }

       this.nom = nom ;
       this.commandeCafe = commandeCafe ;
    }

    Client (String nom, Cafe commandeCafe, Tasse tasse) {
        this.nom = nom ;
        this.commandeCafe = commandeCafe ;
        this.tasse = tasse ;
    }

    Client () {
        this.nom = "Jean" ;
        this.commandeCafe = null ;
        this.tasse = new Tasse(100) ;
    }
}