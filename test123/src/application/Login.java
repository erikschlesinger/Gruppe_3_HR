package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tfLogin;

	@FXML
	private TextField tfUsername;

	@FXML
	private PasswordField pfPassword;

	@FXML
	private Button bEinloggen;

	@FXML
	void login(ActionEvent event) throws IOException {
		checkLogin();
	}

	@FXML
	void initialize() {
		assert tfLogin != null : "fx:id=\"tfLogin\" was not injected: check your FXML file 'Sample.fxml'.";
		assert tfUsername != null : "fx:id=\"tfUsername\" was not injected: check your FXML file 'Sample.fxml'.";
		assert pfPassword != null : "fx:id=\"pfPassword\" was not injected: check your FXML file 'Sample.fxml'.";
		assert bEinloggen != null : "fx:id=\"bEinloggen\" was not injected: check your FXML file 'Sample.fxml'.";

	}


private void checkLogin() throws IOException {
	Main m = new Main();

	if (tfUsername.getText().toString().equals("Ramzan1") && pfPassword.getText().toString().equals("16092001")) {
		m.changeScene("AfterLogin.fxml");
	} else {
		System.out.println("Falsch");
	}
}
}

