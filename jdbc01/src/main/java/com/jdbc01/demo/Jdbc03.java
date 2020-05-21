package com.jdbc01.demo;

import java.util.Scanner;

public class Jdbc03 {
	public static void main(String[] args) {
		//根据用户id和用户名，判断用户是否存在
		//存在返回true，否则返回false
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Integer id = sc.nextInt();
		boolean bool = login(name,id);
	}
	private static boolean login(String name, Integer id) {
		return false;
	}
}
