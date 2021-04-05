package ex01.mainPage.media;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaService {

	MediaPlayer mediaPlayer;
	MediaView mediaView;
	ProgressBar progressBar;
	Slider slider;

	@FXML
	ImageView fxPlay;
	@FXML
	ImageView fxPause;
	@FXML
	ImageView fxNext;
	@FXML
	ImageView fxPre;

	@Override
	public void MusicPlay() {
		mediaPlayer.play();
	}

	@Override
	public void MusicPause() {
		mediaPlayer.pause();
	}

	@Override
	public void MusicNext() {
		mediaPlayer.play();
	}

	@Override
	public void MusicPre() {
		mediaPlayer.play();
	}

	@Override
	public void setMedia(Parent root, String mediaName) {
		setController(root);
		System.out.println(getClass().getResource(mediaName));
		System.out.println(mediaName);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
	}

	@Override
	public void VolumControll() {
		// TODO Auto-generated method stub
	}

	private void setController(Parent root) {
		mediaView = (MediaView) root.lookup("#fxMediaView");
		fxPlay = (ImageView) root.lookup("#fxPlay");
		fxPause = (ImageView) root.lookup("#fxPause");
		System.out.println(mediaView);
	}

}
