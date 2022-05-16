package szerializalas;
public class Szerializalas {

    public static void main(String[] args) {
        Raktar raktar = new Raktar();
        raktar.felvesz(new Tabla(12, 23, "fehér"));
        raktar.felvesz(new Tabla(10, 20, "piros"));
        raktar.felvesz(new Tabla(11, 22, "Kék"));
        
        mutatLista(raktar);
        
        raktar.kiir();
        
        System.out.println("raktar null");
        raktar = null;
        System.out.println("raktár beolvasva:");
        raktar = Raktar.beolvas("raktar.bin");
        mutatLista(raktar);
        
    }

    private static void mutatLista(Raktar raktar) {
        for (Tabla tabla : raktar.getTablak()) {
            System.out.println(tabla);
        }
    }
    
}
