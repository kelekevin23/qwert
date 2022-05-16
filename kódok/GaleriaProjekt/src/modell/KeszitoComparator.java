package modell;

import java.text.Collator;
import java.util.Comparator;

public class KeszitoComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getKeszito(), masik.getKeszito());
    }

}
