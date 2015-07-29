package ui;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import business.BookCopy;
import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddCopyOfBookInit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Text actiontarget;

    @FXML
    private Button btnCopy;

    @FXML
    private TextField textISDN;
    
    @FXML
    private Text actionDisplay;

    @FXML
    void handleSubmitButtonAction(ActionEvent event){
    	ControllerInterface sc=new SystemController();
          String aIsdn=textISDN.getText();
          try {
			if (sc.addBookCopy(aIsdn)) {
				System.out.println(sc.searchBook(aIsdn).toString());
				System.out.println(sc.searchBook(aIsdn).getCopies().length);
//				for (BookCopy cBookCopy : sc.searchBook(aIsdn).getCopies()) {
//					System.out.print(":"+cBookCopy.getCopyNum());
//				}
				Alert alert = new SystemController().messageDialog("INFORMATION");
				alert.setContentText("This copy of book is added successfully to system.");
				alert.showAndWait();
				clearDisplay();
				  actiontarget.setText("\nThis book (ISBN:"+aIsdn+") have "+sc.searchBook(aIsdn).getCopies().length+" copies now.");
				  
				  actionDisplay.setText("");
			}
			
		} catch (LibrarySystemException e) {
			Alert alert = new SystemController().messageDialog("WARNING");
			alert.setContentText("this book is not exist!");
			alert.showAndWait();
			clearWindow();
			 //actiontarget.setText("this book is not exist");
			//e.printStackTrace();
			
		}
         
		
	
    }
    private void clearDisplay() {   	
    	textISDN.setText("");
    	
		
	}
	void clearWindow() {
    	actiontarget.setText("");
    	textISDN.setText("");
    	actionDisplay.setText("");
    }

    @FXML
    void initialize() {
        assert actiontarget != null : "fx:id=\"actiontarget\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
        assert btnCopy != null : "fx:id=\"btnCopy\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
        assert textISDN != null : "fx:id=\"textISDN\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
        assert actionDisplay != null : "fx:id=\"actionDisplay\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";


    }
}

