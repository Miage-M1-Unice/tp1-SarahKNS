package dynamicLoading;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

public class MyClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		ClassLoader clTest = MyClassLoader.class.getClassLoader();
		System.out.println("Classe test : "  + clTest);
		
		Class<?> cl = Class.forName("TP3-ChargeDyn.src.dynamicLoading.Test.java");
		System.out.println("Classe test : "  + cl);
		
/*		Constructor cstr =cl.getConstructor(null);
		System.out.println("Classe test : "  + cstr);
		
		Class Object o = cstr.newInstance(null);
		System.out.println("Classe test : "  + o);*/
	}



}
