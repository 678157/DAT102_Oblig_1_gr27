package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.FilmArkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {
	
	private FilmArkiv filmarkiv;
	private Film film1;
	private Film film2;
	
	
	@BeforeEach
	public void setUp() {
		filmarkiv = new FilmArkiv(5);
		film1 = new Film(1,"Produsent1","Tittel1",2000,Sjanger.ACTION,"Filmselskap1");
		film2 = new Film(2,"Produsent2","Tittel2",2002,Sjanger.ROMANCE,"Filmselskap2");
		
			
		
	}
	
	@Test
	//Tester med å legge til 1 film.
	public void legTilFilmTest() {
		filmarkiv.leggTilFilm(film1);
		assertEquals(1,filmarkiv.antall(),"Skal være en film i listen");
	}
	@Test
	//Tester med å legge til alle filmer
	public void legTilFilmTest2() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		assertEquals(3,filmarkiv.antall(),"Skal være 3 filmer i listen");
	}
	
	@Test
	public void finnFilmTest() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		
		Film funnetFilm = filmarkiv.finnFilm(1);
		assertNotNull(funnetFilm, "Film med id 1 skal bli funnet.");
		assertEquals("Tittel1",funnetFilm.getTittel(),"Funnet film sin tittel skal stemme med tittel.");
		
	}
	
	@Test
	public void slettFilmTest() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		
		assertTrue(filmarkiv.slettFilm(1), "Skal slette film med id 1");
		assertEquals(2,	filmarkiv.antall(),"skal returnere at  det er 2 filmer igjen i listen.");
		assertNull(filmarkiv.finnFilm(1),"Film med id 1 skal ikke lengre eksistere");
		
	}
	
	@Test
	public void soekTittelFilmTest() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		
		Film [] resultat = filmarkiv.soekTittel("Tittel1");
		assertEquals(1,resultat.length,"Skal finne 1 film med tittel 'Tittel1'");
		
		Film[] resultat2 = filmarkiv.soekTittel("Tittel2");
		assertEquals(1,resultat2.length,"Skal finne 1 film med tittel 'tittel2'");
	}
	
	@Test
	public void soekProdusentTest() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		Film[] resultat = filmarkiv.soekProdusent("Produsent1");
		assertEquals(1,resultat.length,"Skal finne 1 produsent med tilsvarende navn.");
		
		Film[] resultat2 = filmarkiv.soekProdusent("Produsent2");
		assertEquals(1,resultat2.length,"Skal finne 1 produsent med tilsvarende navn.");
		
	}
	
	@Test
	public void antallSjangrerTest() {
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		
		int antallActionFilmer = filmarkiv.antall(Sjanger.ACTION);
		assertEquals(1,antallActionFilmer,"Skal returnere 1 action film");
		
		int antallRomanceFilmer = filmarkiv.antall(Sjanger.COMEDY);
		assertEquals(0,antallRomanceFilmer,"Skal returnere 0 komedie filmer");
		
	}
	
	@Test
	public void antallTest() {
		assertEquals(0,filmarkiv.antall(),"Skal være 0 filmer i listen");
		
		filmarkiv.leggTilFilm(film1);
		assertEquals(1,filmarkiv.antall(),"Skal være 1 film i listen nå.");
		
		filmarkiv.leggTilFilm(film2);
		assertEquals(2,filmarkiv.antall(),"Skal være 2 filmer i listen nå.");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
