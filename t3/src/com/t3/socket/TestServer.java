package com.t3.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) 
			throws IOException {
		ServerSocket serverSocket
			= new ServerSocket(10087);
		
		Socket client = serverSocket.accept();
		System.out.println(client
				.getInetAddress()
					.getHostAddress()+"client");
		BufferedReader burfin
			= new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));
		
		
	}

}
