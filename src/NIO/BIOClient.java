package NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import jdk.internal.util.xml.impl.Input;
import jdk.nashorn.internal.ir.CatchNode;

import niuke2017.cangbaotu;

public class BIOClient {
	public static void main(String[] args) throws IOException {
		Socket client = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost", 8000));
			writer = new PrintWriter(client.getOutputStream(), true);
			writer.println("Hello!");
			writer.flush();
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("from server: " + reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
			if (reader != null)
				reader.close();
			if (client != null)
				client.close();
		}
	}
}
