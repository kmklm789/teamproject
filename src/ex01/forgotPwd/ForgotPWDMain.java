package ex01.forgotPwd;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForgotPWDMain {

	public void setForgotStage() {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotPWD.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		ForgotPWDController controller = loader.getController();
		controller.setRoot(root);
		
		stage.setScene(scene);
		stage.show();
	}
}

