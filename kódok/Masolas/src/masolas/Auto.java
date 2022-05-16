package masolas;

import java.util.UUID;

public class Auto implements Cloneable{
    int ev;
    String marka;
    UUID id;

    public Auto(int ev, String marka) {
        this.ev = ev;
        this.marka = marka;
        id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Auto{" + "ev=" + ev + ", marka=" + marka + ", id=" + id + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /* sekély másolat: a referencia -UUID- nem kerül másolásra */
        //return super.clone(); 
        
        /* mély másolat: meg kell írni, hogy minden refernciából adjunk vissza újat */
        Auto auto = new Auto(ev, marka);
        auto.id = UUID.randomUUID();
        return auto;
    }
    
    
}
