package szerializalas;

import java.io.Serializable;
import java.util.UUID;

public class Tabla implements Serializable{
    private int szel, mag;
    private String szin;
    
    //nem szerializáljuk
    private transient UUID id;

    public Tabla(int szel, int mag, String szin) {
        this.szel = szel;
        this.mag = mag;
        this.szin = szin;
    }

    public int getSzel() {
        return szel;
    }

    public int getMag() {
        return mag;
    }

    public String getSzin() {
        return szin;
    }

    public UUID getId() {
        return id;
    }

    public void setUjId() {
        this.id = UUID.randomUUID();
    }
    
    @Override
    public String toString() {
        return "Tabla{" + "szel=" + szel + ", mag=" + mag + ", szin=" + szin + ", id=" + id + '}';
    }
    
    
}
