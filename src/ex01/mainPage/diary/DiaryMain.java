package ex01.mainPage.diary;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiaryMain {
	public void setDiaryStage(String userId, Parent pageRoot) {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("diary.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		DiaryController controller = loader.getController();
		controller.setRoot(root, userId, pageRoot);
		
		stage.setScene(scene);
		stage.show();
	}
}
