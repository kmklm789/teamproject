package ex01.forgotID;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForgotIDMain {

	
	public void setForgot2Stage() {
	Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotID.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		ForgotIDController controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.show();
	}

}
