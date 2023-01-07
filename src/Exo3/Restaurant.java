package Exo3;

import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    Cafetiere cafetiere ;
    double profit ;

    List<Client> listeClientServi = new ArrayList<>() ;

    String nom ;

   public Restaurant () {
        this.cafetiere = new Cafetiere() ;
        this.listeClientServi = new ArrayList<>() ;
        this.nom = "Le Restaurant" ;
    }

   public Restaurant (String nom) {
        this.nom = nom ;
        this.cafetiere = new Cafetiere() ;
        this.listeClientServi = new ArrayList<>() ;
    }

    //  Pour servir un client,
    //  teste qu’il respecte les règles de gestion (differentes règles ci-dessous et celle dans cafetière),
    //  lui ajoute son café, lui donne sa facture dans valeurFacture, puis ajoute le profit au restaurant.
   public double servir (Client client) {

        client.valeurFacture = 0 ;
       System.out.println("Au début de la méthode servir client " + client.nom);
        if (client.commandeCafe != null && client.commandeCafe.typeCafe != TypeCafe.BATARD) {
            System.out.println("Je tente traitement pour " + client.nom);
            if (client.tasse == null)
            {
                System.out.println("Le client " + client.nom + " n'a pas de tasse");
                // CEPENDANT, si sa commande est de plus de 100 ml,
                // une tasse de 500 ml lui est offerte, et son coût monte à 3 euros.
                if (client.commandeCafe.quantiteLiquideMl > 100)
                {
                    System.out.println("Le client " + client.nom + " a une grande commande");
                    client.tasse = new Tasse(500);
                    client.valeurFacture += 3;

                }
                else // Si un client arrive sans tasse, sa facture augmente de 2 euros et
                // une tasse avec une capacité max de 100 ml lui est offerte
                {
                    System.out.println("Le client " + client.nom + " a une petite commande de 100ml");
                    client.tasse = new Tasse();
                    client.valeurFacture += 2;
                }

            }
            client.valeurFacture = client.commandeCafe.quantiteLiquideMl * client.commandeCafe.typeCafe.coutParMl;
            this.cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.tasse.quantiteCafeMax);
            this.profit = profit + client.valeurFacture ;
            System.out.println("Client name " + client.nom + " sa tasse " + client.tasse);
        }
        else
        // Le type de café bâtard n’est pas valide. Si un client demande du café bâtard, jetez-le hors du resto !
        // Quand un client est jeté hors du resto, son coût est de 0 et un message est écrit dans la console à cet effet.
        // Si un client arrive sans commande, jetez-le hors du resto !
        {
            client.valeurFacture = 0;
            System.out.println("Dégage de mon restaurant pauv' type !");
        }

       return client.valeurFacture;
   }

 public void  resultatRestaurant () {
     System.out.println("Je suis le restaurant : " + this.nom +
             ". Mon profit est de : " + this.profit
             + ". Le nombre de clients servis est : " + this.listeClientServi.size());
 }
}


