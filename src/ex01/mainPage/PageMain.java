package ex01.mainPage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageMain {
	String myId;

	public void setMainStage() {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		PageController controller = loader.getController();
		controller.setRoot(root, myId);

		stage.setScene(scene);
		stage.show();
	}
	
	public void getMyId(String myId) {
		this.myId = myId;
	}

}
