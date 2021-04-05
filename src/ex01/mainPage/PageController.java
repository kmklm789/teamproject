package ex01.mainPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ex01.Controller;
import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.friendList.FriendListMain;
import ex01.imagedto.ImageDTO;
import ex01.mainPage.diary.DiaryMain;
import ex01.mainPage.media.MediaService;
import ex01.mainPage.media.MediaServiceImpl;
import ex01.mainPage.profile.ProfileMain;
import ex01.mainPage.profile.profiledto.ProfileDTO;
import ex01.mainPage.time.TimeService;
import ex01.visitordto.VisitorDTO;

public class PageController implements Initializable {
	Parent root;
	MediaService ms;
	String myId;
	DatabaseService ds;
	PageMain pm;
	ProfileMain pfm;
	DiaryMain diary;
	String text;
	int imageNum;
	HashMap<Integer, String> mu = new HashMap<Integer, String>();
	int num = 1;
	
	@FXML Label profileName;
	@FXML Label profileAge;
	@FXML Label profileBirth;
	@FXML Label profileGender;
	@FXML Label profilePNum;
	@FXML Label profileLbl;

	@FXML TextArea profileText;

	@FXML VBox diaryVbox;
	@FXML VBox visitVbox;
	@FXML VBox imageVbox;

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
	@FXML ImageView fxPre;
	@FXML ImageView fxNext;
	@FXML ImageView profileImg;
	@FXML Button memberProc;
	@FXML Label fxMname;

	public static CommonService cs;
	static {
		cs = new CommonClass();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fxSP01.setVisible(true);
		fxSP02.setVisible(false);
		fxSP03.setVisible(false);
		fxSP04.setVisible(false);
		fxPause.setVisible(false);
		ms = new MediaServiceImpl();
		mu.put(1, "/music/프리스타일-Y.mp3");
		mu.put(2, "/music/에픽하이-우산.mp3");
		pm = new PageMain();
		diary = new DiaryMain();
		ds = new DatabaseServiceImpl();
		pfm = new ProfileMain();
	}

