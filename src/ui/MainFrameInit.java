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
import javafx.stage.Stage;
import javafx.stage.Window;
import dataaccess.Auth;

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
	private Button btnViewAllLibraryMembers;

	@FXML
	private Button btnLogout;

	@FXML
	private Text txtUserType;
	
	@FXML
    private Button btnPrintCheckoutRecord;

	@FXML
	void logout(ActionEvent event) {
		// When user click on logout, then close the current window and open
		// login window
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

		// Close MainFrame window
		Window window = header.getScene().getWindow();
		if (window instanceof Stage) {
			((Stage) window).close();
		}

		// Open login window
		try {
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Library System");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addNewLibraryMember(ActionEvent event) {
		try {
			Parent addMemberForm;
			addMemberForm = FXMLLoader.load(getClass().getResource(
					"AddNewLibraryMember.fxml"));
			operation.getChildren().clear();
			operation.getChildren().add(addMemberForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static CheckOutBookFormInit checkoutController;

	@FXML
	void checkoutABook(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"CheckOutBookForm.fxml"));
			Parent checkoutForm = loader.load();
			operation.getChildren().clear();
			operation.getChildren().add(checkoutForm);
			checkoutController = loader.<CheckOutBookFormInit> getController();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addACopyOfExistingBook(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"AddCopyOfBook.fxml"));
			Parent root = loader.load();

			operation.getChildren().clear();

			operation.getChildren().add(root);

			AddCopyOfBookInit controller = loader
					.<AddCopyOfBookInit> getController();
			controller.setBookTable();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void viewAllLibraryMembers(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"LibraryMemberOverview.fxml"));
			Parent root = loader.load();

			operation.getChildren().clear();

			operation.getChildren().add(root);

			LibraryMemberOverviewInit controller = loader
					.<LibraryMemberOverviewInit> getController();
			controller.setMemberTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  @FXML
	    void printCheckoutRecordForm(ActionEvent event) {
		  try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource(
						"PrintBookRecordOfMember.fxml"));
				Parent printRecord = loader.load();
				operation.getChildren().clear();
				operation.getChildren().add(printRecord);

			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	  @FXML
	    void initialize() {
	        assert txtUserName != null : "fx:id=\"txtUserName\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert mainWindow != null : "fx:id=\"mainWindow\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnAddNewLibraryMember != null : "fx:id=\"btnAddNewLibraryMember\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnPrintCheckoutRecord != null : "fx:id=\"btnPrintCheckoutRecord\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert sppFunction != null : "fx:id=\"sppFunction\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnCheckoutBook != null : "fx:id=\"btnCheckoutBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnAddCopyExistingBook != null : "fx:id=\"btnAddCopyExistingBook\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert txtUserType != null : "fx:id=\"txtUserType\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert operation != null : "fx:id=\"operation\" was not injected: check your FXML file 'MainFrame.fxml'.";
	        assert btnViewAllLibraryMembers != null : "fx:id=\"btnViewAllLibraryMembers\" was not injected: check your FXML file 'MainFrame.fxml'.";

	    }

	void initData(String username, String userType) {
		txtUserName.setText(username);
		txtUserType.setText(userType);
	}

	void initWindow(Auth auth) {
		if (auth.equals(Auth.ADMIN)) {
			menu.getChildren().remove(btnCheckoutBook);
			menu.getChildren().remove(btnPrintCheckoutRecord);
		} else if (auth.equals(Auth.LIBRARIAN)) {
			menu.getChildren().remove(btnAddNewLibraryMember);
			menu.getChildren().remove(btnViewAllLibraryMembers);
			menu.getChildren().remove(btnAddCopyExistingBook);
		}
	}
}
