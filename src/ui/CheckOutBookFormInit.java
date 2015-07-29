package ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import business.CheckoutRecordEntry;
import business.LibrarySystemException;
import business.SystemController;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class CheckOutBookFormInit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vbCheckOutRecord;

    @FXML
    private AnchorPane pnCheckOutForm;

    @FXML
    private ScrollPane pnCheckOutRecord;

    @FXML
    private TableColumn<CheckoutRecordEntry, ObservableValue<String>> thCopyNumber;

    @FXML
    private TableColumn<CheckoutRecordEntry, LocalDate> thCheckOutDate;

    @FXML
    private TextField txtMemberId;

    @FXML
    private Button btnCheckOut;

    @FXML
    private TableView<CheckoutRecordEntry> tblCheckOutRecord;

    @FXML
    private TableColumn<CheckoutRecordEntry, LocalDate> thDueDate;

    @FXML
    private Label lblStudentName;

    @FXML
    private TableColumn<CheckoutRecordEntry, ObservableValue<String>> thBook;

    @FXML
    private Label lblMemberId;

    @FXML
    private AnchorPane pnSubCheckOutForm;

    @FXML
    private TextField txtISBN;

    @FXML
    private Label lblISBN;

    
//    //Constructor
//    public CheckOutBookFormInit(){
//    }
//    //Singleton pattern
//    private static CheckOutBookFormInit instance = new CheckOutBookFormInit();
//    public static CheckOutBookFormInit getInstance(){
//    	return instance;
//    }
    @FXML
    void checkOutForm(ActionEvent event) throws LibrarySystemException {
    	String memberId = txtMemberId.getText();
    	String isbn = txtISBN.getText();
  
    	new SystemController().checkoutBook(memberId, isbn);
    }


    public TableColumn<CheckoutRecordEntry, ObservableValue<String>> getThCopyNumber() {
		return thCopyNumber;
	}

	public TableColumn<CheckoutRecordEntry, LocalDate> getThCheckOutDate() {
		return thCheckOutDate;
	}

	public TableColumn<CheckoutRecordEntry, LocalDate> getThDueDate() {
		return  thDueDate;
	}

	public TableColumn<CheckoutRecordEntry, ObservableValue<String>> getThBook() {
		return (TableColumn<CheckoutRecordEntry, ObservableValue<String>>) thBook;
	}

	public Label getLblStudentName() {
		return lblStudentName;
	}
	
	public ScrollPane getPnCheckOutRecord() {
		return pnCheckOutRecord;
	}

	public TableView<CheckoutRecordEntry> getTblCheckOutRecord() {
		return  tblCheckOutRecord;
	}

	

    @FXML
    void initialize() {
        assert vbCheckOutRecord != null : "fx:id=\"vbCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnCheckOutForm != null : "fx:id=\"pnCheckOutForm\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnCheckOutRecord != null : "fx:id=\"pnCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thCopyNumber != null : "fx:id=\"thCopyNumber\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thCheckOutDate != null : "fx:id=\"thCheckOutDate\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert txtMemberId != null : "fx:id=\"txtMemberId\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert btnCheckOut != null : "fx:id=\"btnCheckOut\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert tblCheckOutRecord != null : "fx:id=\"tblCheckOutRecord\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thDueDate != null : "fx:id=\"thDueDate\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblStudentName != null : "fx:id=\"lblStudentName\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert thBook != null : "fx:id=\"thBook\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblMemberId != null : "fx:id=\"lblMemberId\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert pnSubCheckOutForm != null : "fx:id=\"pnSubCheckOutForm\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert txtISBN != null : "fx:id=\"txtISBN\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";
        assert lblISBN != null : "fx:id=\"lblISBN\" was not injected: check your FXML file 'CheckOutBookForm.fxml'.";

    }
}
