package GUI;

import java.util.ArrayList;

import Klase.Alat;
import Klase.Kategorija;
import Klase.Kolicina;
import Klase.Komentar;
import Klase.KorisnickiNalog;
import Klase.MernaJedinica;
import Klase.Ocena;
import Klase.PlatformaZaKuvare;
import Klase.Recenzija;
import Klase.Recept;
import Klase.Sastojak;
import Klase.Tezina;

public class Main {
	public static void main(String[] args) {
		GlavniProzor gp = new GlavniProzor();
		Recept r = new Recept();
		Ocena o = new Ocena();
		o.setSvidjanje(true);
		o.setZvezdice(2);
		Komentar k = new Komentar();
		o.dodajKomentar(k);
		r.dodajOcenu(o);
		r.setTezina(Tezina.SREDNJE);
		ArrayList<Alat> alll = new ArrayList<Alat>();
		alll.add(Alat.MIKROTALASNA);
		alll.add(Alat.BLENDER);
		
		r.setNazivRec("nanna");
		KorisnickiNalog kk = new KorisnickiNalog();
		kk.setKorIme("olaaa");
		r.setAutor(kk);
		Kategorija l = new Kategorija("PPPP", "aa");
		r.dodajKategoriju(l);
		r.setDuzinaMin(19);
		r.setOprema(alll);
		
		Sastojak s = new Sastojak("Yayayyayay");
		s.dodajZamjenski(s);

		Sastojak s12 = new Sastojak("pappapappap");
		s.dodajZamjenski(s);
		Kolicina sss = new Kolicina(MernaJedinica.KG, 12, true, s, r);
		Kolicina sss1 = new Kolicina(MernaJedinica.KG, 12, true, s, r);
		Kolicina sss2 = new Kolicina(MernaJedinica.KG, 12, true, s, r);
		Kolicina sss3 = new Kolicina(MernaJedinica.KG, 12, true, s, r);
		Kolicina ss = new Kolicina(MernaJedinica.KASICICA, 1, false, s12, r);
		r.dodajKolicinuSastojka(sss);
		r.dodajKolicinuSastojka(sss1);
		r.dodajKolicinuSastojka(sss2);
		r.dodajKolicinuSastojka(sss3);
		r.dodajKolicinuSastojka(ss);
		
		Recenzija rrrr = new Recenzija();
		rrrr.setOcena(3);
		r.setRecenzija(rrrr);
		
		//ProzorRecepta momo = new ProzorRecepta(r);

		KorisnickiNalog kn = new KorisnickiNalog();
		PlatformaZaKuvare.getInstance().setUlogovaniKorisnik(kn);
		kn.setKorIme("Teest");
		//Kategorija kat = new Kategorija("KATEE", "bla");
		//ArrayList<Kategorija> k = new ArrayList<Kategorija>();
		//k.add(kat);
		//Tezina t = Tezina.LAKO;
		//Recept r = new Recept("Test", null, "", Klase.Tezina.LAKO , 40, "", "",0, kn,null, null, null, k);
		ArrayList<Recept> lista = new ArrayList<Recept>();
		lista.add(r);
		//new RezultatPretrage(lista);
		
		kn.dodajAutorskiRecept(r);
		//new AutorskiRecepti(kn);
		kn.dodajObelezeniRecept(r);
		//new PrikazObelezenihRecepata(kn);
		
		new DodavanjeRecepta();
	}
}
