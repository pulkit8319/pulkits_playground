package designPatterns.creational.singleton;

import java.lang.reflect.Constructor;

public class TestSingleton {

	public static void main(String[] args) throws Exception {
		Singleton ss1 = Singleton.getInstance();
		Singleton ss2 = Singleton.getInstance();
		
		//To test reflection
		String className = Singleton.class.getName();
		Class<Singleton> forName = (Class<Singleton>) Class.forName(className);
		Constructor<Singleton> declaredConstructors = forName.getDeclaredConstructor();
		declaredConstructors.setAccessible(true);
		Singleton ss3 = (Singleton) declaredConstructors.newInstance();
				
		System.out.println(ss1.hashCode());
		System.out.println(ss2.hashCode());
		System.out.println(ss3.hashCode());
	}
}
