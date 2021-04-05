package ex01.mainPage.profile;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileMain {

	public void setProfileMain(Parent pageRoot, String id) {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		ProfileController controller = loader.getController();
		controller.setRoot(root, pageRoot, id);

		stage.setScene(scene);
		stage.show();
	}
}
