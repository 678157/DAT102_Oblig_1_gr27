package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Film;
//import no.hvl.data102.filmarkiv.impl.FilmArkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {

    private Scanner scanner;

    public Tekstgrensesnitt(){
        this.scanner = new Scanner(System.in);

    }

    public Film lesFilm(){

        System.out.println("Legg til en ny film: ");

        System.out.println("Skriv inn filmnummer: ");
        int filmNummer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Film produsent: ");
        String filmProdusent = scanner.nextLine();

        System.out.println("Film tittel: ");
        String filmTittel = scanner.nextLine();

        System.out.println("Lanseringsår: ");
        int filmLanseringsar = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Velg sjanger: ");

        for (Sjanger sjanger : Sjanger.values()){
            System.out.println(sjanger.ordinal() + "." + sjanger);
        }

        Sjanger sjanger = null;
        while (sjanger == null){

            String sjangerInput = scanner.nextLine().toUpperCase();
            for (Sjanger s : Sjanger.values()){
                if (s.name().equals(sjangerInput)){
                    sjanger = s;
                    break;
                }
            }

        }
        



        System.out.println("Filmselskap: ");
        String filmSelskap = scanner.nextLine();

        return new Film(filmNummer,filmProdusent,filmTittel, filmLanseringsar,sjanger,filmSelskap);
        
    }

    public void skrivUtFilm(Film film){
        System.out.println("Filmnummer: " + film.getFilmNum());
        System.out.println("Filmprodusent: " + film.getProdusent());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Lanseringsår: " + film.getLanseringsAr());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Filmselskap: " + film.getFilmSelskap());
        System.out.println("\n");
        
    }

    public void skrivUtAlleFilmer(FilmarkivADT arkiv){
        System.out.println("Alle Filmer i arkivet: \n");
        for (int i = 1; i <= arkiv.antall();i++){
            Film film = arkiv.finnFilm(i);
            if (film != null){
                skrivUtFilm(film);
            }else{
                System.out.println("Kan ikke finne film på index '" + i + "'");
            }
        }
    }
  

    public void skrivUtFilmDelstrengTittel(FilmarkivADT arkiv,String delstreng){
        Film[] filmer = arkiv.soekTittel(delstreng);

        if (filmer.length == 0){
            System.out.println("Ingen filmer med delstrengen: '" + delstreng + "' i tittelen");
        } else{
            System.out.println("Filmer med delstrengen: '" + delstreng + "' i tittelen:");
            for (Film film : filmer){
                skrivUtFilm(film);
            }
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv,String delstreng){
        Film [] filmer = arkiv.soekProdusent(delstreng);

        if (filmer.length == 0){
            System.out.println("Ingen filmer av produsenten '" + delstreng + "'.");

        } else{
            System.out.println("Filmer av produsenten '" + delstreng + "': ");

            for (Film film : filmer){
                skrivUtFilm(film);
            }
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv){
        System.out.println("Statistikk: ");
        System.out.println("Totalt antall filmer: " + arkiv.antall());

        for (Sjanger sjanger : Sjanger.values()){
            int antallSjanger = arkiv.antall(sjanger);

            System.out.println("Antall filmer i sjanger " + sjanger + ": " + antallSjanger);
        }

    }

    public Scanner getScanner(){
        return scanner;
    }









}
