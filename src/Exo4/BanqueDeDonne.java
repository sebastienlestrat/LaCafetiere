package Exo4;

import java.util.ArrayList;
import java.util.Arrays;


public class BanqueDeDonne {

	
	public static ArrayList<String> listeNoms = new ArrayList<String> (Arrays.asList(
			"Gr�goire","Denise", "Alexandre", "Patrick-Robert",
			"Sylvie", "�lisabeth", "Fr�d�ric" , "Bernard" , "David" ,
			"David" , "Madeleine" , "�mile" , "Nathalie" , "J�r�me ",
			"Victor" , "Robert" , "Thibaut" , "Pauline" , "Arthur"  ,
			"Jos�phine" , "Laurence" , "Augustin" , "Zacharie" , "Aurore")) ;
	
	public static ArrayList<Tasse> listeTasses = new ArrayList<Tasse> (Arrays.asList(
			new Tasse(), new Tasse(), new Tasse(), new Tasse(),
			new Tasse(200), new Tasse(250), new Tasse(300), new Tasse(350),
			new Tasse(500), new Tasse(1000), new Tasse(2000), new Tasse(4000)
			)) ; 
	
	public static ArrayList<Cafe> listeCommandes = new ArrayList<Cafe> (Arrays.asList(
			new Cafe(), new Cafe(), new Cafe(), new Cafe(),
			new Cafe(TypeCafe.BOURBON, 100), new Cafe(TypeCafe.BOURBON, 200), new Cafe(TypeCafe.BOURBON, 400), new Cafe(TypeCafe.BOURBON, 600),
			new Cafe(TypeCafe.JAVA, 1000), new Cafe(TypeCafe.JAVA, 2000), new Cafe(TypeCafe.JAVA, 4100), new Cafe(TypeCafe.JAVA, 1),
			new Cafe(TypeCafe.BATARD, 100), new Cafe(TypeCafe.BATARD, 100000), new Cafe(TypeCafe.TYPICA, 100), new Cafe(TypeCafe.MOKA, 100)
			)) ;

}