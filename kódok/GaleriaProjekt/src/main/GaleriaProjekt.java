package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import modell.Festmeny;
import modell.Galeria;
import modell.GaleriaException;
import modell.KiallitasiTargy;

public class GaleriaProjekt {

    public static void main(String[] args) throws ParseException, GaleriaException, IOException {

        Galeria g = new Galeria();

        g.felvesz(new Festmeny("Kevin", "Olajfestmény"));
        g.felvesz(new Festmeny("Roli", "Festmény", "2022-04-20"));
        //g.felvesz(new Festmeny("Oli", "NagyFestmény", "2022-04-21"));//hibás
        g.felvesz(new Festmeny("Oli", "kep.txt"));
        g.felvesz(new Festmeny("Oli", "kep.txt", "2022-04-20"));

        kiir(g);
        //kiir(g);
        /* g.rendezCim();
        kiir(g);
        g.rendezKeszito();
        kiir(g);*/
        
        /*mentes(g);
        System.out.println("Mentés...");
        g = null;
        System.out.println(g);
        System.out.println("Visszaolvasás...");
        g = betoltes();
        kiir(g);*/
        //System.out.println(g);
               
    }

    public static void kiir(Galeria g) {
        for (KiallitasiTargy kiallitasiTargy : g) {
            System.out.println(kiallitasiTargy);
        }
    }

    public static void mentes(Galeria g) throws IOException {
        try {
            FileOutputStream fajlKi = new FileOutputStream("galeria.ser");
            ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);
            objKi.writeObject(g);
            objKi.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static Galeria betoltes() {
        Galeria g = null;
        try {
            g = (Galeria) new ObjectInputStream(new FileInputStream("galeria.ser")).readObject();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        } finally {
            return g;
        }
    }

}
