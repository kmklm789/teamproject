package ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	@Override
	public void start(Stage arg0) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ex01.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Controller c = loader.getController();
		c.setRoot(root);
		//root값을 불러오기위해서 
		arg0.setScene(scene);
		arg0.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
