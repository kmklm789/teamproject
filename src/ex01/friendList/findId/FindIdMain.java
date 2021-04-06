package ex01.friendList.findId;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindIdMain  {
	Parent mainPageRoot;
	String myId;
	 public void setMemberStage() {
	    	Stage stage = new Stage();
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("findIdPage.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(root);
			
			FindIdController controller = loader.getController();
			controller.setRoot(root, myId, mainPageRoot);
			
			stage.setScene(scene);
	    	stage.show();
	    }

	public void getMyId(Parent mainPageRoot, String myId) {
		this.mainPageRoot = mainPageRoot;
		this.myId = myId;
	}

	
}
