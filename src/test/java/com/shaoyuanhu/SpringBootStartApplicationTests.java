package com.shaoyuanhu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStartApplicationTests {

	@Autowired
	private GirlProperties girlProperties;

	@Before
	public void before(){
		System.out.println("this is before method");
	}

	@Test
	public void contextLoads() {
		System.out.println(girlProperties.getCupSize());

	}

	@Test
	public void run(){
		try {
			//三种获取Class对象的方式
			//1.调用静态属性class获取对象，只需要具体的类
			Class<GirlProperties> c2 = GirlProperties.class;
			//2.调用getClass方法获取对象，需要具体的类和该类的对象
			Class<? extends GirlProperties> c3 = girlProperties.getClass();
			//3.通过Class.forName()方法获取对象，仅需要使用类名
			String className = "com.shaoyuanhu.GirlProperties";
			Class c = Class.forName(className);

			System.out.println("--------------------------");
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("--------------------------");
			Constructor[] constructors = c.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("--------------------------");
			Method[] methods = c.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals("getCupSize")){
					GirlProperties girlProperties = (GirlProperties) c.newInstance();
					String cupSize = (String) method.invoke(girlProperties, null);
					System.out.println(cupSize);
				}
				System.out.println(method.getName());
			}
			System.out.println("--------------------------");


		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@After
	public void after(){
		System.out.println("this is after method");
	}

}
