package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){

        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
        Film film1 = new Film(1,"Produsent1","Star Wars",1980,Sjanger.ACTION,"Warner Bros");
        Film film2 = new Film(2,"Produsent2","John Wick",2014,Sjanger.ACTION,"Warner Bros");
        Film film3 = new Film(3,"Produsent3","Titanic",1999,Sjanger.ROMANCE,"Universal Pictures");
        Film film4 = new Film(4,"Produsent4","Spider-Man",2000,Sjanger.ACTION,"Warner Bros");
        Film film5 = new Film(5,"Produsent5","Batman",2000,Sjanger.ACTION,"DC Studios");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);


        while (true){
            System.out.println("Velg en handling: ");
            System.out.println("-----------------");
            System.out.println("1. Legg til ny film");
            System.out.println("2. Skriv ut alle filmer");
            System.out.println("3. Skriv ut filmer etter tittel");
            System.out.println("4. Skriv ut filmer etter produsent");
            System.out.println("5. Skriv ut statistikk");
            System.out.println("6. Avslutt");

            int valg = tekstgr.getScanner().nextInt();

            switch (valg) {
                case 1:
                Film nyFilm = tekstgr.lesFilm();
                filmarkiv.leggTilFilm(nyFilm);
                    
                    break;
                
                case 2:
                tekstgr.skrivUtAlleFilmer(filmarkiv);
                
                    break;

                case 3:
                System.out.println("Skriv inn delstreng: ");
                String delstreng = tekstgr.getScanner().next();
                tekstgr.skrivUtFilmDelstrengTittel(filmarkiv, delstreng);
                
                    break;

                case 4:
                System.out.println("Skriv inn produsent: ");
                String produsent = tekstgr.getScanner().next();

                tekstgr.skrivUtFilmProdusent(filmarkiv,produsent);

                    break;

                case 5:
                tekstgr.skrivUtStatistikk(filmarkiv);

                    break;

                case 6:
                System.out.println("Avslutter programmmet.");
                tekstgr.getScanner().close();
                System.exit(0);
                    break;

                default:
                System.out.println("Ugyldig valg. Prøv igjen.");
                
            }

        }

    }

}
