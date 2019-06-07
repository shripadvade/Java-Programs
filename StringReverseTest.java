import java.util.Scanner;

public class StringReverseTest {

	
	public static String reverseStringWithoutUsingInbuildFunc(String inputString)
	{
		String outputString ="";
		char inputStrChars[] = inputString.toCharArray();
		for (int i=0;i<inputStrChars.length;i++)
		{
			outputString =inputStrChars[i]+outputString;
			
		}
		
		return outputString;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Code Started :");
		
		System.out.println("Reverse String Without Using Inbuild Function ::");
		String str="N";
		do{
		
	     System.out.println("Enter String to Test :");
		 Scanner scanner = new Scanner(System.in);
	     str = scanner.nextLine(); 
		 System.out.println("Reverse String is ::"+reverseStringWithoutUsingInbuildFunc(str));
		 System.out.println("Do you want to Exit(Y/N) :");
	     str = scanner.next(); 

	     
		}while(!str.equalsIgnoreCase("Y"));

		System.out.println("Code Ended :");
	}

}
