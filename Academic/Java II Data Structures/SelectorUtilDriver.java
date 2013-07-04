   import java.util.ArrayList;

   public class SelectorUtilDriver {
   
      public static void main(String[] args) {
         SelectorUtil a = new SelectorUtil();
         ArrayList aL = new ArrayList();
         aL.add(0);
         aL.add(5);
         aL.add(10);
         aL.add(-10);
         aL.add(0);
         IntComp comp = new IntComp();
      
         System.out.println("-10  " + a.min(aL, comp));
         System.out.println("10  " + a.max(aL, comp));
         System.out.println("null  " + a.kmin(aL, comp, 0));
         System.out.println("-10  " + a.kmin(aL, comp, 1));
         System.out.println("0  " + a.kmin(aL, comp, 2));
         System.out.println("5  " + a.kmin(aL, comp, 3));
         System.out.println("10  " + a.kmin(aL, comp, 4));
         System.out.println("null  " + a.kmin(aL, comp, 5));
         System.out.println("null  " + a.kmax(aL, comp, 0));
         System.out.println("10  " + a.kmax(aL, comp, 1));
         System.out.println("5  " + a.kmax(aL, comp, 2));
         System.out.println("0  " + a.kmax(aL, comp, 3));
         System.out.println("-10  " + a.kmax(aL, comp, 4));
         System.out.println("null  " + a.kmax(aL, comp, 5));
         System.out.println("0  " + a.range(aL, comp, -100, -50).size());
         System.out.println("0  " + a.range(aL, comp, 50, 100).size());
         System.out.println("5  " + a.range(aL, comp, -10, 10).size());
         System.out.println("3  " + a.range(aL, comp, -10, 0).size());
         System.out.println("2  " + a.range(aL, comp, 0, 0).size());
      }
   
   }