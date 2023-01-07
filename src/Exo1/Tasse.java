package Exo1;

public class Tasse {
    double quantiteCafeMax ;
    Cafe cafe ;

    Tasse () {
        this.quantiteCafeMax = 100.0 ;
    }

    Tasse (double quantiteCafeMax) {
        this.quantiteCafeMax = quantiteCafeMax ;
    }

   double boire (double quantiteBu) {
        double quantiteLiquideRestant = this.cafe.quantiteLiquideMl ;
         cafe.quantiteLiquideMl = cafe.quantiteLiquideMl - quantiteBu ;
        return this.cafe.quantiteLiquideMl;
    }

    double boire () {
        cafe.quantiteLiquideMl = 0 ;
        return cafe.quantiteLiquideMl ;
    }
}