	public void setRoot(Parent root, String myId) {
		this.root = root;
		this.myId = myId;
		ms.setMedia(root, mu.get(num));
		ms.MusicPlay();
		if (num == 1) {
			fxMname.setText("프리스타일-Y");
		} else if (num == 2) {
			fxMname.setText("에픽하이-우산");
		}
		diaryShow();
		visitShow();
		imageShow();
		profileImageShow();
		profileShow();
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

	public void MusicNext() {
		num++;
		if (num == 3) {
			num = 1;
		}
		ms.setMedia(root, mu.get(num));
		ms.MusicPlay();
		if (num == 1) {
			fxMname.setText("프리스타일-Y");
		} else if (num == 2) {
			fxMname.setText("에픽하이-우산");
		}
		System.out.println(mu.get(num));
	}

	public void MusicPre() {
		num--;
		if (num == 0) {
			num = 2;
		}
		ms.setMedia(root, mu.get(num));
		ms.MusicPlay();
		if (num == 1) {
			fxMname.setText("프리스타일-Y");
		} else if (num == 2) {
			fxMname.setText("에픽하이-우산");
		}
		System.out.println(num);
	}

	public void logout() {
		PageController.cs.exit(root);
		Stage stage = new Stage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../loginpage.fxml"));

		Parent root = null;

		try {
			root = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		Controller c = loader.getController();
		c.setRoot(root);

		stage.setScene(scene);
		stage.show();
	}

	public void memberProc() {
		FriendListMain addf = new FriendListMain();
		addf.getMyId(myId);
		System.out.println(myId);
		addf.setFriendStage();
	}

	public void profileImageShow() {
		String path = ds.profileImageShow(myId);
		if (path != null) {
			profileLbl.setText("");
			Image image = new Image(path);
			profileImg.prefWidth(660);
			profileImg.prefHeight(390);
			profileImg.setImage(image);
		} else {
			profileLbl.setText("프로필 사진");
		}
	}

	public void insertProfileImg() {
		ProfileDTO profileDto = new ProfileDTO();
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters()
				.addAll(new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.png", "*.jpg", "*.gif"));
		File file = chooser.showOpenDialog(new Stage());
		if (file != null) {
			String imagepath;
			try {
				imagepath = file.toURI().toURL().toString();
				profileDto.setId(myId);
				profileDto.setPath(imagepath);
				String exist = ds.profileImageShow(myId);
				if (exist == null) {
					int result = ds.profileImage(profileDto);
					if (result == 1) {
						profileLbl.setText("");
						Image image = new Image(imagepath);
						profileImg.prefWidth(660);
						profileImg.prefHeight(390);
						profileImg.setImage(image);
					}
				} else {
					int result = ds.profileImageUpdate(myId, imagepath);
					if (result == 1) {
						profileLbl.setText("");
						profileImg.imageProperty().set(null);
						Image image = new Image(imagepath);
						profileImg.prefWidth(660);
						profileImg.prefHeight(390);
						profileImg.setImage(image);
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Please Select a File");
			alert.showAndWait();
		}
	}

	public void deleteProfileImg() {
		ds.profileImageDelete(myId);
		pm.getMyId(myId);
		pm.setMainStage();
		PageController.cs.exit(root);
	}

	public void profileModify() {
		pfm.setProfileMain(root, myId);
	}

	public void profileShow() {
		HashMap<Integer, String> profileMap = new HashMap<Integer, String>();
		// System.out.println("profileShow() 실행");
		profileMap = ds.profileShow(myId);
		profileName.setText(profileMap.get(1));
		profileAge.setText(profileMap.get(2));
		profileBirth.setText(profileMap.get(3));
		profileGender.setText(profileMap.get(4));
		profilePNum.setText(profileMap.get(5));
		profileText.setText(profileMap.get(6));
	}

	public void diaryWrite() {
		diary.setDiaryStage(myId, root);
	}

	public void diaryShow() {
		HashMap<Integer, String> diaryMap = new HashMap<Integer, String>();
		// System.out.println("mainShow() 실행");
		diaryMap = ds.showDiary(myId);
		for (int j = diaryMap.size(); j > 0; j--) {
			TextArea ta = new TextArea();
			ta.setPrefSize(700, 50);
			ta.setWrapText(true);
			text = diaryMap.get(j);
			ta.setText(text);
			diaryVbox.getChildren().addAll(ta);
		}
	}

	public void diaryExit(Parent pageRoot) {
		PageController.cs.exit(pageRoot);
	}

	public void visitShow() {
		HashMap<Integer, String> visitorMap = new HashMap<Integer, String>();
		String ownerId = "김샤론";
		visitorMap = ds.showVisitor(ownerId); // 나중에 미니홈피의 주인 아이디 넣기
		for (int j = visitorMap.size(); j > 0; j--) {
			Label lbl = new Label();
			lbl.setPadding(new Insets(10));
			lbl.setText((String) visitorMap.get(j));
			visitVbox.getChildren().addAll(lbl);
		}
	}

	public void visitWrite() {
		HashMap<Integer, String> visitorMap = new HashMap<Integer, String>();
		VisitorDTO visitDto = new VisitorDTO();
		TimeService ts = new TimeService();
		int serialNum = 0;
		TextArea content = (TextArea) root.lookup("#visitContent");
		String ownerId = "김샤론";
		serialNum = ds.visitorSerialNum(ownerId); // 나중에 미니홈피의 주인 아이디 넣기
		// 친구의 미니홈피로 이동 시 로그인한 아이디(id)와 이동할 홈피 주인의 아이디(ownerId)를 받아서 넣기
		String time = ts.getTime();
		visitDto.setId(ownerId);
		visitDto.setSerialNum(serialNum);
		visitDto.setContent(myId + " : " + content.getText());
		visitDto.setTime(time);
		int result = ds.saveVisitor(visitDto);
		if (result == 1) {
			visitorMap = ds.showVisitor(ownerId);
			content.clear();
			visitVbox.getChildren().clear();
			for (int j = visitorMap.size(); j > 0; j--) {
				Label lbl = new Label();
				lbl.setPadding(new Insets(10));
				lbl.setText((String) visitorMap.get(j));
				visitVbox.getChildren().addAll(lbl);
			}
		}
	}

	public void visitCancel() {
		TextArea content = (TextArea) root.lookup("#visitContent");
		content.clear();
	}

	public void imageShow() {
		HashMap<Integer, String> imageMap = new HashMap<Integer, String>();
		imageVbox.setAlignment(Pos.CENTER);
		imageMap = ds.showImage(myId);
		if (imageMap.size() != 0) {
			// fxPath.setDisable(true); // 사진찾기 버튼 비활성화
			for (int i = imageMap.size(); i > 0; i--) {
				String result = imageMap.get(i);
				String[] split = result.split("\n"); // ""안에 있는 걸(공백) 기준으로 잘라주는 기능.
				Label lbl = new Label(split[0]);
				lbl.setPrefHeight(20);
				lbl.setFont(new Font(20));
				lbl.setPadding(new Insets(10));
				Image image = new Image(split[1]);
				ImageView imageView = new ImageView();
				imageView.prefWidth(660);
				imageView.prefHeight(390);
				imageView.setImage(image);
				Label lbl2 = new Label("\n");
				lbl2.setPadding(new Insets(30));
				imageVbox.getChildren().addAll(lbl, imageView, lbl2);
			}
		}
	}

	public void choose(ActionEvent actionEvent) {
		HashMap<Integer, String> imageMap = new HashMap<Integer, String>();
		ImageDTO imageDto = new ImageDTO();
		TimeService ts = new TimeService();
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters()
				.addAll(new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.png", "*.jpg", "*.gif"));
		File file = chooser.showOpenDialog(new Stage());
		if (file != null) {
			String imagepath;
			try {
				imagepath = file.toURI().toURL().toString();
				imageNum = ds.serialNumber(myId);
				String time = ts.getTime();
				imageDto.setId(myId);
				imageDto.setSerialNum(imageNum);
				imageDto.setPath(imagepath);
				imageDto.setTime(time);
				ds.saveImagePath(imageDto);
				imageMap = ds.showImage(myId);
				imageVbox.getChildren().clear();
				if (imageMap.size() != 0) {
					for (int i = imageMap.size(); i > 0; i--) {
						String result = imageMap.get(i);
						String[] split = result.split("\n"); // ""안에 있는 걸(공백) 기준으로 잘라주는 기능.
						Label lbl = new Label(split[0]);
						lbl.setPrefHeight(20);
						lbl.setFont(new Font(20));
						lbl.setPadding(new Insets(10));
						Image image = new Image(split[1]);
						ImageView imageView = new ImageView();
						imageView.prefWidth(660);
						imageView.prefHeight(390);
						imageView.setImage(image);
						Label lbl2 = new Label("\n");
						lbl2.setPadding(new Insets(30));
						imageVbox.getChildren().addAll(lbl, imageView, lbl2);
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			cs.alert("파일을 선택해 주세요");
//			Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			alert.setTitle("Information Dialog");
//			alert.setHeaderText("Please Select a File");
//			alert.showAndWait();
		}
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
