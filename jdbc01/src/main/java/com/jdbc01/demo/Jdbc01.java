package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Jdbc01 {
	private static String url;
	private static String dbUser;
	private static String dbPassword;
	private static void getParams(String fileName) throws IOException {
		Properties props = new Properties();//1.创建属性文件对象
		File file = new File(fileName);//2.创建File对象
		try {
			FileInputStream fileInputStream
				= new FileInputStream(file);//3.文件输入流对象
			props.load(fileInputStream);
			//4.属性文件对象加载指定的文件对象
			url = props.getProperty("url");
			dbUser = props.getProperty("dbUser");
			dbPassword = props.getProperty("dbPassword");
			System.out.println(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//1.读取属性文件的值
		try {
			getParams("src/main/resources/pro.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
