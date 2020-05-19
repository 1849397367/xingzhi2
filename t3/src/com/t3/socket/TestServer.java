package com.t3.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
		
		InputStream in = client.getInputStream();
		//获取字节输入流
		BufferedReader burfin
			= new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));
		
		PrintWriter pw
			=new PrintWriter(client.getOutputStream(),true);
		pw.print("success");
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		OutputStream out 
			= client.getOutputStream();
		out.write("hello客户端".getBytes());
		client.close();
		
	}

}
