package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.FilmArkiv;

public class filmarkivMain {
    public static void main(String[] args) {
        FilmarkivADT filma = new FilmArkiv(100);
        Meny meny = new Meny(filma);

        meny.start();
        
    }




}
