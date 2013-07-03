   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import javax.swing.JTextField;
   import javax.swing.JButton;
   import java.awt.Dimension;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import java.text.DecimalFormat;
   import java.util.Scanner;
   
	 /**
	  * Creates a panel that allows users to enter account information
	  * in the format {lastname firstname cableboxes} and calculates the 
	  * total cost accordingly.
	  * Functionality for service selection has not been added; all
	  * costs will be based on the Basic cable package.
	  *
	  * @author Seth Denney
	  * @version 10-9-2011
	  */
   public class AccountCalculatorPanel extends JPanel {
   
      private JLabel inputLabel, outputLabel;
      private JTextField input, output;
      private JButton processButton, clearButton;
      private String inputText;
      private DecimalFormat dForm = new DecimalFormat("0.00");
      
     /**
      * Instantiates a new panel with all of the GUI components,
   	* including input for name and # cable boxes. Includes a 
   	* button for calculating cost and a button for clearing input.
      */
      public AccountCalculatorPanel() {
        // create 3 nested panels
         JPanel topPanel = new JPanel();
         JPanel middlePanel = new JPanel();
         JPanel bottomPanel = new JPanel();
         
      	// instantiate components
         outputLabel = new JLabel("Total Cost:");
         inputLabel = new JLabel("Account Information:");
         processButton = new JButton("Calculate Cost");
         clearButton = new JButton("Clear");
         input = new JTextField(30);
         output = new JTextField(20);
         
         output.setEditable(false); // users can't change cost field
         output.setText("$ "); // cost field starts out with a $
         
      	// create a listener for the buttons and add it to each
         ProcessClearListener buttonListener = new ProcessClearListener();
         processButton.addActionListener(buttonListener);
         clearButton.addActionListener(buttonListener);
         
      	// add input label & box to top panel
         topPanel.add(inputLabel);
         topPanel.add(input);
      	// add buttons to middle panel
         middlePanel.add(processButton);
         middlePanel.add(clearButton);
         // add output label & box to bottom panel
         bottomPanel.add(outputLabel);
         bottomPanel.add(output);
         
      	// add nested panels to main panel
         this.add(topPanel);
         this.add(middlePanel);
         this.add(bottomPanel);
      	
      	// because there is no layout manager, set the panel size manually
         this.setPreferredSize(new Dimension(475, 150));
      }
      
   	/**
       * Calculates cost and updates cost panel if the calculate cost
   	 * button is pressed. Clears intput display and sets cost to a $
   	 * symbol if the clear button is pressed.
       */
      private class ProcessClearListener implements ActionListener {
      
         public void actionPerformed(ActionEvent event) {
            CableAccount account;
            int numBoxes = 0;
            String dummy;
         	
            if (event.getSource() == processButton) {
               account = new CableAccount(input.getText());
               inputText = input.getText();
               
               Scanner userInput = new Scanner(inputText);
            	
               dummy = userInput.next();
               dummy = userInput.next();
               numBoxes = Integer.parseInt(userInput.next());
               account.setCableBoxes(numBoxes);
               account.setService(1);
               output.setText("$" + String.valueOf(dForm.format(
                  account.totalCost())));
            }
            else if (event.getSource() == clearButton) {
               input.setText("");
               output.setText("$");
            }
            
         }
      }
   }