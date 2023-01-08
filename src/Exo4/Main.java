package Exo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String args[]) {

        Restaurant restaurant1 = new Restaurant(" Latte sur les rochers ") ;
        Restaurant restaurant2 = new Restaurant(" Une tasse de joie ") ;
        Restaurant restaurant3 = new Restaurant() ;

        List<Restaurant> mesDifferentsRestaurants = new ArrayList<>() ;
        mesDifferentsRestaurants.add(restaurant1);
        mesDifferentsRestaurants.add(restaurant2);
        mesDifferentsRestaurants.add(restaurant3);

        // Fonction random pour avoir un Client aléatoire
        Random clientAleatoire = new Random() ;

        List<Client> listeClient1 = new ArrayList<>() ;
        // Chacune des listes contiendra 20 clients générés de façon aléatoire au lancement de l’application,
        // utilisant les valeurs des banques de données fournies en annexe pour choisir chacun
        // des éléments composant un client, à savoir son nom avec listeNoms,
        // sa commande avec listeCommandes et sa tasse avec listeTasses.
        listeClient1.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));

        // pour avoir 20 clients, il faut itérer 20 fois la liste
        System.out.println("Je tente de rentrer dans la boucle de la ListeClient1" + listeClient1);
        for (int i = 0 ; i < 20; i ++) {
            listeClient1.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                    BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                    BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));
        }

        List<Client> listeClient2 = new ArrayList<>() ;
        listeClient2.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));

        System.out.println("Je tente de rentrer dans la boucle de la ListeClient2" + listeClient2);
        for (int i = 0 ; i < 20; i ++) {
            listeClient2.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                    BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                    BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));
        }

        List<Client> listeClient3 = new ArrayList<>() ;
        listeClient3.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));

        System.out.println("Je tente de rentrer dans la boucle de la ListeClient3" + listeClient3);
        for (int i = 0 ; i < 20; i ++) {
            listeClient3.add(new Client(BanqueDeDonne.listeNoms.get(clientAleatoire.nextInt(BanqueDeDonne.listeNoms.size())),
                    BanqueDeDonne.listeCommandes.get(clientAleatoire.nextInt(BanqueDeDonne.listeCommandes.size())),
                    BanqueDeDonne.listeTasses.get(clientAleatoire.nextInt(BanqueDeDonne.listeTasses.size()))));
        }

        // Ensuite créer une liste des clients expulsés, nommer listeClientsExpulse.
        List<Client> listeClientsExpulse = new ArrayList<>() ;



       // Tu dois maintenant lire les trois listes de client une à la suite de l'autre.
        // A chaque itération, il te faudra servir le client avec un resto choisi de façon aléatoire parmi les 3
        // et ajouter le client à la liste des clients servie par le restaurant.
        // CEPENDANT, si un client venait à être expulsé, ne l’ajoute pas à la liste du restaurant,
        // ajoute le plutôt à la liste ‘clientsExpulser’.
        methodeServirClient(mesDifferentsRestaurants, listeClient1, listeClientsExpulse) ;
        methodeServirClient(mesDifferentsRestaurants, listeClient2, listeClientsExpulse);
        methodeServirClient(mesDifferentsRestaurants, listeClient3, listeClientsExpulse);

        // Finalement, une fois tous tes clients servient, tu devras exposer dans un output:
        // - Le nom du restaurant, son profit total et le nombre de clients qu’il a servis
        // - Le nombre de clients expulsés et leur nom.
        restaurant1.resultatRestaurant();
        restaurant2.resultatRestaurant();
        restaurant3.resultatRestaurant();

        for (int i = 0; i < listeClientsExpulse.size() ; i++) {
            System.out.println("Mes mauvais client : " + listeClientsExpulse.size()); // Je souhaiterai avoir le nom du client expulsé
        }


    }
       public static void methodeServirClient (List<Restaurant> mesDifferentsRestaurants, List<Client> mesClients, List<Client> listeClientsExpulse) {

            Random restaurantAleatoire = new Random() ;

            for (int i = 0; i < mesClients.size(); i ++) {
                Client client = mesClients.get(i) ;
                Restaurant dansQuelRestaurant =  mesDifferentsRestaurants.get(restaurantAleatoire.nextInt(mesDifferentsRestaurants.size())) ;
                double money = dansQuelRestaurant.servir(client);

                    if (money > 0.0) {
                        dansQuelRestaurant.listeClientServi.add(client); ;
                    } else {
                        listeClientsExpulse.add(client);
                    }
            }
        }
}
