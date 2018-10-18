package two_week;

public class DoomsSource {
	
	public static void main(String[] args){
		
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
	}


/* Find out a day of given month which has the same doomsay */
static int applyMonthlyRule( int [] iDate ) {

	int doomsday = -1;
	int yyyy = iDate[ 0 ];
  int mm = iDate[ 1 ];
  
  switch (mm) {
    case 1:
  		doomsday += 3;
		case 2:
      doomsday += lastDayOfMonth( yyyy, 2 ) + 1;
      break;
  	case 3:
  		doomsday = 0;
  		break;
  	case 4:
  	case 6:
  	case 8:
  	case 10:
  	case 12:
  		doomsday = mm;
  		break;
  	case 5:
  	case 7:
  		doomsday = mm + 4;
  		break;
  	case 9:
    case 11:
			doomsday = mm - 4;
    	break;
    default:
		System.out.println( "applyMonthlyRule: invalid value of month " + mm );
	}
	return doomsday;
}

public static int apply12YearRule ( int yyyy ) {

	int	quotient12Year = yyyy / 12;	
	int residue12Year = yyyy % 12;
	System.out.println( "Quotient " + quotient12Year + " Residue " + residue12Year );
	
	return quotient12Year + residue12Year + residue12Year / 4;
}
 		
public static int applyCenturyRule ( int yyyy ) {		
										// Apply a 100-year rule and return an offset of Doomsday for a year of a century 
	int noCenturies = yyyy / 100;		// How many century in the year. 218 / 2 = 2
	return 5 * noCenturies;				// Century shifts -2 days for Doomsday
}
 	
public static int findDoomsdayForThatYear( int [] iDate ) {
  										// For year 2218, anchorYear is 2000, yearInFourCentury is 218
	int yyyy = iDate[ 0 ];
  int tmpDow = 2;
 	int anchorYear = yyyy / 400; 
 	anchorYear *= 400;
 	
 	System.out.println( "Anchor year for " + yyyy + " is " + anchorYear );	
 	
 	int fourCenturyYear = ( ( ( yyyy - anchorYear ) / 100 ) * 100 );	
 										// For year of 2218, fourCenturyYear = 200
 	System.out.println( "4 Century year for " + yyyy + " is " + fourCenturyYear );	
 	tmpDow += applyCenturyRule( fourCenturyYear );
 	tmpDow %= 7;						// Doomsday of the century. For 2218, it is the day of 2200.
 	System.out.println( "Doomsday for year of " + fourCenturyYear + " is " + tmpDow );	
 	
 	int centuryYear = yyyy - (anchorYear + fourCenturyYear);
 										// For year of 2218, tmpYear is 18
 	System.out.println( "Century year for " + yyyy + " is " + centuryYear );	
 	System.out.println( "Changes in Doomsday for year of " + centuryYear + " is " + tmpDow );	
 	tmpDow += apply12YearRule ( centuryYear );
 	System.out.println( "Changes in Doomsday for year of " + centuryYear + " is " + tmpDow );	
 	tmpDow %= 7;						// Doomsday of that year.

 	return tmpDow;
}

/* Check whether the input date is valid */
static boolean isDateValid( int [ ] iDate ) {
int yyyy = iDate[ 0 ];
int mm = iDate[ 1 ];
int dd = iDate[ 2 ];
  if( yyyy < 1 ) {
    System.out.println( "Year must be >= 1" );
    return false;
  }
  if( mm < 1 || mm > 12 ) {
    System.out.println( "Invalid month" );
    return false;
  }
  if( dd < 1 || dd > lastDayOfMonth( yyyy, mm ) ) {
    System.out.println( "Invalid day" );
    return false;
  }
  return true;
}

/* Check whether the year is a leap year */
static boolean isLeapYear( int yyyy ) {
	if( yyyy % 400 == 0 )	/* leap */
		return true;
	else if( yyyy % 100 == 0 )/* no leap */
		return false;
	else if( yyyy % 4 == 0 )/* leap */
		return true;
	else					/* no leap */
		return false;
}

/* The last day of the given month */
static int lastDayOfMonth( int yyyy, int mm ) {
	int	lastDay = 28 ;
	switch ( mm ) {
    case 2:					/* Feburary */
      if( isLeapYear( yyyy ) )
        lastDay += 1;  
      break;
    case 4:
    case 6:
    case 9:
    case 11:
      lastDay += 2;		/* return 30 */
      break;
    default:				/* 1, 3, 5, 7, 8, 10, 12 */
      lastDay += 3;		/* return 31 */
  }
  return lastDay;
}

}