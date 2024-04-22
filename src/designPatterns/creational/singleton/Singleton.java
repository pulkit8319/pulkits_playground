package designPatterns.creational.singleton;

public class Singleton {

	//Volatile keyword is for thread safety
	private volatile static Singleton singleton = null;
	
	private Singleton() throws Exception{
		//This is done to prevent instance creation using reflection(used to call private constructor)
		if(singleton!=null) {
			throw new Exception("Please use get instance method");
		}
	}
	
	public static Singleton getInstance() throws Exception {
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton =  new Singleton();
				}
			}
		}
		return singleton;
	}
}
