package one_week;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		
		
		
		int x,p;
		
		Scanner r= new Scanner(System.in);
		
		System.out.println("x를 입력하세요");
		x = r.nextInt();
		
		System.out.println("p를 입력하세요");
		p = r.nextInt();
		
		
		long result = power(x,p);
		System.out.println(result);
		
		

	}
	
	
	public static long power(int x,int p){
		
		if( p == 0 ) return 1;
		if( p == 1 ) return x;		
		
		//짝수일 경우 반갈
		if ( isEven(p) ){
			long temp = power(x,p/2);
			return temp*temp;
		
		//홀수일 경우, 분리한다음 pwer 계산 반복
		}else{
			long temp2 = power(x, p-1);
			return x*temp2;
		}
		

	}
	
	protected static boolean isEven(int p){
		
		if ( (p %2 ) != 0) return false;
		
		return true;
		
	}

}
