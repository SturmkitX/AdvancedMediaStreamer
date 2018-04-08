package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket server;
	private Socket client;
	private BufferedInputStream sin;
	private BufferedOutputStream sout;
	
	public Server(int port) throws IOException {
		this.server = new ServerSocket(port);
	}
	
	public void accept() throws IOException {
		client = server.accept();
		sin = new BufferedInputStream(client.getInputStream());
		sout = new BufferedOutputStream(client.getOutputStream());
	}
	
	public boolean isConnected() {
		return client.isConnected();
	}
	
	public void disconnect() throws IOException {
		client.close();
		sin.close();
		sout.close();
	}
	
	public void close() throws IOException {
		server.close();
	}
	
	public void sendFile(String path) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
		int count;
		byte[] rd = new byte[8192];
		
		do {
			count = in.read(rd);
			sout.write(rd);
		} while(count < 8192);
		
		in.close();
	}

}
