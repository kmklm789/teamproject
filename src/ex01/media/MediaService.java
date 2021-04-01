package ex01.media;

import javafx.scene.Parent;

public interface MediaService {
	public void MusicPlay();
	public void MusicPause();
	public void setMedia(Parent root, String mediaName);
	public void VolumControll();
}
