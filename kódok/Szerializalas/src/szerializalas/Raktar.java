package szerializalas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Raktar implements Serializable{
    private ArrayList<Tabla> tablak;

    public Raktar() {
        tablak = new ArrayList<>();
    }
    
    public void felvesz(Tabla tabla){
        tabla.setUjId();
        tablak.add(tabla);
    }

    /* ez nem jó, legyen valamelyik:
     * -> nem módosítható lista
     * másolat
     * Iterable
    */
    public List<Tabla> getTablak() {
        //return tablak;
        return Collections.unmodifiableList(tablak);
    }
    
    public void kiir(){
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("raktar.bin"))) {
            //FileOutputStream fajlKi = new FileOutputStream("raktar.bin");
            //ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);
            objKi.writeObject(this);
            //objKi.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Raktar beolvas(String fajlNev){
        Raktar raktar = new Raktar();
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajlNev))){
            raktar = (Raktar)objBe.readObject();
            
            //id
            for (Tabla tabla : raktar.getTablak()) {
                tabla.setUjId();
            }
            
            return raktar;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return raktar;
    }
}
