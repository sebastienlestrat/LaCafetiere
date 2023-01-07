package Exo2;

public class Cafetiere {

   public Cafetiere () {}

    void remplirTasse (Tasse tasse) {

        tasse.cafe = new Cafe(TypeCafe.MOKA, tasse.quantiteCafeMax) ;
    }


   void remplirTasse (Tasse tasse , TypeCafe typeCafe, double quantiteCafeMax ) {


      // Si on tente d'ajouter un café d’un certain type à un contenant
      // ayant déjà un type différent de café, le type de café deviendra bâtard.

       if (tasse.cafe !=null) {
           Cafe existant = tasse.cafe ;
           existant.quantiteLiquideMl += quantiteCafeMax ;
            if (typeCafe != tasse.cafe.typeCafe)
           tasse.cafe.typeCafe = TypeCafe.BATARD;
           System.out.println("On ne mélange pas deux café différents !... Sortez ! ");
       } else {
           tasse.cafe = new Cafe(typeCafe, quantiteCafeMax);
       }

       // Si un contenant déborde, envoyer un message à cet effet et mettre la quantité
       // de café à sa quantité maximum. Le client est tout de même facturé la valeur qu’il a demandée.
       if (tasse.cafe.quantiteLiquideMl > tasse.quantiteCafeMax)
       {
           System.out.println("Eh le hipster ! ça déborde !!");
           tasse.cafe.quantiteLiquideMl = tasse.quantiteCafeMax;
       }

    }
}
