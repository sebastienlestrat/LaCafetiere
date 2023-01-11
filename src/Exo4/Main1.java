package Exo4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main1 {

    public static void main(String args[]) {

        JDialog.setDefaultLookAndFeelDecorated(true);
        // Étape 1
        //Créer un objet restaurent que tu utiliseras plus tard.
        //Dit bonjour au client et demande lui son nom avec une JOption showInputDialog.
        //Demande au client, avec son nom, si tu peux prendre sa commande avec un JOption showMessageDialog.
        Restaurant restaurant = new Restaurant();

        JFrame nouveauClient = new JFrame();
        Object clientName = JOptionPane.showInputDialog(nouveauClient, "Bonjour, quel est votre nom ?");
        System.out.println(clientName);

        JFrame bienvenue = new JFrame();
        JOptionPane.showMessageDialog(bienvenue, "Bienvenue " + clientName + ". Puis-je prendre votre commande ?");

        // Étape 2
        //Demande au client son type de café avec le JOption : ShowInputDialog.
        // Il te faudra, à partir de l’enum TypeCafe créer un tableau d’option
        // (spoiler il existe une méthode pour créer le tableau de valeur d’une enum).
        //Si le client demande un type de café bâtard,
        // envoie un message comme quoi il n’est pas le bienvenu et arrête le processus.

        TypeCafe[] quelCafe = TypeCafe.values();
        Object cafeChoisi = JOptionPane.showInputDialog(null, "Choix de Café : ",
                "Quel café désirez-vous ?", JOptionPane.QUESTION_MESSAGE, null,
                quelCafe,
                quelCafe[1]);
        System.out.println(cafeChoisi);

        if (cafeChoisi == TypeCafe.BATARD) {
            JFrame degage = new JFrame();
            JOptionPane.showMessageDialog(degage, "Vous n'êtes pas le bienvenue ! Sortez");
            System.exit(0);
        }

        // Étape 3
        //Demander si le client a sa propre tasse avec un ConfirmDialog. (Oui il a une tasse, non il n’en a pas)
        //Si oui demander la taille avec un inputDialog,
        //SINON passer directement à l'étape suivante ou la taille sera automatiquement calculée.


        int response = JOptionPane.showConfirmDialog(null, "Avez-vous une tasse ?", "Tasse",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else {
            System.out.println("Yes button clicked");
            JFrame tasse = new JFrame();
            Object tasseSize = JOptionPane.showInputDialog(tasse, "Quelle est la taille de votre tasse ?");
            System.out.println(tasseSize);
        }

        // Étape 4
        //Proposer une quantité de café avec un slider !
        //Proposer un choix allant, de 0 jusqu'à 500 ml découpé en tranches de 50.
        //N’hésite pas à jouer avec l’objet slider pour set ce maximum et les tranches !
        // Petit spoiler, MajorTickSpacing et setMaximum te seront probablement utiles.

        JFrame quantiteCafe = new JFrame();
        JOptionPane optionPane = new JOptionPane();
        JSlider slider = getSlider(optionPane);
        optionPane.setMessage(new Object[]{"Selectionner une quantité : ", slider});
        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(quantiteCafe, "Quantité");
        dialog.setVisible(true);
        System.out.println("Input: " + optionPane.getInputValue());


        // Étape 5
        //Utilise ton restaurant pour calculer le coût en créant un client avec sa commande.
        Client client = new Client();
        // Si le client a déjà sa tasse, créer le avec une tasse,
        // sinon utiliser simplement l’ancienne logique de laisser la tasse être créée lors
        // de la facturation dans le restaurant.
        if (client.tasse != null) {
            client.tasse = new Tasse();
        } else {
            System.out.println("Le client " + client.nom + " n'a pas de tasse");
            // CEPENDANT, si sa commande est de plus de 100 ml,
            // une tasse de 500 ml lui est offerte, et son coût monte à 3 euros.
            if (client.commandeCafe.quantiteLiquideMl > 100) {
                System.out.println("Le client " + client.nom + " a une grande commande");
                client.tasse = new Tasse(500);
                client.valeurFacture += 3;

            } else // Si un client arrive sans tasse, sa facture augmente de 2 euros et
            // une tasse avec une capacité max de 100 ml lui est offerte
            {
                System.out.println("Le client " + client.nom + " a une petite commande de 100ml");
                client.tasse = new Tasse(100);
                client.valeurFacture += 2;
            }
        }


        //Demande-lui ensuite de payer avec un InputDialog.
        // Il devra payer en centimes, donc 1.70 devient 170 et 24.43 devient 2443 etc.
        JFrame paid = new JFrame();
        String resultPaid = JOptionPane.showInputDialog(paid, "Vous devez payer : 170cts (1 café) ou 2443cts (une cafetière) ");

        //SI le client paye la somme exacte, envoie-lui un message de remerciements et finis le traitement
        if (Integer.parseInt(resultPaid) == 170 || Integer.parseInt(resultPaid) == 2443) {
            JFrame thanks = new JFrame();
            JOptionPane.showMessageDialog(thanks, "Merci, bonne journée ! Au revoir");
            System.exit(0);

        }  //SINON SI le client paye plus que la somme exacte, envoie-lui un message de remerciements
        // et finis le traitement en lui rendant sa monnaie avec une courte note à cet effet.
        else if (Integer.parseInt(resultPaid) >= 170 || Integer.parseInt(resultPaid) >= 2443) {
            JFrame thanks = new JFrame();
            JOptionPane.showMessageDialog(thanks, "Merci, bonne journée !");
            JFrame monnaie = new JFrame();
            JOptionPane.showMessageDialog(monnaie, "Voici votre monnaie, au revoir !");
            System.exit(0);
        }

        //SINON SI le client n’a pas payé toute la somme,
        // soustrait l’argent donné à la facture totale et demande que le reste de la somme soit payé.
        else if (Integer.parseInt(resultPaid) != 170 || Integer.parseInt(resultPaid) != 2443) {
            client.valeurFacture -= Integer.parseInt(resultPaid);
            JFrame restant = new JFrame();
            JOptionPane.showMessageDialog(restant, "Il manque : " + client.valeurFacture + " cts ");


            //TANT QUE le client n’a pas payé l’ensemble de la somme,
            // envoie un message demandant le reste du paiement. Après 3 messages envoie le message :
            // au voleur, au voleur ! Mais que fait la police ? et sort de la boucle et finis le programme.
            //  BOUCLE INFINI SEB !!!!!
            int compteurWhile = 1;
            while ((Integer.parseInt(resultPaid) != 170 || Integer.parseInt(resultPaid) != 2443) && compteurWhile <= 3) {
                // Aussi possible de metrre une condition if dans ma while loop
                //if (compteurWhile >= 4) {
                  //  break;
               // }
                JOptionPane.showMessageDialog(restant, compteurWhile + "Il manque : " + client.valeurFacture + " cts ");
                compteurWhile++;
            }
            JFrame voleur = new JFrame();
            JOptionPane.showMessageDialog(voleur, "Au voleur, au voleur ! Mais que fait la police ? ");
            System.exit(0);
        }
    }

    static JSlider getSlider(final JOptionPane optionPane) {
        JSlider slider = new JSlider();
        slider.setMajorTickSpacing(50);
        slider.setMaximum(500);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider theSlider = (JSlider) changeEvent.getSource();
                if (!theSlider.getValueIsAdjusting()) {
                    optionPane.setInputValue(new Integer(theSlider.getValue()));
                }
            }
        };
        slider.addChangeListener(changeListener);
        return slider;
    }


}

