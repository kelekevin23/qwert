package modell;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public abstract class KiallitasiTargy implements Serializable {

   // private Date datum;
    private String keszito, cim, datum;

    public KiallitasiTargy(String keszito, String cim) throws ParseException{
        this(keszito, cim, LocalDate.now().toString());
    }

    public KiallitasiTargy(String keszito, String cim, String datum) throws ParseException {
        this.keszito = keszito;
        this.cim = cim;
        this.datum = datum;
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "\nKiallitasiTargy{" + "keszito=" + keszito + ", cim=" + cim + ", datum= " + datum + "}";
    }

}
