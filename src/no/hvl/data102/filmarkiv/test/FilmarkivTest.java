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
	private Film film3;
	
	@BeforeEach
	public void setUp() {
		filmarkiv = new FilmArkiv(5);
		film1 = new Film(1,"Produsent1","Tittel1",2000,Sjanger.ACTION,"Filmselskap1");
		film2 = new Film(2,"Produsent2","Tittel2",2002,Sjanger.ROMANCE,"Filmselskap2");
		film3 = new Film();
			
		
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
		filmarkiv.leggTilFilm(film3);
		assertEquals(3,filmarkiv.antall(),"Skal være 3 filmer i listen");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
