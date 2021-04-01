package ex01.mainPage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageMain {

	public void setMainStage() {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		PageController controller = loader.getController();
		controller.setRoot(root);

		stage.setScene(scene);
		stage.show();
	}

}
