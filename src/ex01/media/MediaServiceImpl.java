package ex01.media;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaService{

	MediaPlayer mediaPlayer;
	MediaView mediaView;
	ProgressBar progressBar;
	Slider slider;
	
	@FXML ImageView fxPlay;
	@FXML ImageView fxPause;
	
	@Override
	public void MusicPlay() {
		mediaPlayer.play();

		
	}

	@Override
	public void MusicPause() {
		mediaPlayer.pause();

		
	}

	@Override
	public void setMedia(Parent root, String mediaName) {
		System.out.println(mediaName);
		setController(root);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		mediaPlayer.setOnReady(() -> {
			fxPlay.setVisible(true);
			fxPause.setVisible(false);
		});
		
		mediaPlayer.setOnPlaying(() -> {
			fxPlay.setVisible(false);
			fxPause.setVisible(true);
		});
		
		mediaPlayer.setOnPaused(() -> {
			fxPlay.setVisible(true);
			fxPause.setVisible(false);
		});
		
	}

	@Override
	public void VolumControll() {
		// TODO Auto-generated method stub
		
	}
	
	private void setController(Parent root) {
		mediaView = (MediaView)root.lookup("#fxMediaView");
		fxPlay = (ImageView)root.lookup("#fxPlay");
		fxPause = (ImageView)root.lookup("#fxPause");
		System.out.println(mediaView);
	}

}
