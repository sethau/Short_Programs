   import javax.swing.JOptionPane;
   
   public class TriangleCreator {
   
      public static void main(String[] args) {
         double side1, side2, side3;
         Triangle triangle;
         
         while(true) {
            try {
               /* Get input for sides */
               side1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of side1:"));
               side2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of side2:"));
               side3 = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of side3:"));
            
               /* Create triangle object */
               triangle = new Triangle(side1, side2, side3);
               
               /* Show triangle info */
               JOptionPane.showMessageDialog(null, triangle.toString(), 
                  "Triangle", JOptionPane.PLAIN_MESSAGE);
                  
            	/* End execution when no exception caught */	
               return; 
            }
               catch(NumberFormatException numEx) {
                  JOptionPane.showMessageDialog(null, "Invalid numerical input.", 
                     "Error", JOptionPane.ERROR_MESSAGE);
               }
               catch(IllegalArgumentException argEx) {
                  JOptionPane.showMessageDialog(null, argEx.getMessage(), 
                     "Error", JOptionPane.ERROR_MESSAGE);
               }
               catch(InvalidTriangleException triEx) {
                  JOptionPane.showMessageDialog(null, triEx.getMessage(), 
                     "Error", JOptionPane.ERROR_MESSAGE);
               }
         }
      }
   }