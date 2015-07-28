package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.Address;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewLibraryMemberInit {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtMemberID;

	@FXML
	private TextField txtCity;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtZip;

	@FXML
	private Button btnAdd;

	@FXML
	private TextField txtLastName;

	@FXML
	private Button btnClear;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtState;

	@FXML
	void clearInput(ActionEvent event) {
		
	}

	@FXML
	void addUser(ActionEvent event) {
		String memberID = txtMemberID.getText();
		String firstName = txtFirstName.getText();
		//String 
	}

	@FXML
	void initialize() {
		assert txtMemberID != null : "fx:id=\"txtMemberID\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtCity != null : "fx:id=\"txtCity\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtZip != null : "fx:id=\"txtZip\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtLastName != null : "fx:id=\"txtLastName\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtFirstName != null : "fx:id=\"txtFirstName\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtStreet != null : "fx:id=\"txtStreet\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
		assert txtState != null : "fx:id=\"txtState\" was not injected: check your FXML file 'AddNewLibraryMember.fxml'.";
	}
}
