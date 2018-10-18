package two_week;

import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		String input;
		String[] myDate = new String[4];
		
		
		// validation check
		input = scan.nextLine();
		myDate = input.split("/");
		System.out.println(myDate[0]);

	}
}
