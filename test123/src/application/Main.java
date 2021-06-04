package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage afterLogin;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			afterLogin = primaryStage;
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Pane pane = (Pane)FXMLLoader.load(getClass().getResource(fxml));
		afterLogin.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
