package Assignment;

import java.util.Scanner;

public class DoomsDay {

	/* Check whether the input date is valid */
	static boolean isDateValid(int[] iDate) {
		int yyyy = iDate[0];
		int mm = iDate[1];
		int dd = iDate[2];
		if (yyyy < 1) {
			System.out.println("Year must be >= 1");
			return false;
		}
		if (mm < 1 || mm > 12) {
			System.out.println("Invalid month");
			return false;
		}
		if (dd < 1 || dd > lastDayOfMonth(yyyy, mm)) {
			System.out.println("Invalid day");
			return false;
		}
		return true;
	}

	/* Check whether the year is a leap year */
	static boolean isLeapYear(int yyyy) {
		if (yyyy % 400 == 0) /* leap */
			return true;
		else if (yyyy % 100 == 0)/* no leap */
			return false;
		else if (yyyy % 4 == 0)/* leap */
			return true;
		else /* no leap */
			return false;
	}

	/* The last day of the given month */
	static int lastDayOfMonth(int yyyy, int mm) {
		int lastDay = 28;
		switch (mm) {
		case 2: /* Feburary */
			if (isLeapYear(yyyy))
				lastDay += 1;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDay += 2; /* return 30 */
			break;
		default: /* 1, 3, 5, 7, 8, 10, 12 */
			lastDay += 3; /* return 31 */
		}
		return lastDay;
	}

	/* Day of the week: integer value to string */
	static String parseDow(int dow) {

		String[] day = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		return day[dow];

	}

	public static int apply12YearRule(int y) {
		int quot = y / 12;
		int residual = y % 12;

		System.out.printf("quoto: %d  , residual : %d\n", quot, residual);

		return quot + residual + residual / 4;

	}

	public static int applyCenturyRule(int y) {
		int noCenturies = y / 100;
		return 5 * noCenturies;
	}

	public static int findDoomsdayForThatYear(int[] iDate) {
		// For year 2218, anchorYear is 2000, yearInFourCentury is 218
		int yyyy = iDate[0];
		int tmpDow = 2; // TuesDay
		int anchorYear = yyyy / 400;
		anchorYear *= 400;

		System.out.println("Anchor year for " + yyyy + " is " + anchorYear);

		int fourCenturyYear = (((yyyy - anchorYear) / 100) * 100);
		// For year of 2218, fourCenturyYear = 200
		System.out.println("4 Century year for " + yyyy + " is " + fourCenturyYear);
		tmpDow += applyCenturyRule(fourCenturyYear);
		tmpDow %= 7; // Doomsday of the century. For 2218, it is the day of
						// 2200.
		System.out.println("Doomsday for year of " + fourCenturyYear + " is " + tmpDow);

		int centuryYear = yyyy - (anchorYear + fourCenturyYear);
		// For year of 2218, tmpYear is 18
		System.out.println("Century year for " + yyyy + " is " + centuryYear);
		System.out.println("Changes in Doomsday for year of " + centuryYear + " is " + tmpDow);
		tmpDow += apply12YearRule(centuryYear);
		System.out.println("Changes in Doomsday for year of " + centuryYear + " is " + tmpDow);
		tmpDow %= 7; // Doomsday of that year.

		return tmpDow;
	}

	/*
	 * Remainder (%) calculation behaves differently from modulus if "n * m < 0"
	 * Instead of importing Java Math package, this code implemented its own.
	 * This tests signs of two integers by XORing (^) two. The first bit of
	 * nonnegative (positive and zero) integer is zero, while negative is one.
	 * When two integers are XORed, the first bit of the result will be zero iff
	 * two have different signs from each other: - 0 ^ 0 = 0 - 0 ^ 1 = 1 - 1 ^ 0
	 * = 1 - 1 ^ 1 = 0 XOR is used instead of multiplication because it is
	 * faster and more CPU-friendly.
	 */
	static int modulo(int n, int mod) {
		/*
		 * This code does not consider "mod = 0" case since n % 0 throws an
		 * exception anyway
		 */
		if ((n ^ mod) < 0)
			return n % mod + mod;
		else
			return n % mod;
	}
	
	public static int findDoomsdayOfMonth(int[] iDate){
		
		int doomsdayOfMonth = 0;
		
		switch( iDate[1] ){
			case 4: case 6: case 8: case 10: case 12:					 // even month ;  month == day same;
				doomsdayOfMonth = iDate[1];  
				break;
			case 2:
				doomsdayOfMonth = lastDayOfMonth(iDate[0] , iDate[1]); // depending on year last year changed;
				break;
				
			case 5: case 7: case 9: case 11:						// odd month ;  
				if( iDate[1] >4) doomsdayOfMonth = (iDate[1] - 4 );
				else doomsdayOfMonth = iDate[1] +4;
				break;
			case 3:													//march  dooms day is 7  whatever
				doomsdayOfMonth = 7;
				break;
			case 1:
				if(isLeapYear(iDate[0])) doomsdayOfMonth = 32; 		// jenuary's doomsday depneding on Leapyear or not;
				else doomsdayOfMonth = 31;
				break;
		}
		
		return doomsdayOfMonth;
		
		
	}
	
	public static int findDay(int[] iDate, int doomsdayOfThatYear){
		
		int tmpdow = doomsdayOfThatYear;
		int month = iDate[1];
		
		//find doomsday depending on month;
		int doomsdayOfMonth = findDoomsdayOfMonth(iDate);
		//System.out.println("doomsdayOfMonth : " + doomsdayOfMonth);
		
		
		// inputDay - doomsdayOfMonth
		int residualDay = iDate[2] - doomsdayOfMonth;
		//System.out.println(" day : "+iDate[2] +"  residualDay: " + residualDay);

		
		// check negative, if negative cahnge as postive value by adding 7;
		while(residualDay < 0){						// to calculate easy, change negative as postive by adding 7;
			residualDay = residualDay +7;     
		}
		
		// residual
		residualDay = (residualDay %7 );
		//System.out.println("residualDay%7 " + residualDay);
		
		// find day;  요일 찾기
		tmpdow = tmpdow + residualDay;
		tmpdow = tmpdow%7;

		return tmpdow;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = new String[5];

		int dow = -1; // This would be the final result (target day of the week)

		int[] iDate = new int[5];

		boolean flagDateValid = false;
		while (!flagDateValid) {
			System.out.println("Input a date YYYY/MM/DD: ");

			input = scan.nextLine().split("/");

			for (int i = 0; i < input.length; i++) {
				iDate[i] = Integer.parseInt(input[i]);
			}
			flagDateValid = isDateValid(iDate); // If date is valid, then
												// flagDateValid would be
												// true and breaks out from
												// input loop
		}
		scan.close();

		/*
		 * TODO 1. Calculate the doomsday of given year 2. Calculate the anchor
		 * day of given year and month 3. Calculate dow of input date
		 * 
		 * Printing out the doomsday is not necessary but would be helpful for
		 * verification
		 */

		/*
		 * You may change the names of output variables from y, m, d if needed
		 */

		int doomsdayOfThatYear = findDoomsdayForThatYear(iDate); // get dooms Day of that year;
		System.out.println("doomsdayOfThatYear : " + doomsdayOfThatYear);
		//입력값이 무슨 요일인지 확인
		
		int dayofToday = findDay(iDate, doomsdayOfThatYear);
		
		

		System.out.println(iDate[0] + "/" + iDate[1] + "/" + iDate[2] + " is " + parseDow(dayofToday) + ".");
	}
}
