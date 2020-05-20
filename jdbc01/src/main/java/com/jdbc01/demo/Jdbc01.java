package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

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
			dbUser = props.getProperty("username");
			dbPassword = props.getProperty("password");
			System.out.println(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private static void getEmpData() throws SQLException {
		Connection conn = null;//连接对象
		Statement stmt = null;//语句对象
		ResultSet rs = null;//结果集
		String sql = "select * from person";
		
		conn = DriverManager
				.getConnection(url,dbUser,dbPassword);
		stmt = (Statement) conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+","+name+","+age);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	public static void main(String[] args) {
		//1.读取属性文件的值
		try {
			getParams("src/main/resources/pro.properties");
			try {
				getEmpData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
