package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFrameInit {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text txtUserName;

	@FXML
	private SplitPane sppFunction;

	@FXML
	private VBox mainWindow;

	@FXML
	private Button btnCheckoutBook;

	@FXML
	private AnchorPane header;

	@FXML
	private Button btnAddNewLibraryMember;

	@FXML
	private Button btnAddCopyExistingBook;

	@FXML
	private VBox menu;

	@FXML
	private Pane operation;

	@FXML
	void addNewLibraryMember(ActionEvent event) {
		try {
			Parent addMemberForm;
			addMemberForm = FXMLLoader.load(getClass().getResource(
					"AddNewLibraryMember.fxml"));
			operation.getChildren().clear();
			operation.getChildren().add(addMemberForm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@FXML
	void checkoutABook(ActionEvent event) {
		try {
			Parent checkoutForm;
			checkoutForm = FXMLLoader.load(getClass().getResource(
					"CheckOutBookForm.fxml"));
			operation.getChildren().clear();
			operation.getChildren().add(checkoutForm);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@FXML
	void addACopyOfExistingBook(ActionEvent event) {
		try {
			Parent addCopyBook;
			addCopyBook = FXMLLoader.load(getClass().getResource(
					"AddCopyOfBook.fxml"));
			operation.getChildren().clear();
			operation.getChildren().add(addCopyBook);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert txtUserName != null : "fx:id=\"txtUserName\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert sppFunction != null : "fx:id=\"sppFunction\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert mainWindow != null : "fx:id=\"mainWindow\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert btnCheckoutBook != null : "fx:id=\"btnCheckoutBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert btnAddNewLibraryMember != null : "fx:id=\"btnAddNewLibraryMember\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert btnAddCopyExistingBook != null : "fx:id=\"btnAddCopyExistingBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'MainFrame.fxml'.";
		assert operation != null : "fx:id=\"operation\" was not injected: check your FXML file 'MainFrame.fxml'.";
	}
}
