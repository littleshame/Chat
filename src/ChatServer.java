import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	boolean started = false;
	ServerSocket serverSocket;

	public void start(int port) {
		try {
			serverSocket = new ServerSocket(8888);
			started = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void receive() {
		try {
			while (started) {
				Socket s = serverSocket.accept();
				System.out.println("connect a client");

				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println("------" + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start(8888);
		server.receive();
	}

	public void close() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
