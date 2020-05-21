package com.jdbc01.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc03 {
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
	public static void main(String[] args) throws IOException {
		//根据用户id和用户名，判断用户是否存在
		//存在返回true，否则返回false
		getParams("src/main/resources/pro.properties");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = sc.next();
		System.out.println("请输入密码");
		String pwd = sc.next();
		
		 //select * from person where name='zs' and pwd='1' or 1=1
				 
		boolean bool = login("zs","5' or '1=1");
		System.out.println(bool);
	}
	private static boolean login(String name, String  pwd) {
		boolean flag = true;//新建一个标志变量
		Connection conn = null;//连接对象
		Statement stmt = null;//语句对象
		try {
			conn = DriverManager.getConnection(url,dbUser,dbPassword);
			stmt = conn.createStatement();
			String sql = "select * from person where name ='"+name+"'and pwd= '"+pwd+"'";
			ResultSet resultSet= stmt.executeQuery(sql);
			if(!resultSet.next()) {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
