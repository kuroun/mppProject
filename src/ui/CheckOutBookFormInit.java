package ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ruleset.RuleSet;
import ruleset.RuleSetFactory;
import business.CheckOutRecordTable;
import business.LibrarySystemException;
import business.SystemController;

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
    private TableColumn<CheckOutRecordTable, Integer> thCopyNumber;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> thCheckOutDate;

    @FXML
    private TextField txtMemberId;

    @FXML
    private Button btnCheckOut;

    @FXML
    private TableView<CheckOutRecordTable> tblCheckOutRecord;

    @FXML
    private TableColumn<CheckOutRecordTable, LocalDate> thDueDate;

    @FXML
    private Label lblStudentName;

    @FXML
    private TableColumn<CheckOutRecordTable, String> thBook;

    @FXML
    private Label lblMemberId;

    @FXML
    private AnchorPane pnSubCheckOutForm;

    @FXML
    private TextField txtISBN;

    @FXML
    private Label lblISBN;

    @FXML
    void checkOutForm(ActionEvent event) throws LibrarySystemException {
    	String memberId = txtMemberId.getText();
    	String isbn = txtISBN.getText();
    	try{
    		RuleSet AddNewCheckoutRecordRuleSet = RuleSetFactory
					.getRuleSet(CheckOutBookFormInit.this);
    		AddNewCheckoutRecordRuleSet.applyRule(CheckOutBookFormInit.this);
    		new SystemController().checkoutBook(memberId, isbn);
    	}catch(Exception e){
    		Alert alert = new SystemController().messageDialog("WARNING");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }


    public TableColumn<CheckOutRecordTable, Integer> getThCopyNumber() {
		return thCopyNumber;
	}

	public TableColumn<CheckOutRecordTable, LocalDate> getThCheckOutDate() {
		return thCheckOutDate;
	}

	public TableColumn<CheckOutRecordTable, LocalDate> getThDueDate() {
		return  thDueDate;
	}

	public TableColumn<CheckOutRecordTable, String> getThBook() {
		return thBook;
	}

	public Label getLblStudentName() {
		return lblStudentName;
	}
	
	public ScrollPane getPnCheckOutRecord() {
		return pnCheckOutRecord;
	}

	public TableView<CheckOutRecordTable> getTblCheckOutRecord() {
		return  tblCheckOutRecord;
	}

   public TextField getTxtMemberId() {
		return txtMemberId;
	}


	public TextField getTxtISBN() {
		return txtISBN;
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
