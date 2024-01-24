package no.hvl.data102.filmarkiv.impl;
import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	    private int antall;
	    private LinearNode<Film> start;


	    public Filmarkiv2() {
	        antall = 0;
	        start = null;
	    }

	    @Override
	    public Film finnFilm(int nr) {
	        LinearNode<Film> valgt = start;
	        while (valgt != null) {
	            if (valgt.getData().getFilmNum() == nr) {
	                return valgt.getData();
	            }
	            valgt = valgt.getNeste();
	        }
	        return null;
	    }

	    @Override
	    public void leggTilFilm(Film nyFilm) {
	        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
	        nyNode.setNeste(start);
	        start = nyNode;
	        antall++;
	    }

	    @Override
	    public boolean slettFilm(int filmnr) {
	        
	    	LinearNode<Film> valgt = start;
	    	LinearNode<Film> forrige = null;
	    	
	    	
	    	if (finnFilm(filmnr) == null) {
	            return false;
	        }

	        
	        while (valgt != null) {
	        	if (valgt.getData().getFilmNum() == filmnr) {
	        		if (forrige == null) {
	        			start = valgt.getNeste();
	        		}
	        		else {
	        			forrige.setNeste(valgt.getNeste());
	        		}
	        	}
	        	antall--;
	        	return true;
	        }
	        return false;
	    }

	    @Override
	    public Film[] soekTittel(String delstreng) {
	        // TODO: Implementer søk etter filmer med gitt delstreng i tittelen
	    	
	        Film[] resultater = new Film[antall];
	        LinearNode<Film> valgt = start;

	        int i = 0;

	        while (valgt != null && i < resultater.length) {
	            if (valgt.getData().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
	                resultater[i] = valgt.getData();
	                i++;
	            }
	            valgt = valgt.getNeste();
	        }

	        return Arrays.copyOf(resultater, i);
	    }

	    @Override
	    public Film[] soekProdusent(String delstreng) {
	        // TODO: Implementer søk etter filmer med gitt delstreng i produsent
	        Film[] resultater = new Film[antall];
	        LinearNode<Film> valgt = start;

	        int i = 0;

	        while (valgt != null && i < resultater.length) {
	            if (valgt.getData().getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
	                resultater[i] = valgt.getData();
	                i++;
	            }
	            valgt = valgt.getNeste();
	        }

	        return Arrays.copyOf(resultater, i);
	    }

	    @Override
	    public int antall(Sjanger sjanger) {
	        // TODO: Implementer telling av filmer med gitt sjanger
	      int antallsjanger = 0;
	      LinearNode<Film> valgt = start;
	      while(valgt.getData() != null) {
	    	  if (sjanger == valgt.getData().getSjanger()) {
	    		  antallsjanger++;
	    	  }
	    	  valgt = valgt.getNeste();
	      }
	      return antallsjanger;
	    }

	    @Override
	    public int antall() {
	        return antall;
	    }
	}


