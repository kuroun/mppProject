package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import ruleset.LoginRuleSet;
import ruleset.RuleSet;
import ruleset.RuleSetFactory;
import business.SystemController;

public class LoginInit {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtUsername;

	@FXML
	private Button btnLogin;

	@FXML
	private AnchorPane header;

	@FXML
	private PasswordField txtPassword;

	@FXML
	void login(ActionEvent event) {
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		RuleSet loginRuleSet = RuleSetFactory.getRuleSet(LoginInit.this);
		try {
			loginRuleSet.applyRule(LoginInit.this);

			// After passing rule set check
			SystemController sysCon = new SystemController();
			sysCon.login(username, password);

			// Close login window
			Window window = header.getScene().getWindow();
			if (window instanceof Stage) {
				((Stage) window).close();
			}

			// After login success, open main frame window
			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"MainFrame.fxml"));

			Parent root = loader.load();

			// Passing Username from login window to Mainframe window
			// Directly from the caller to the controller
			MainFrameInit controller = loader.<MainFrameInit> getController();
			controller.initWindow(SystemController.currentAuth);
			controller.initData(txtUsername.getText(), SystemController.currentAuth.toString());
			

			Stage stage = new Stage();
			stage.setTitle("Library Systems");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Library System");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void initialize() {
		assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Login.fxml'.";
		assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
		assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'Login.fxml'.";
		assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Login.fxml'.";

	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getTxtPassword() {
		return txtPassword.getText();
	}

}
