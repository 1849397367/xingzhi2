package com.t3.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) throws IOException {
		Socket s 
			= new Socket("localhost",10088);
		OutputStream out
			= s.getOutputStream();
		out.write("你好服务端".getBytes());
		InputStream in = s.getInputStream();
		byte[] buf= new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		s.close();
	}
}
