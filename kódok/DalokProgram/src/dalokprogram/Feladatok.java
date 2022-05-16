package dalokprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Feladatok {
    private List<String> stringkLista;
    
    //1. feladathoz
    private ArrayList<String> dalCimekLista;
    
    //2 - 3 feladat
    private ArrayList<Dal> dalok;
    
    public Feladatok(){
        beolvas("dalok.txt");
    }
    
    public void feladat1(){
        System.out.println("1. feladat:\n\tdalok rendezve:");
        dalCimekLista = new ArrayList<>();
        for (String string : stringkLista) {
            String[] s = string.split("/");
            dalCimekLista.add(s[0].trim());
        }
        Collections.sort(dalCimekLista);
        
        for (String dalCim : dalCimekLista) {
            System.out.println(dalCim);
        }
    }
    
    public void feladat2_3(){
        System.out.println("2 - 3  feladat:\n\tdalok Dal osztályban rendezve:");
        feltolt();
        Collections.sort(dalok);
        kiir();
    }
    
    public void feladat4(){
        System.out.println("4. feladat:\n\tELőadó alapján rendezve:");
        Collections.sort(dalok, new EloadoComparator());//<-- ismerni kell
        kiir();
    }
    
    public void feladat5(){
        System.out.println("5. feladat:\n\tELőadó public static rendezve:");
        Collections.sort(dalok, Dal.EloadoRendezo());//<-- NEM KELL ismerni
        kiir();
    }
    
    public void feladat6(){
        System.out.println("6. feladat:\n\tÚj, ismétléses fájl a res mappában:");
        beolvas("src/res/dalok2.txt");
        feltolt();
        kiir();
    }
   
    public void feladat7(){
        System.out.println("7. feladat:\n\tIsmétlések nélkül:");
        Set<Dal> ismNlkRendezetlen = new HashSet<>(dalok);
        for (Dal dal : ismNlkRendezetlen) {
            System.out.println(dal);
        }
    }
    
    public void feladat8(){
        System.out.println("8. feladat:\n\tIsmétlések nélkül, rendezve dalcímekre:");
        Set<Dal> ismNlkRendezetlen = new TreeSet<>(dalok);
        for (Dal dal : ismNlkRendezetlen) {
            System.out.println(dal);
        }
    }
    
    private void beolvas(String fajlNeve){
        try {
            stringkLista = Files.readAllLines(Paths.get(fajlNeve));
        } catch (IOException ex) {
            Logger.getLogger(Feladatok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void feltolt() {
        dalok = new ArrayList<>();
        for (String sor : stringkLista) {
            dalok.add(new Dal(sor));
        }
    }
    
    private void kiir(){
        for (Dal dal : dalok) {
            System.out.println(dal);
        }
    }
}
