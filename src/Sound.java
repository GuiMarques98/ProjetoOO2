import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Sound implements Runnable {

	private AudioClip audio;

	public Sound(String music) {
		URL url = Sound.class.getResource(music);
		this.audio = Applet.newAudioClip(url);
		
	}	


	public void play() {
		audio.play();
	}

	@Override
	public void run() {
			loop();
	}
	
	public void stop() {
		audio.stop();
	}



	public void loop() {
		audio.loop();
	}

}
