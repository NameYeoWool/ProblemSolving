package two_week;

import java.util.Scanner;

public class DoomsDay {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String input;
		String[] myDate = new String[4];
		int[] inputDay = new int[4];
		int doomsDay;
		
		// validation check
		do {
		input = scan.nextLine();
		myDate = input.split("/");
		
		} while( isDateValid(myDate) );
		
		
		// change type from string to int;
		for(int i = 0 ; i < myDate.length ; i++){
			inputDay[i] = Integer.parseInt(myDate[i]);
		}
		
		
		
		//find a doomsDay for that year
		doomsDay = findDoomsdayForThatYear(int[] inputDay);
		
		//find a day of the week in that year
		

	}
	
	public static int findDoomsdayForThatYear(int[] inputDay){
		int year = input[0];
		
		int quote = (year / 400 ); 
		int residual = ( year % 400);
		
		// leapYear 일 경우
		if (isLeapYear(year)){
			doomsDay[]
		}else{
			
		}
		
		
		
	}
	
	public static boolean isDateValid(String[] arr){
		
		int year, month, day;
		
		year = Integer.parseInt(arr[0]);
		month = Integer.parseInt(arr[1]);
		day = Integer.parseInt(arr[2]);
		
		boolean result = true;
		// check year
		if (year  < 1 ){
			System.out.printf("%d 잘못된 입력입니다. year\n", year);
			System.out.println("다시 입력하세요");
			result = !result;
			
		}
		
		
		//check month
		if(month > 12 || month < 1 ){
			System.out.printf("%d 잘못된 입력입니다. month\n", month);
			System.out.println("다시 입력하세요");
			result = !result;
		}
		
		//check day
		if( day <  0 || ( day > lastDay(year, month))){

			System.out.printf("%d 잘못된 입력입니다. day\n",day);
			System.out.println("다시 입력하세요");
			
		}
		
		return result;
		
	}

	
	
	
	
	public static int lastDay(int year, int month){
		int lastDay = 28;
		
		
		switch(month){
		case 2: // 윤년일 경우
			if(isLeapYear(year)) lastDay++;
			break;
		
		// odd month
		case 1: case 3: case 5: case 7: case 8:
		case 10: case 12:
			lastDay +=3;
			break;
		
		// not feburary, not odd month;
		default:
			lastDay +=2;
			break;
		
		}
		
		return lastDay;
	}
	
	public static boolean isLeapYear(int year){
		
		boolean result =false;
		// check if leapYear
		if(  (year%400) == 0 ){
			result  = true;
		}	
		
		return result;
	}

}
