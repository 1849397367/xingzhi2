package com.demo.reflect;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setName("zhangsan");
		System.out.println(p.getName());
		//通过反射来创建对象
		Class c = p.getClass();//获取Class对象
		Person p2 = (Person) c.newInstance();
		p2.setName("马云");
		System.out.println(p2.getName());
	}
}
