package ui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ruleset.ExceptionDefinition;
import ruleset.RuleException;
import ruleset.RuleSet;
import ruleset.RuleSetFactory;
import business.Address;
import business.ControllerInterface;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

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
		clearWindow();
	}

	@FXML
	void addUser(ActionEvent event) {

		try {
			RuleSet AddNewLibraryMemberRuleSet = RuleSetFactory
					.getRuleSet(AddNewLibraryMemberInit.this);
			AddNewLibraryMemberRuleSet.applyRule(AddNewLibraryMemberInit.this);
			String memberID = txtMemberID.getText();
			String firstName = txtFirstName.getText();
			String lastName = txtLastName.getText();
			String street = txtStreet.getText();
			String state = txtState.getText();
			String zip = txtZip.getText();
			String phoneNumber = txtPhoneNumber.getText();
			String city = txtCity.getText();

			Address add = new Address(street, city, state, zip);

			ControllerInterface conIn = new SystemController();
			conIn.addNewMember(memberID, firstName, lastName, phoneNumber, add);
			Alert alert = messageDialog("INFORMATION");
			alert.setContentText("New member is added successfully to system");
			alert.showAndWait();
			clearWindow();
		} catch (Exception e) {
			Alert alert = messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
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

	public String getTxtMemberID() {
		return txtMemberID.getText();
	}

	public void setTxtMemberID(TextField txtMemberID) {
		this.txtMemberID = txtMemberID;
	}

	public String getTxtCity() {
		return txtCity.getText();
	}

	public void setTxtCity(TextField txtCity) {
		this.txtCity = txtCity;
	}

	public String getTxtPhoneNumber() {
		return txtPhoneNumber.getText();
	}

	public void setTxtPhoneNumber(TextField txtPhoneNumber) {
		this.txtPhoneNumber = txtPhoneNumber;
	}

	public String getTxtZip() {
		return txtZip.getText();
	}

	public void setTxtZip(TextField txtZip) {
		this.txtZip = txtZip;
	}

	public String getTxtLastName() {
		return txtLastName.getText();
	}

	public void setTxtLastName(TextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	public String getTxtFirstName() {
		return txtFirstName.getText();
	}

	public void setTxtFirstName(TextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public String getTxtStreet() {
		return txtStreet.getText();
	}

	public void setTxtStreet(TextField txtStreet) {
		this.txtStreet = txtStreet;
	}

	public String getTxtState() {
		return txtState.getText();
	}

	public void setTxtState(TextField txtState) {
		this.txtState = txtState;
	}

	Alert messageDialog(String type) {
		Alert alert;
		if (type.equalsIgnoreCase("warning"))
			alert = new Alert(AlertType.WARNING);
		else
			alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Library System");
		alert.setHeaderText(null);
		return alert;
	}

	void clearWindow() {
		txtMemberID.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtStreet.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtStreet.setText("");
		txtZip.setText("");
		txtPhoneNumber.setText("");
	}

}
