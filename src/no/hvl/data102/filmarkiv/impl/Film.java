package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	
	private int filmnr;
	private String produsent;
	private String tittel;
	private int arForLansering;
	private Sjanger sjanger;
	private String filmSelskap;
	
	// Oppretter en konstruktør som danner en "tom" film-objekt
	public Film() {
		this.filmnr = 0;
		this.produsent = null;
		this.tittel = null;
		this.arForLansering = 0;
		this.sjanger = null;
		this.filmSelskap = null;
	}
	
	
	
	
	// Oppretter en konstruktør med gitt data.
	public Film(int filmnr, String produsent, String tittel, int arForLansering, Sjanger sjanger, String filmSelskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.arForLansering = arForLansering;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
	}
	
	//Oppretter Equals() og hashCode() metoder som overkjører tilsvarende metoder i klassen
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return arForLansering == other.arForLansering && Objects.equals(filmSelskap, other.filmSelskap)
				&& filmnr == other.filmnr && Objects.equals(produsent, other.produsent) && sjanger == other.sjanger
				&& Objects.equals(tittel, other.tittel);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(arForLansering, filmSelskap, filmnr, produsent, sjanger, tittel);
	}
	
	
	
	
	
	// Oppretter get og set metoder for alle objektvariablene.
	
	public int getFilmNum() {
		return filmnr;
	}
	
	public void setFilmNum(int num) {
		this.filmnr = num;
		
	}
	
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setProdusent(String prod) {
		this.produsent = prod;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLanseringsAr() {
		return arForLansering;
	}
	
	public void setLanseringsAr(int year) {
		this.arForLansering = year;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
		
	}
	
	public String getFilmSelskap() {
		return filmSelskap;
	}
	
	
	public void setFilmSelskap(String selskap) {
		this.filmSelskap = selskap;
	}
	
	

}
