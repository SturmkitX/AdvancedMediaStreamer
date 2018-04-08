package client;

import java.io.IOException;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String host = sc.next();
		int port = sc.nextInt();
		
		Client client = new Client(host, port);
		client.receiveFile();
		client.playFile();
		
		client.close();
		sc.close();
	}
}
