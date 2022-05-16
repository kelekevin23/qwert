package dalokprogram;

import java.text.Collator;
import java.util.Comparator;
import java.util.Objects;

//4. feladathoz
class EloadoComparator implements Comparator<Dal>{

    @Override
    public int compare(Dal egyik, Dal masik) {
        /* ékezethez, ld compareTo */
        Collator col = Collator.getInstance();
        return col.compare(egyik.getEloado(), masik.getEloado());
    } 
}

//5. feladathoz
public class Dal implements Comparable<Dal>{
    
    public static EloadoComparator EloadoRendezo(){
        return new EloadoComparator();
    }
    
    private String dalCime, eloado;

    public Dal(String dalCime, String eloado) {
        this(dalCime + " / " + eloado);
        //this.dalCime = dalCime;
        //this.eloado = eloado;
    }
    
    public Dal(String sor){
        String[] s = sor.split("/");
        dalCime = s[0].trim();
        eloado = s[1].trim();
    }

    public String getDalCime() {
        return dalCime;
    }

    public String getEloado() {
        return eloado;
    }
    
    @Override
    public String toString() {
        //1. feladathoz
        //return dalCime;
        
        //2. feladathoz
        return dalCime + "/" + eloado;
    }

    //3. feladathoz
    @Override
    public int compareTo(Dal masik) {
        /* ékezet probléma! */
        //return this.dalCime.compareTo(masik.dalCime);
        
        /* helyes ékezetek: */
        Collator col = Collator.getInstance();
        return col.compare(this.dalCime, masik.dalCime);
    }

    //7. feladathoz
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.dalCime);
        hash = 23 * hash + Objects.hashCode(this.eloado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dal other = (Dal) obj;
        if (!Objects.equals(this.dalCime, other.dalCime)) {
            return false;
        }
        if (!Objects.equals(this.eloado, other.eloado)) {
            return false;
        }
        return true;
    }
    
    
    
}
