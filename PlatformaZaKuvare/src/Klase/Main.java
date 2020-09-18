package Klase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import GUI.GlavniProzor;
import Menadzeri.MenadzerKNaloga;
import Menadzeri.MenadzerKategorija;
import Menadzeri.MenadzerOsoba;
import Menadzeri.MenadzerRecepta;
import Menadzeri.MenadzerSastojaka;

public class Main {
	public static void main(String[] args) {
		kreiranjeTestova();
		new GlavniProzor();
	}

	public static void kreiranjeTestova() {
		//Kreiranje testnik primera
			
		//Kategorije
		Kategorija slatko = new Kategorija("Slatko", "U životu Vam nedostaje baš ova kategorija!");
		Kategorija cokoladno = new Kategorija("Čokoladno", "Za prave poznavaoce slatkih specijaliteta!");
		Kategorija dijetalno = new Kategorija("Dijetalno", "Očuvajte Vašu liniju uz ovu kategoriju!");
		Kategorija kuvano = new Kategorija("Kuvano", "Valja nekad nešto i na kašiku pojesti!");
		Kategorija vegetarijansko = new Kategorija("Vegetarijansko", "Ako Vam je ljubimac prase, ovo je Vaša kategorija!");
		Kategorija itaKuhinja = new Kategorija("Italijanska kuhinja", "Paste, pizze i sve belissimo!");
		Kategorija slano = new Kategorija("Slano", "Nemojte preterivati, da Vam ne odu bubrezi");
		
		MenadzerKategorija.getInstance().dodajKategoriju(slatko);
		MenadzerKategorija.getInstance().dodajKategoriju(cokoladno);
		MenadzerKategorija.getInstance().dodajKategoriju(dijetalno);
		MenadzerKategorija.getInstance().dodajKategoriju(kuvano);
		MenadzerKategorija.getInstance().dodajKategoriju(vegetarijansko);
		MenadzerKategorija.getInstance().dodajKategoriju(itaKuhinja);
		
		//Mesto
		Mesto noviSad = new Mesto("Novi Sad", 21000);
		Mesto beograd = new Mesto("Beograd", 11000);
		Mesto nis = new Mesto("Niš", 18000);
		Mesto subotica = new Mesto("Subotica", 24000);
		Mesto derventa = new Mesto("Derventa", 74400);
		Mesto backiJarak = new Mesto("Beograd", 21234);
		Mesto apatin = new Mesto("Apatin", 25260);
		
		ArrayList<Mesto>mesta = new ArrayList<Mesto>();
		mesta.add(derventa);
		mesta.add(beograd);
		mesta.add(apatin);
		mesta.add(backiJarak);
		mesta.add(subotica);
		mesta.add(nis);
		mesta.add(noviSad);

		PlatformaZaKuvare.getInstance().dodajMesto(noviSad);
		PlatformaZaKuvare.getInstance().dodajMesto(beograd);
		PlatformaZaKuvare.getInstance().dodajMesto(nis);
		PlatformaZaKuvare.getInstance().dodajMesto(subotica);
		PlatformaZaKuvare.getInstance().dodajMesto(derventa);
		PlatformaZaKuvare.getInstance().dodajMesto(backiJarak);
		PlatformaZaKuvare.getInstance().dodajMesto(apatin);
		
		//Sastojci
		Sastojak mleko = new Sastojak("Mleko");
		Sastojak brasno = new Sastojak("Brašno");
		Sastojak secer = new Sastojak("Šećer");
		Sastojak jaja = new Sastojak("Jaja");
		Sastojak cokolada = new Sastojak("Čokolada");
		Sastojak so = new Sastojak("So");
		Sastojak sunka = new Sastojak("Šunka");
		Sastojak sir = new Sastojak("Sir");
		Sastojak kecap = new Sastojak("Kečap");
		Sastojak keks = new Sastojak("Keks");
		Sastojak slag = new Sastojak("Šlag");
		Sastojak ulje = new Sastojak("Ulje");
		Sastojak kakao = new Sastojak("Kakao"); //
		Sastojak hleb = new Sastojak("Hleb"); //
		MenadzerSastojaka.getInstance().dodajSastojak(hleb);
		MenadzerSastojaka.getInstance().dodajSastojak(mleko);
		MenadzerSastojaka.getInstance().dodajSastojak(brasno);
		MenadzerSastojaka.getInstance().dodajSastojak(secer);
		MenadzerSastojaka.getInstance().dodajSastojak(jaja);
		MenadzerSastojaka.getInstance().dodajSastojak(cokolada);
		MenadzerSastojaka.getInstance().dodajSastojak(so);
		MenadzerSastojaka.getInstance().dodajSastojak(sunka);
		MenadzerSastojaka.getInstance().dodajSastojak(sir);
		MenadzerSastojaka.getInstance().dodajSastojak(kecap);
		MenadzerSastojaka.getInstance().dodajSastojak(keks);
		MenadzerSastojaka.getInstance().dodajSastojak(ulje);
		MenadzerSastojaka.getInstance().dodajSastojak(kakao);			
		//Osobe
		Osoba o1 = new Osoba("Ana", "Jovanović", LocalDate.of(1999, 1, 5), "064887676", Pol.ZENSKI, noviSad, new ArrayList<KorisnickiNalog>());
		Osoba o2 = new Osoba("Nikola", "Jakšić", LocalDate.of(2003, 3, 6), "060223998", Pol.MUSKI, beograd, new ArrayList<KorisnickiNalog>());
		Osoba o3 = new Osoba("Marija", "Šerifović", LocalDate.of(1979, 8, 6), "065779221", Pol.ZENSKI, apatin, new ArrayList<KorisnickiNalog>());
		Osoba o4 = new Osoba("Darko", "Milošević", LocalDate.of(1966, 2, 5), "063445668", Pol.MUSKI, nis, new ArrayList<KorisnickiNalog>());

		MenadzerOsoba.getInstance().dodajOsobu(o1);
		MenadzerOsoba.getInstance().dodajOsobu(o2);
		MenadzerOsoba.getInstance().dodajOsobu(o3);
		MenadzerOsoba.getInstance().dodajOsobu(o4);
		
		//Korisnicki nalozi		
		ArrayList<Alat> alati1 = new ArrayList<Alat>();
		alati1.add(Alat.BLENDER);
		alati1.add(Alat.MIKROTALASNA);
		alati1.add(Alat.MIKSER);
		
		ArrayList<Alat> alati2 = new ArrayList<Alat>();
		alati2.add(Alat.SOKOVNIK);
		alati2.add(Alat.MIKSER);
		alati2.add(Alat.MIKROTALASNA);
		alati2.add(Alat.BLENDER);
				
		ArrayList<Sastojak> sastojci1 = new ArrayList<Sastojak>();
		sastojci1.add(mleko);
		sastojci1.add(jaja);
		sastojci1.add(brasno);
		sastojci1.add(so);
		sastojci1.add(sunka);
		sastojci1.add(sir);
		
		ArrayList<Sastojak> sastojci2 = new ArrayList<Sastojak>();
		sastojci2.add(jaja);
		sastojci2.add(cokolada);
		sastojci2.add(secer);
		sastojci2.add(brasno);
		sastojci2.add(ulje);
		sastojci2.add(kakao);
		
		KorisnickiNalog kn1 = new KorisnickiNalog("anaa4", "123", TipKorisnika.KREATOR, 0, 0, alati1, o1, new ArrayList<KorisnickiNalog>(), new ArrayList<Kategorija>(), new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Ocena>(), sastojci1);
		KorisnickiNalog kn2 = new KorisnickiNalog("dzoni03", "123", TipKorisnika.KREATOR, 0, 0, alati1, o2, new ArrayList<KorisnickiNalog>(), new ArrayList<Kategorija>(), new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Ocena>(), sastojci2);
		KorisnickiNalog kn3 = new KorisnickiNalog("serifovic", "123", TipKorisnika.MODERATOR, 0, 0, null, o3, new ArrayList<KorisnickiNalog>(), new ArrayList<Kategorija>(), new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Ocena>(), new ArrayList<Sastojak>());
		KorisnickiNalog kn4 = new KorisnickiNalog("darko123", "123", TipKorisnika.KREATOR, 0, 0, alati2, o4, new ArrayList<KorisnickiNalog>(), new ArrayList<Kategorija>(), new ArrayList<Recept>(), new ArrayList<Recept>(), new ArrayList<Ocena>(), sastojci1);

		MenadzerKNaloga.getInstance().dodajNalog(kn1);
		MenadzerKNaloga.getInstance().dodajNalog(kn2);
		MenadzerKNaloga.getInstance().dodajNalog(kn3);
		MenadzerKNaloga.getInstance().dodajNalog(kn4);
		o1.dodajKorNalog(kn1);
		o2.dodajKorNalog(kn2);
		o3.dodajKorNalog(kn3);
		o4.dodajKorNalog(kn4);
		
		//Recepti
		//Recept 1
		ArrayList<Alat> alati = new ArrayList<Alat>();
		alati.add(Alat.MIKSER);
		alati.add(Alat.KALUP);
		
		Kolicina k1 = new Kolicina(MernaJedinica.G, 300, true, keks, null);
		Kolicina k2 = new Kolicina(MernaJedinica.KASIKA, 3, true, secer, null);
		Kolicina k3 = new Kolicina(MernaJedinica.ML, 250, true, mleko, null);
		Kolicina k4 = new Kolicina(MernaJedinica.G, 200, true, cokolada, null);
		Kolicina k5 = new Kolicina(MernaJedinica.ML, 250, true, slag, null);
		ArrayList<Kolicina> kolicine = new ArrayList<Kolicina>();
		kolicine.add(k1);
		kolicine.add(k2);
		kolicine.add(k3);
		kolicine.add(k4);
		kolicine.add(k5);
		
		ArrayList<Kategorija> kategorije = new ArrayList<Kategorija>();
		kategorije.add(slatko);
		kategorije.add(cokoladno);
		
		Recept r1 = new Recept("Slatki greh", alati, 
				"Keks pomešati sa šećerom i mlekom. Utisnuti je u kalup. Čokoladu otopiti na tihoj vatri, pa preliti preko podloge. Šlag spremiti po uputstvu, bogato premazati i odložiti u frižider na hlađenje.", 
				Tezina.LAKO, 20, "", "", 0, kn1, null, new ArrayList<Ocena>(), kolicine, kategorije);	
		MenadzerRecepta.getInstance().dodajReceptNaCekanju(r1);
		
		k1.setRecept(r1);
		k2.setRecept(r1);
		k3.setRecept(r1);
		k4.setRecept(r1);
		k5.setRecept(r1);
		
		//Recept 2
		alati = new ArrayList<Alat>();
		
		k1 = new Kolicina(MernaJedinica.G, 500, true, brasno, null);
		k2 = new Kolicina(MernaJedinica.PRSTOHVAT, 1, true, so, null);
		k3 = new Kolicina(MernaJedinica.KASICICA, 3, true, ulje, null);
		k4 = new Kolicina(MernaJedinica.G, 200, true, sir, null);
		kolicine = new ArrayList<Kolicina>();
		kolicine.add(k1);
		kolicine.add(k2);
		kolicine.add(k3);
		kolicine.add(k4);
		
	
		
		kategorije = new ArrayList<Kategorija>();
		kategorije.add(vegetarijansko);
		kategorije.add(itaKuhinja);
		
		Recept r2 = new Recept("Vegetarijanska pizza", alati, 
				"Brašno umesiti sa solju i 2 kašičice ulja. Testo mesimo dok ne dobijemo konzistentnu kuglu, koju potom premažemo sa kašičicom ulja. Onda se razvuče prstima po tepsiji i po njemu se posipaju ostali sastojci. Staviti u rernu na 180 stepeni 25 min.", 
				Tezina.SREDNJE, 40, "", "", 0, kn1, null, new ArrayList<Ocena>(), kolicine, kategorije);			
		MenadzerRecepta.getInstance().dodajReceptNaCekanju(r2);

		k1.setRecept(r2);
		k2.setRecept(r2);
		k3.setRecept(r2);
		k4.setRecept(r2);
		
		//Recept 3
		alati = new ArrayList<Alat>();
		
		k1 = new Kolicina(MernaJedinica.G, 500, true, brasno, null);
		k2 = new Kolicina(MernaJedinica.PRSTOHVAT, 1, true, so, null);
		k3 = new Kolicina(MernaJedinica.KASICICA, 3, true, ulje, null);
		k4 = new Kolicina(MernaJedinica.G, 200, true, sir, null);
		kolicine = new ArrayList<Kolicina>();
		kolicine.add(k1);
		kolicine.add(k2);
		kolicine.add(k3);
		kolicine.add(k4);
		
		kategorije = new ArrayList<Kategorija>();
		kategorije.add(vegetarijansko);
		kategorije.add(itaKuhinja);
		
		//recept 3
		ArrayList<Alat> alati3 = new ArrayList<Alat>();
		
		Sastojak tikvice = new Sastojak("Tikvice");
		Sastojak beloMeso = new Sastojak("Belo meso");
		Sastojak luk = new Sastojak("Crni luk");
		Sastojak pavlaka = new Sastojak("Pavlaka");
		
		
		Kolicina k31 = new Kolicina(MernaJedinica.KOMAD, 2, true, tikvice, null);
		Kolicina k32 = new Kolicina(MernaJedinica.G, 800, true, beloMeso, null);
		Kolicina k33 = new Kolicina(MernaJedinica.KOMAD, 1, true, luk, null);
		Kolicina k34 = new Kolicina(MernaJedinica.KOMAD, 3, true, jaja, null);
		Kolicina k35 = new Kolicina(MernaJedinica.ML, 250, true, pavlaka, null);
		
		ArrayList<Kolicina> kolicine3 = new ArrayList<Kolicina>();
		kolicine3.add(k31);
		kolicine3.add(k32);
		kolicine3.add(k33);
		kolicine3.add(k34);
		kolicine3.add(k35);
		
		
		ArrayList<Kategorija> kategorije3 = new ArrayList<Kategorija>();
		kategorije3.add(kuvano);
		kategorije3.add(dijetalno);
		
		Recept r3 = new Recept("Letnja corba", alati3, 
				"Iseckati crni luk. Staviti na vatru da se dinsta. Za to vreme očistiti tikvicu, preseći je pa skinuti i seme i iseckati je na kockice."
				+ "Meso ako ste stavili u komadu nakon 20 minuta izvaditi i sitno iseckati. Kada su se meso i povrće skuvali i sipali ste vode koliko je potrebno dodajte ostale začine.", 
				Tezina.SREDNJE, 45, "", "", 2, kn4, null, new ArrayList<Ocena>(), kolicine3, kategorije3);
		
		MenadzerRecepta.getInstance().dodajReceptNaCekanju(r3);
		
		k31.setRecept(r3);
		k32.setRecept(r3);
		k33.setRecept(r3);
		k34.setRecept(r3);
		k35.setRecept(r3);
		
		//RECEPT 4
		alati = new ArrayList<Alat>();
		alati.add(Alat.MIKSER);
		
		k1 = new Kolicina(MernaJedinica.G, 500, true, brasno, null);
		k2 = new Kolicina(MernaJedinica.G, 50, true, secer, null);
		k3 = new Kolicina(MernaJedinica.KASIKA, 3, true, kakao, null);
		k4 = new Kolicina(MernaJedinica.ML, 300, true, mleko, null);
		kolicine = new ArrayList<Kolicina>();
		kolicine.add(k1);
		kolicine.add(k2);
		kolicine.add(k3);
		kolicine.add(k4);
		
		kategorije = new ArrayList<Kategorija>();
		kategorije.add(slatko);
		kategorije.add(cokoladno);

		Recenzija rec1 = new Recenzija(4, kn3, null);
		Recept r4 = new Recept("Crnac", alati, "Pomesati navedene sastojke i isprziti na 200 stepeni 20 minuta. Sluziti uz slag i limunadu",
				Tezina.SREDNJE, 30, "","", 0, kn2, rec1, new ArrayList<Ocena>(), kolicine, kategorije);
		
		k1.setRecept(r4);
		k2.setRecept(r4);
		k3.setRecept(r4);
		k4.setRecept(r4);
		
		slatko.dodajRecept(r4);
		cokoladno.dodajRecept(r4);

		kn2.dodajAutorskiRecept(r4);
		rec1.setRecept(r4);
		MenadzerRecepta.getInstance().dodajRecept(r4);
		
		//RECEPT 5
		alati = new ArrayList<Alat>();
		alati.add(Alat.TOSTER);
		k1 = new Kolicina(MernaJedinica.KOMAD, 6, true, hleb, null);
		k2 = new Kolicina(MernaJedinica.KOMAD, 12, true, sunka, null);
		k3 = new Kolicina(MernaJedinica.G, 60, true, sir, null);
		k4 = new Kolicina(MernaJedinica.ML, 5, true, kecap, null);
		kolicine = new ArrayList<Kolicina>();
		kolicine.add(k1);
		kolicine.add(k2);
		kolicine.add(k3);
		kolicine.add(k4);
		
		kategorije = new ArrayList<Kategorija>();
		kategorije.add(slano);

		Recenzija rec2 = new Recenzija(5, kn3, null);
		Recept r5 = new Recept("Tost sendvici", alati, "Hleb, sunka, sir, hleb",
				Tezina.LAKO, 2, "","", 0, kn2, rec2, new ArrayList<Ocena>(), kolicine, kategorije);
		
		rec2.setRecept(r5);
		MenadzerRecepta.getInstance().dodajRecept(r5);
		kn2.dodajAutorskiRecept(r5);
		
		k1.setRecept(r5);
		k2.setRecept(r5);
		k3.setRecept(r5);
		k4.setRecept(r5);
		
		slano.dodajRecept(r4);
		
		//KOMENTARIIIIII
		//Ocene
		Ocena oci1 = new Ocena(true, 2, new ArrayList<Komentar>(), kn2, r1);
		r1.dodajOcenu(oci1); kn2.dodajOcenjeniRecept(oci1);
		Komentar kom3 = new Komentar("Skoro dobro kao kafa sa medom");
		oci1.dodajKomentar(kom3);
		
		Ocena oci2 = new Ocena(true, 4, new ArrayList<Komentar>(), kn2, r2);
		r2.dodajOcenu(oci2); kn2.dodajOcenjeniRecept(oci2);		
		Komentar kom4 = new Komentar("Skroz odlican recept");
		oci2.dodajKomentar(kom4);
		
		Ocena oci3 = new Ocena(true, 5, new ArrayList<Komentar>(), kn4, r4);
		r4.dodajOcenu(oci3); kn4.dodajOcenjeniRecept(oci3);
		Komentar kom1 = new Komentar("Ovo je dobro za moje misice :D");
		oci3.dodajKomentar(kom1);
		Komentar kom2 = new Komentar("Sveee pohvalee :D");
		oci3.dodajKomentar(kom2);
		
		Ocena oci4 = new Ocena(true, 3, new ArrayList<Komentar>(), kn1, r5);
		r5.dodajOcenu(oci4); kn1.dodajOcenjeniRecept(oci4);
		
		Ocena oci5 = new Ocena(true, 2, new ArrayList<Komentar>(), kn2, r1);
		r1.dodajOcenu(oci5); kn2.dodajOcenjeniRecept(oci5);
		
		//Korisnici dodaci obelezenih recepata
		kn2.dodajObelezeniRecept(r1);
		kn1.dodajObelezeniRecept(r5);
		kn4.dodajObelezeniRecept(r2);
		kn4.dodajObelezeniRecept(r4);
		
		//korisnik prati drugog kreatora
		kn1.dodajPracenogKorisnika(kn2);
		kn1.dodajPracenogKorisnika(kn4);
		kn2.dodajPracenogKorisnika(kn1);
		kn4.dodajPracenogKorisnika(kn1);
		
		//korisnik prati kategoriju
		kn1.dodajPracenuKategoriju(slatko);
		kn1.dodajPracenuKategoriju(dijetalno);
		kn1.dodajPracenuKategoriju(vegetarijansko);
		kn2.dodajPracenuKategoriju(cokoladno);
		kn2.dodajPracenuKategoriju(kuvano);
		kn4.dodajPracenuKategoriju(itaKuhinja);
		kn4.dodajPracenuKategoriju(slatko);
		
	/*	ArrayList<KorisnickiNalog> lista1 = new ArrayList<KorisnickiNalog>();
		lista1.add(kn1);
		lista1.add(kn2);
		lista1.add(kn4);
		TopListaKreatora tlk = new TopListaKreatora(lista1);
		Menadzeri.MenadzerTLK.getInstance().dodajTopListuKreatora(tlk);
		
		ArrayList<Recept> lista2 = new ArrayList<Recept>();
		lista2.add(r1);
		lista2.add(r2);
		lista2.add(r3);
		TopListaRecepata tlr = new TopListaRecepata(lista2);
		Menadzeri.MenadzerTLR.getInstance().dodajTopListuRecepata(tlr);*/
		
		//PlatformaZaKuvare.getInstance().generisanjeTLK(2);
		//PlatformaZaKuvare.getInstance().generisanjeTLR(2);
		
		
		
	}
}
