package Klase;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		//Kreiranje testnik primera
		
		//Kategorije
		Kategorija slatko = new Kategorija("Slatko", "U Å¾ivotu Vam nedostaje baÅ¡ ova kategorija!");
		Kategorija cokoladno = new Kategorija("ÄŒokoladno", "Za prave poznavaoce slatkih specijaliteta!");
		Kategorija dijetalno = new Kategorija("Dijetalno", "OÄ�uvajte VaÅ¡u liniju uz ovu kategoriju!");
		Kategorija kuvano = new Kategorija("Kuvano", "Valja nekad neÅ¡to i na kaÅ¡iku pojesti!");
		Kategorija vegetarijansko = new Kategorija("Vegetarijansko", "Ako Vam je ljubimac prase, ovo je VaÅ¡a kategorija!");
		Kategorija itaKuhinja = new Kategorija("Italijanska kuhinja", "Paste, pizze i sve belissimo!");
		
		//Mesto
		Mesto noviSad = new Mesto("Novi Sad", 21000);
		Mesto beograd = new Mesto("Beograd", 11000);
		Mesto nis = new Mesto("NiÅ¡", 18000);
		Mesto subotica = new Mesto("Subotica", 24000);
		Mesto derventa = new Mesto("Derventa", 74400);
		Mesto backiJarak = new Mesto("Beograd", 21234);
		Mesto apatin = new Mesto("Apatin", 25260);
		
	}
}
