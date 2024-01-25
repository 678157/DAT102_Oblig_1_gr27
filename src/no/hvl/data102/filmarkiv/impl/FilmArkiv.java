package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class FilmArkiv implements FilmarkivADT {
	
	private Film[] filmTabell;
	private int antallFilmer;
	
	public FilmArkiv(int kapasitet) {
		filmTabell = new Film[kapasitet];
		antallFilmer = 0;
		
	}

// Metode for å utvide tabellen dersom det blir behov for det.
	
	private void utvid() {
		int nyMax = filmTabell.length * 2;
		filmTabell = Arrays.copyOf(filmTabell, nyMax);
	}

	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < antallFilmer;i++) {
			if (filmTabell[i].getFilmNum()== nr) {
				return filmTabell[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antallFilmer == filmTabell.length) {
			utvid();
			
		}

		filmTabell[antallFilmer] = nyFilm;
		antallFilmer++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < antallFilmer;i++) {
			if (filmTabell[i].getFilmNum() == filmnr) {
				System.arraycopy(filmTabell, i + 1, filmTabell, i, antallFilmer - i - 1);
				antallFilmer --;
				return true;
				
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film [] result = new Film[antallFilmer];
		int antallResult = 0;
		
		for (int i = 0; i < antallFilmer;i++) {
			if (filmTabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				result[antallResult] = filmTabell[i];
				antallResult++;
			}
		}
		return Arrays.copyOf(result, antallResult);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] result = new Film[antallFilmer];
		int antallResultater = 0;
		
		for (int i = 0; i < antallFilmer;i++) {
			if (filmTabell[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				result[antallResultater] = filmTabell[i];
				antallResultater++;
			}
			
		}
		return Arrays.copyOf(result,antallResultater);
	}

	@Override
	// Finner antall filmer med oppgitt sjanger, returnerer antall filmer med spesifikk sjanger
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		
		for (int i = 0; i < antallFilmer;i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger ++;
			}
		}
		return antallSjanger;
	}

	@Override
	// Returnerer antall filmer i arkivet. 
	public int antall() {
		return antallFilmer;
	}
	

}
