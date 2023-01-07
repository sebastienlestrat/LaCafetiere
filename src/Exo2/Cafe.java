package Exo2;

public class Cafe {

    TypeCafe typeCafe ;
    double quantiteLiquideMl ;

   public Cafe () {
        this.typeCafe = TypeCafe.MOKA ;
        this.quantiteLiquideMl = 100 ;
    }

   public  Cafe (TypeCafe typeCafe, double quantiteLiquideMl) {
       this.typeCafe = typeCafe ;
       this.quantiteLiquideMl = quantiteLiquideMl ;
    }
}
