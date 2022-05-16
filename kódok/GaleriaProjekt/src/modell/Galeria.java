package modell;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Galeria implements Serializable, Iterable<KiallitasiTargy> {

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria() {
        targyak = new ArrayList<>();
    }

    public List<KiallitasiTargy> getModosithatatlan() {
        return Collections.unmodifiableList(targyak);
    }

    public void felvesz(Festmeny ujFestmeny) throws GaleriaException {
        String datumSzama = ujFestmeny.getDatum().replaceAll("-", "");
        String maiDatumSzama = LocalDate.now().toString().replaceAll("-", "");

        String txt = ujFestmeny.getCim().substring(ujFestmeny.getCim().length() - 4);
        if (txt.equals((".txt"))) {
            Path path = Paths.get(ujFestmeny.getCim());
            if (Files.exists(path)) {
                System.out.println("megjelenítés folyamatban...");
                targyak.add(ujFestmeny);
            } else {
                System.out.println("nem lehet megjeleníteni");
            }
        } else {
            if (Integer.parseInt(datumSzama) > Integer.parseInt(maiDatumSzama)) {
                throw new GaleriaException("Nem lehet későbbi dátum!");
            } else {
                targyak.add(ujFestmeny);
            }
        }

    }

    public void rendezCim() {
        Collections.sort(targyak, new CimComparator());
    }

    public void rendezKeszito() {
        Collections.sort(targyak, new KeszitoComparator());
    }

    public void megjelenit(String utvonal) {
        Path path = Paths.get(utvonal);
        if (Files.exists(path)) {
            System.out.println("megjelenítés folyamatban...");
        } else {
            System.out.println("nem lehet megjeleníteni");
        }
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return getModosithatatlan().iterator();
    }

    @Override
    public String toString() {
        return "Galeria{\n" + "targyak=" + targyak + '}';
    }

}
