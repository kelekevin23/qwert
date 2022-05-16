package masolas;
public class AutoProgram {
    public static void main(String[] args) throws CloneNotSupportedException {
        Auto a1 = new Auto(2000, "VW");
        Auto a2 = (Auto)a1.clone();
        
        a2.ev = 2001;
        a2.marka = "BMW";
        
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
    }
}
