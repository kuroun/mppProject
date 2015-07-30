package ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import ruleset.RuleException;
import ruleset.RuleSet;
import ruleset.RuleSetFactory;
import business.Book;
import business.ControllerInterface;
import business.LibrarySystemException;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class AddCopyOfBookInit {

	@FXML
	private Button btnCopy;

	@FXML
	private TableColumn<Book, String> colBookTitle;

	@FXML
	private TableColumn<Book, String> colBookISBN;

	@FXML
	private TableColumn<Book, String> colBookNumCopies;

	@FXML
	private TextField textISDN;

	@FXML
	private TableView<Book> tbExistingCopiesBook;

	@FXML
	private TableColumn<Book, ObservableValue<String>> colBookAuthor;

	@FXML
	private Label lblBookISBN;

	@FXML
	private Text txtTitle;

	@FXML
	private Text actionDisplay;

	@FXML
	void handleSubmitButtonAction(ActionEvent event) {
		setBookTable();

		try {

			RuleSet rules = RuleSetFactory.getRuleSet(AddCopyOfBookInit.this);
			rules.applyRule(AddCopyOfBookInit.this);

			ControllerInterface sc = new SystemController();
			String aIsbn = textISDN.getText();

			if (sc.addBookCopy(aIsbn)) {
				System.out.println(sc.searchBook(aIsbn).toString());
				System.out.println(sc.searchBook(aIsbn).getCopies().length);
				Alert alert = new SystemController()
						.messageDialog("INFORMATION");
				alert.setContentText("This copy of book is added successfully to system");
				alert.showAndWait();
				clearDisplay();
				setBookTable();
				System.out.println("after:"
						+ sc.searchBook(aIsbn).getCopies().length);
				actionDisplay.setText("\nThis book (ISBN:" + aIsbn + ") have "
						+ sc.searchBook(aIsbn).getCopies().length
						+ " copies now.");
			}

		} catch (RuleException e) {
			Alert alert = new SystemController().messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (LibrarySystemException e) {
			Alert alert = new SystemController().messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}

	private void clearDisplay() {
		textISDN.setText("");

	}

	void clearWindow() {

		textISDN.setText("");
		actionDisplay.setText("________________________________");
	}

	@FXML
	void initialize() {
		assert btnCopy != null : "fx:id=\"btnCopy\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert colBookTitle != null : "fx:id=\"colBookTitle\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert colBookISBN != null : "fx:id=\"colBookISBN\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert colBookNumCopies != null : "fx:id=\"colBookNumCopies\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert textISDN != null : "fx:id=\"textISDN\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert tbExistingCopiesBook != null : "fx:id=\"tbExistingCopiesBook\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert colBookAuthor != null : "fx:id=\"colBookAuthor\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert lblBookISBN != null : "fx:id=\"lblBookISBN\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert txtTitle != null : "fx:id=\"txtTitle\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";
		assert actionDisplay != null : "fx:id=\"actionDisplay\" was not injected: check your FXML file 'AddCopyOfBook.fxml'.";

	}

	@SuppressWarnings("unchecked")
	public void setBookTable() {

		ObservableList<Book> memberData = FXCollections.observableArrayList();
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Book> member = (Map.Entry) it.next();
			memberData.add(member.getValue());
		}
		tbExistingCopiesBook.setItems(memberData);
		colBookTitle
				.setCellValueFactory(new PropertyValueFactory<Book, String>(
						"title"));
		colBookTitle.setCellFactory(TextFieldTableCell.forTableColumn());

		colBookISBN.setCellValueFactory(new PropertyValueFactory<Book, String>(
				"isbn"));
		colBookISBN.setCellFactory(TextFieldTableCell.forTableColumn());

		colBookAuthor
				.setCellValueFactory(new PropertyValueFactory<Book, ObservableValue<String>>(
						"authors"));

		colBookNumCopies
				.setCellValueFactory(new PropertyValueFactory<Book, String>(
						"numCopies"));
		colBookISBN.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	public String getTextISDN() {
		return textISDN.getText();
	}

	public String getTxtTitle() {
		return txtTitle.getText();
	}

}
