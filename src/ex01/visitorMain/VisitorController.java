package ex01.visitorMain;

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
import ex01.friendList.friendDB.DbFriend;
import ex01.friendList.friendDB.DbFriendImpl;
import ex01.imagedto.ImageDTO;
import ex01.mainPage.PageController;
import ex01.mainPage.PageMain;
import ex01.mainPage.diary.DiaryMain;
import ex01.mainPage.media.MediaService;
import ex01.mainPage.media.MediaServiceImpl;
import ex01.mainPage.mediaInterface.mediaInter;
import ex01.mainPage.profile.ProfileMain;
import ex01.mainPage.profile.profiledto.ProfileDTO;
import ex01.mainPage.time.TimeService;
import ex01.visitordto.VisitorDTO;

public class VisitorController implements Initializable, mediaInter {
	Parent root;
	MediaService ms;
	String friendId;
	String myId;
	DatabaseService ds;
	PageMain pm;
	VisitorMainPage mpv;
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
		mu.put(1, "/music/???????????????-Y.mp3");
		mu.put(2, "/music/????????????-??????.mp3");
		pm = new PageMain();
		mpv = new VisitorMainPage();
		diary = new DiaryMain();
		ds = new DatabaseServiceImpl();
		pfm = new ProfileMain();
	}
	public void setRoot(Parent root, String friendId, String myId) {
		this.root = root;
		this.friendId = friendId;
		this.myId = myId;
		ms.setMedia(root, mu.get(num));
		ms.MusicPlay();
		if (num == 1) {
			fxMname.setText("???????????????-Y");
		} else if (num == 2) {
			fxMname.setText("????????????-??????");
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
			fxMname.setText("???????????????-Y");
		} else if (num == 2) {
			fxMname.setText("????????????-??????");
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
			fxMname.setText("???????????????-Y");
		} else if (num == 2) {
			fxMname.setText("????????????-??????");
		}
		System.out.println(num);
	}

	
	public void logout() {
		ms.MusicStop();
		VisitorController.cs.exit(root);
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
	public void moveMyPage() {
		ms.MusicStop();
		VisitorController.cs.exit(root);
		pm.getMyId(myId);
		pm.setMainStage();
	}
	public void memberProc() {
		FriendListMain addf = new FriendListMain();
		addf.getMyId(root, myId);
		System.out.println(myId);
		addf.setFriendStage();;
	}
	public void profileImageShow() {
		String path = ds.profileImageShow(friendId);
		if(path != null) {
			profileLbl.setText("");
			Image image = new Image(path);
			profileImg.prefWidth(660);
			profileImg.prefHeight(390);
			profileImg.setImage(image);
		}else {
			profileLbl.setText("????????? ??????");
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
				profileDto.setId(friendId);
				profileDto.setPath(imagepath);
				String exist = ds.profileImageShow(friendId);
				if(exist == null) {
					int result = ds.profileImage(profileDto);
					if(result == 1) {
						profileLbl.setText("");
						Image image = new Image(imagepath);
						profileImg.prefWidth(660);
						profileImg.prefHeight(390);
						profileImg.setImage(image);
					}
				}else {
					int result = ds.profileImageUpdate(friendId, imagepath);
					if(result == 1) {
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
		ds.profileImageDelete(friendId);
		pm.getMyId(friendId);
		pm.setMainStage();
		PageController.cs.exit(root);
	}
	public void profileModify() {
		pfm.setProfileMain(root, friendId);
	}
	public void profileShow() {
		HashMap<Integer, String> profileMap = new HashMap<Integer, String>();
		System.out.println("profileShow() ??????");
		profileMap = ds.profileShow(friendId);
		profileName.setText(profileMap.get(1));
		profileAge.setText(profileMap.get(2));
		profileBirth.setText(profileMap.get(3));
		profileGender.setText(profileMap.get(4));
		profilePNum.setText(profileMap.get(5));
		profileText.setText(profileMap.get(6));
	}
//	public void diaryWrite() {
//		diary.setDiaryStage(friendId, root);
//	}
	public void diaryShow() {
		HashMap<Integer, String> diaryMap = new HashMap<Integer, String>();
		System.out.println("mainShow() ??????");
		diaryMap = ds.showDiary(friendId);
		for(int j = diaryMap.size(); j > 0; j--) {
//			Label lbl = new Label();
//			lbl.setPrefSize(700, 100);
//			lbl.setWrapText(true);
//			lbl.setFont(new Font(30));
//			lbl.setPadding(new Insets(20));
			TextArea ta = new TextArea();
			ta.setPrefSize(700, 50);
			ta.setWrapText(true);
			text = diaryMap.get(j);
			ta.setText(text);
			diaryVbox.getChildren().addAll(ta);
//			lbl.setText(text);
//			diaryVbox.getChildren().addAll(lbl);
		}
	}
	public void diaryExit(Parent pageRoot) {
		PageController.cs.exit(pageRoot);
	}
	public void visitShow() {
		HashMap<Integer, String> visitorMap = new HashMap<Integer, String>();
		String ownerId = friendId;
		visitorMap = ds.showVisitor(ownerId);	// ????????? ??????????????? ?????? ????????? ??????
		for(int j = visitorMap.size(); j > 0; j--) {
			Label lbl = new Label();
//				lbl.setPrefWidth(700);
//				lbl.setWrapText(true);
//				lbl.setFont(new Font(30));
				lbl.setPadding(new Insets(10));
			//text = visitorMap.get(j);
			lbl.setText((String)visitorMap.get(j));
			visitVbox.getChildren().addAll(lbl);
//				TextArea ta = new TextArea();
//				ta.setPrefSize(700, 100);
//				ta.setWrapText(true);
//				text = visitorMap.get(j);
//				ta.setText(text);
//				visitVbox.getChildren().addAll(ta);
		}
	}
	public void visitWrite() {
		HashMap<Integer, String> visitorMap = new HashMap<Integer, String>();
		VisitorDTO visitDto = new VisitorDTO();
		TimeService ts = new TimeService();
		int serialNum = 0;
		TextArea content = (TextArea)root.lookup("#visitContent");
		String ownerId = friendId;
		serialNum = ds.visitorSerialNum(ownerId);	// ????????? ??????????????? ?????? ????????? ??????
		// ????????? ??????????????? ?????? ??? ???????????? ?????????(id)??? ????????? ?????? ????????? ?????????(ownerId)??? ????????? ??????
		String time = ts.getTime();
		visitDto.setId(ownerId);
		visitDto.setSerialNum(serialNum);
		visitDto.setContent(myId + " : " + content.getText());
		visitDto.setTime(time);
		int result  = ds.saveVisitor(visitDto);
		if(result == 1) {
			visitorMap = ds.showVisitor(ownerId);
			content.clear();
			visitVbox.getChildren().clear();
			for(int j = visitorMap.size(); j > 0; j--) {
				Label lbl = new Label();
//				lbl.setPrefWidth(700);
//				lbl.setWrapText(true);
//				lbl.setFont(new Font(30));
				lbl.setPadding(new Insets(10));
				//text = visitorMap.get(j);
				lbl.setText((String)visitorMap.get(j));
				visitVbox.getChildren().addAll(lbl);
//				TextArea ta = new TextArea();
//				ta.setPrefSize(700, 100);
//				ta.setWrapText(true);
//				text = visitorMap.get(j);
//				ta.setText(text);
//				visitVbox.getChildren().addAll(ta);
			}
		}
	}
	public void visitCancel() {
		TextArea content = (TextArea)root.lookup("#visitContent");
		content.clear();
	}
	public void imageShow() {
		HashMap<Integer, String> imageMap = new HashMap<Integer, String>();
		imageVbox.setAlignment(Pos.CENTER);
		imageMap = ds.showImage(friendId);
		if(imageMap.size() != 0) {
			//fxPath.setDisable(true);	// ???????????? ?????? ????????????
			for(int i = imageMap.size(); i > 0; i--) {
				String result = imageMap.get(i);
				String[] split = result.split("\n");		// ""?????? ?????? ???(??????) ???????????? ???????????? ??????.
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
				imageNum = ds.serialNumber(friendId);
				String time = ts.getTime();
				imageDto.setId(friendId);
				imageDto.setSerialNum(imageNum);
				imageDto.setPath(imagepath);
				imageDto.setTime(time);
				ds.saveImagePath(imageDto);
				imageMap = ds.showImage(friendId);
				imageVbox.getChildren().clear();
				if(imageMap.size() != 0) {
					for(int i = imageMap.size(); i > 0; i--) {
						String result = imageMap.get(i);
						String[] split = result.split("\n");		// ""?????? ?????? ???(??????) ???????????? ???????????? ??????.
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
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Please Select a File");
			alert.showAndWait();
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
