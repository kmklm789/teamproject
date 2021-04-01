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
	
	@FXML private StackPane fxSP01;
	@FXML private StackPane fxSP02;
	@FXML private StackPane fxSP03;
	@FXML private AnchorPane fxAP01;
	@FXML ImageView fxPlay;
	@FXML ImageView fxPause;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fxSP01.setVisible(true);
		fxSP02.setVisible(false);
		fxSP03.setVisible(false);
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
	}
	@FXML
	private void btn02() {
		System.out.println("02");
		fxSP01.setVisible(false);
		fxSP02.setVisible(true);
		fxSP03.setVisible(false);
	}
	@FXML
	private void btn03() {
		System.out.println("03");
		fxSP01.setVisible(false);
		fxSP02.setVisible(false);
		fxSP03.setVisible(true);
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
		fxBtn02.setLayoutY(270);
	}
	public void btnPress03() {
		fxBtn03.setLayoutX(739);
		fxBtn03.setLayoutY(327);
	}
	
	public void btnRelease01() {
		fxBtn01.setLayoutX(739);
		fxBtn01.setLayoutY(211);
	}
	public void btnRelease02() {
		fxBtn02.setLayoutX(739);
		fxBtn02.setLayoutY(268);
	}
	public void btnRelease03() {
		fxBtn03.setLayoutX(739);
		fxBtn03.setLayoutY(325);
	}

}
