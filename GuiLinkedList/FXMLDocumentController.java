//Brijesh Patel 3670789
package assignment8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML 
    Button button1 = new Button();
    @FXML 
    Button button2 = new Button();
    @FXML 
    Button button3 = new Button();
    @FXML 
    Button button4 = new Button();
    @FXML 
    Button button5 = new Button();
    @FXML 
    Button resetButton = new Button();
    @FXML 
    Button closeButton = new Button();
    
    @FXML
    TextField textField = new TextField();
    
    LinkedList list = new LinkedList<Integer>();
    StringBuilder sb = new StringBuilder();
   
        @FXML
       public void handle(ActionEvent ae) {
            // we need to keep mHead in the text field at all times
           sb.append("mHead");
             Button choice = (Button)ae.getSource();
             
             // exit program completly
             if (choice == closeButton)
                    Platform.exit();
             
             // turn buttons back on and reset linked list
             else if (choice == resetButton) // Reset
             {
                 button1.setDisable(false);
                 button2.setDisable(false);
                 button3.setDisable(false);
                 button4.setDisable(false);
                 button5.setDisable(false);
                 list.clearList(list, sb, textField);
             }
             else if(choice == button1) // 1
                 {
                     emptyTextFieldCheck();
                     list.insertData(1);
                     list.printList(sb, textField, list);
                     button1.setDisable(true);
                 }
                 else if(choice == button2) // 2
                 {
                     emptyTextFieldCheck();
                     list.insertData(2);
                     list.printList(sb, textField, list);
                     button2.setDisable(true);
                 }
                else if(choice == button3) // 3
                 {
                     emptyTextFieldCheck();
                     list.insertData(3);
                     list.printList(sb, textField, list);
                     button3.setDisable(true);
                 }
                else if(choice == button4) // 4
                 {
                     emptyTextFieldCheck();
                     list.insertData(4);
                     list.printList(sb, textField, list);
                     button4.setDisable(true);
                 }
                else if(choice == button5) // 5
                 {
                     emptyTextFieldCheck();
                     list.insertData(5);
                     list.printList(sb, textField, list);
                     button5.setDisable(true);
       
                 }
       }
       
        // This prevents program from crashing if textfield is empty to begin with
    // or if the user accidently deletes text from textfield
    public void emptyTextFieldCheck()
    {
        String str = textField.getText();
        if(str == null || str.length() == 0)
            sb.append("mHead");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
