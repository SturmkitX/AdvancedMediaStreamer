package server;

import java.io.IOException;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int port = sc.nextInt();
		
		Server server = new Server(port);
		server.accept();
		server.sendFile("/home/bogdan/Music/suicidal-tendencies-waking-the-dead.mp3");
		
		server.disconnect();
		server.close();
		sc.close();
	}
}
