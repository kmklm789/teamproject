package ex01.forgot;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForgotMain {

	public void setForgotStage() {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Forgot.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		ForgotController controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.show();
	}
}

