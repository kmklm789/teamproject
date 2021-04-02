package ex01.mainPage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import ex01.media.MediaService;
import ex01.media.MediaServiceImpl;

public class PageController implements Initializable{
	Parent root;
	MediaService ms;
	
	@FXML ImageView fxBtn01;
	@FXML ImageView fxBtn02;
	@FXML ImageView fxBtn03;
	@FXML ImageView fxBtn04;
	
	@FXML private StackPane fxSP01;
	@FXML private StackPane fxSP02;
	@FXML private StackPane fxSP03;
	@FXML private StackPane fxSP04;
	@FXML private AnchorPane fxAP01;
	@FXML ImageView fxPlay;
	@FXML ImageView fxPause;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fxSP01.setVisible(true);
		fxSP02.setVisible(false);
		fxSP03.setVisible(false);
		fxSP04.setVisible(false);
		fxPause.setVisible(false);
		ms = new MediaServiceImpl();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root, "../../프리스타일-Y.mp3");
	}

	@FXML
	private void btn01() {
		System.out.println("01");
		fxSP01.setVisible(true);
		fxSP02.setVisible(false);
		fxSP03.setVisible(false);
		fxSP04.setVisible(false);
	}
	@FXML
	private void btn02() {
		System.out.println("02");
		fxSP01.setVisible(false);
		fxSP02.setVisible(true);
		fxSP03.setVisible(false);
		fxSP04.setVisible(false);
	}
	@FXML
	private void btn03() {
		System.out.println("03");
		fxSP01.setVisible(false);
		fxSP02.setVisible(false);
		fxSP03.setVisible(true);
		fxSP04.setVisible(false);
	}
	@FXML
	private void btn04() {
		System.out.println("04");
		fxSP01.setVisible(false);
		fxSP02.setVisible(false);
		fxSP03.setVisible(false);
		fxSP04.setVisible(true);
	}
	
	public void MusicPlay() {
		ms.MusicPlay();
	}
	
	public void MusicPause() {
		ms.MusicPause();
	}

	public void btnPress01() {
		fxBtn01.setLayoutX(739);
		fxBtn01.setLayoutY(213);
	}
	public void btnPress02() {
		fxBtn02.setLayoutX(739);
		fxBtn02.setLayoutY(263);
	}
	public void btnPress03() {
		fxBtn03.setLayoutX(739);
		fxBtn03.setLayoutY(313);
	}
	public void btnPress04() {
		fxBtn04.setLayoutX(739);
		fxBtn04.setLayoutY(363);
	}
	
	public void btnRelease01() {
		fxBtn01.setLayoutX(739);
		fxBtn01.setLayoutY(211);
	}
	public void btnRelease02() {
		fxBtn02.setLayoutX(739);
		fxBtn02.setLayoutY(261);
	}
	public void btnRelease03() {
		fxBtn03.setLayoutX(739);
		fxBtn03.setLayoutY(311);
	}
	public void btnRelease04() {
		fxBtn04.setLayoutX(739);
		fxBtn04.setLayoutY(361);
	}

}
