package galgje;
import java.util.Arrays;
import java.util.Scanner;

class Spel {
	String woord = "ditisbijvoorbeeldeentelangwoord";
	char[] letters = new char[16];
	int kansen=10;
	char[] antwoord = new char[16];
	String huidigAntwoord;
	char invoer;
	char[] teRadenLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	void invoerWoord() {
		System.out.println("Ok, degene die het woord straks moet raden moet nu even wegkijken!");
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Voer een woord van maximaal 16 letters in: ");
			woord=scanner.next();
		} while (woord.length()>16);
		woord=woord.toLowerCase();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Ok, er is een woord ingevoerd.\nWe gaan beginnen!");
		naarLetters();
	}

	void naarLetters() {
		for (int i=0;i<woord.length();i++) {
			letters[i]=woord.charAt(i);
			antwoord[i] = '-';
		}
		huidigAntwoord = new String(antwoord);
	}
	
	void nieuweInvoer() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nHet te raden woord is: ");
		for (char d : antwoord) {
			System.out.print(d+" ");
		}
		System.out.print("\nVoer een letter in: ");
		controle:
		for(;;) {
			invoer = scanner.next().charAt(0);
			invoer = Character.toLowerCase(invoer);
			int i=0;
			for (char c: teRadenLetters) {
				if (c==invoer) {
					teRadenLetters[i] = '-';
					vergelijk();
					break controle;
				}
				i++;
			}
			System.out.print("Dit is geen geldige invoer. Kies een letter uit het alfabet die je nog niet eerder in dit spel hebt gebruikt:");
		}
	}
	
	void vergelijk() {
		check:
		for(;;) {
			for (char c : letters) {
				if (c==invoer) {
					goedeInvoer();
					break check;
				} 
			}
			fouteInvoer();
			break check;
		}
	}
	
	void goedeInvoer() {
		System.out.println("\nYes, de letter "+invoer+" zit inderdaad in het woord.");
		int i =0;
		for (char c : letters) {
			if (c==invoer) {
				antwoord[i]=invoer;
				i++;
			} else {
			i++;
			}
		}
		huidigAntwoord = new String(antwoord);
		if(Arrays.equals(letters, antwoord)) {
			System.out.println("Het woord is nu compleet: "+woord+"\n\nGefeliciteerd, je hebt gewonnen!");
		}
	}
	
	boolean ronde() {
		if (Arrays.equals(letters, antwoord) || kansen==0) {
			return false;
		}
		return true;
	}
	
	void fouteInvoer() {
		System.out.println("\nHelaas komt de letter "+invoer+" niet in het woord voor.");
		kansen--;
		switch(kansen) {
		case 9:
			System.out.println("De grond voor je galgje is gelegd:\n\n__________");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 8:
			System.out.println("De eerste balk voor je galgje is neergezet:\n  |\n  |\n  |\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 7:
			System.out.println("De bovenste balk zit erop:\n____________\n  |\n  |\n  |\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 6:
			System.out.println("Het touw hangt klaar...\n____________\n  |       |\n  |\n  |\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 5:
			System.out.println("Je hooft hangt:\n____________\n  |       |\n  |       0\n  |\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 4:
			System.out.println("Je lijf hangt:\n____________\n  |       |\n  |       0\n  |       |\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 3:
			System.out.println("Je linker arm hangt erbij:\n____________\n  |       |\n  |       0\n  |      /|\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 2:
			System.out.println("Je rechter arm hangt erbij:\n____________\n  |       |\n  |       0\n  |      /|\\\n  |\n  |\n__|_______");
			System.out.println("Nog "+kansen+" foute antwoorden en je bent er geweest!");
			break;
		case 1:
			System.out.println("Je linker been hangt erbij:\n____________\n  |       |\n  |       0\n  |      /|\\\n  |      /\n  |\n__|_______");
			System.out.println("Nog "+kansen+" fout antwoord en je bent er geweest!");
			break;
		default:
			System.out.println("Je bent overleden:\n____________\n  |       |\n  |       0\n  |      /|\\\n  |      / \\\n  |\n__|_______");
			System.out.println("Het woord was: "+woord);
			System.out.println("Bedankt voor het spelen!");
			break;
		}
	}
}
