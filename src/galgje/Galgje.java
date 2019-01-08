package galgje;

public class Galgje {
	
	public static void main(String[] args) {
		Spel spel = new Spel();
		spel.invoerWoord();

		while ((spel.ronde())) {
			spel.nieuweInvoer();
		}	
	}
}