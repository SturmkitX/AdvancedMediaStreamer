package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Client {
	
	private Socket client;
	private BufferedInputStream sin;
	private BufferedOutputStream sout;
	
	public Client(String host, int port) throws IOException {
		this.client = new Socket(host, port);
		sin = new BufferedInputStream(client.getInputStream());
		sout = new BufferedOutputStream(client.getOutputStream());
	}
	
	public boolean isConnected() {
		return client.isConnected();
	}
	
	public void close() throws IOException {
		client.close();
		sin.close();
		sout.close();
	}
	
	public void receiveFile() throws IOException {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("iesire.mp3"));
		int count;
		byte[] rd = new byte[8192];
		
		do {
			count = sin.read(rd);
			out.write(rd);
		} while(count < 8192);
		
		out.close();
	}
	
	public void playFile() {
		Media media = new Media("iesire.mp3");
		MediaPlayer player = new MediaPlayer(media);
		player.play();
	}

}
