package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddCopyOfBookInit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private Text actiontarget;

    @FXML
    private Button btnCopy;

    @FXML
    private TextField textISDN;

    @FXML
    void handleSubmitButtonAction(ActionEvent event) throws LibrarySystemException {
    	ControllerInterface sc=new SystemController();
          String aIsdn=textISDN.toString();
          sc.addBookCopy(aIsdn);
		
	
    }

    @FXML
    void initialize() {
        assert actiontarget != null : "fx:id=\"actiontarget\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
        assert btnCopy != null : "fx:id=\"btnCopy\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
        assert textISDN != null : "fx:id=\"textISDN\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";

    }
}

