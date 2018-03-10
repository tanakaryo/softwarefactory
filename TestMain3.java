package org.prac.test;

import org.prac.reflect.BeanUtils;
import org.prac.reflect.TestBean;
import org.prac.reflect.TestPerson;

public class TestMain3 {

	public static void main(String[] args) throws Exception {
		TestBean bean1 = new TestBean("TEST","TSTE");
		TestPerson person1 = new TestPerson();
		
		System.out.println("-- 実行前状態 --");
		System.out.println("-- bean1 --");
		BeanUtils.logProperties(bean1);
		System.out.println("-- person1 --");
		BeanUtils.logProperties(person1);
		
		BeanUtils.copyProperties(person1, bean1);
		
		System.out.println("-- 実行後状態 --");
		System.out.println("-- person1 --");
		BeanUtils.logProperties(person1);
	}
}
