package ex01.forgot2;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForgotMain2 {

	
	public void setForgot2Stage() {
	Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Forgot2.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		ForgotController2 controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.show();
	}

}
