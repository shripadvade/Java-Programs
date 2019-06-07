import java.util.ArrayList;

import com.sun.javafx.util.Logging;

public class SampleClassLoaderTester extends ClassLoader{

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//Classloade
		System.out.println("Classloader of SampleQuickTester ->"+SampleClassLoaderTester.class.getClassLoader());
		
		System.out.println("Classloader of Logging ->"+Logging.class.getClassLoader());
		

		System.out.println("Classloader of ArrayList ->"+ArrayList.class.getClassLoader());
		
	//	Class.forName("SampleQuickTester", false, SampleQuickTester.class.getClassLoader().getParent());
	}
	

}
