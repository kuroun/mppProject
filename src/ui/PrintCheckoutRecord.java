package ui;

import java.net.URL;
import java.util.ResourceBundle;

import business.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PrintCheckoutRecord {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMemberId;

    @FXML
    private AnchorPane pnPrintBookRecord;

    @FXML
    private AnchorPane pnSubPrintBookRecord;

    @FXML
    private Label lblMemberId;

    @FXML
    private Button btnPrintRecord;

    @FXML
    void printCheckoutRecord(ActionEvent event) {
    	String memberId = txtMemberId.getText();
    	new SystemController().printBookRecord(memberId);
    }

    @FXML
    void initialize() {
        assert txtMemberId != null : "fx:id=\"txtMemberId\" was not injected: check your FXML file 'PrintBookRecordOfMember.fxml'.";
        assert pnPrintBookRecord != null : "fx:id=\"pnPrintBookRecord\" was not injected: check your FXML file 'PrintBookRecordOfMember.fxml'.";
        assert pnSubPrintBookRecord != null : "fx:id=\"pnSubPrintBookRecord\" was not injected: check your FXML file 'PrintBookRecordOfMember.fxml'.";
        assert lblMemberId != null : "fx:id=\"lblMemberId\" was not injected: check your FXML file 'PrintBookRecordOfMember.fxml'.";
        assert btnPrintRecord != null : "fx:id=\"btnPrintRecord\" was not injected: check your FXML file 'PrintBookRecordOfMember.fxml'.";

    }
}
