package Exo1;

public class Cafetiere {

    Cafetiere () {}

    void remplirTasse (Tasse tasse) {
        tasse.cafe = new Cafe(TypeCafe.MOKA, tasse.quantiteCafeMax) ;
    }

   void remplirTasse (Tasse tasse , TypeCafe typeCafe, double quantiteCafeMax ) {
        tasse.cafe = new Cafe(typeCafe, quantiteCafeMax);
    }
}
