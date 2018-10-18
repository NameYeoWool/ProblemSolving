package one_week;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartialSum {

	public static void main(String[] args) {
		

/*		String wholeNum = readFile();
		
		partialSum(wholeNum);*/
		
		String x = "123101-213141";

		
		
		for(int i =0 ; i < x.length(); i ++){
			char ch1 = x.charAt(i);
			
			/*System.out.print(ch1);
			if(ch1 == '-') System.out.print("마이너스");
			*/
			
			int w = ch1 -'0';
			System.out.println(w);
			
		}
		

	}
	
	public static void partialSum(String wholeNum){
		
		int max, start, end, num, tMax, tStart, tEnd;
		int cnt = 0; 
		
		max = num = tMax = 0;
		start = end = tStart = tEnd = 1;
		String s = wholeNum;
		
		/*for(int i = 0 ; i < wholeNum.length() ; i++){
			String s= wholeNum.substring(0);
			System.out.println(s);
			
		}*/
		for( int i = 0 ; i < wholeNum.length() ; i++){
			
			// 마이너스가 나올때 처리해주어야 함.

			s = s.substring(0,0);
			System.out.println(s);
			
			
			//음수 부호일 경우
			if(s.equals("-")){
				//tMax가 최대값일 경우
				if( tMax > max){
					max = tMax;
					start = tStart;
					end = tEnd;
				} else{
					tStart = tEnd+3;
					tEnd = tStart;
					tMax = 0;
				}
				
			//숫자일 경우
			}else{

				num = Integer.parseInt(s);
				
				tEnd++;
				tMax = tMax + num;
			}
			
			
			// 첫글자를 제외한 나머지 문자로 s 재설정
			s = wholeNum.substring(1);

			
		}// end for 문
		
		System.out.println(max);
		System.out.printf("range : %d ~ %d ", start,end);
	
		
	}
	
	
	public static String readFile(){
		
		File inFile = new File("C:\\Users\\aaa\\Desktop\\자료\\8학기\\문제해결기법\\과제\\gen\\hello.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(inFile);
			
			return scan.toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
		
		
		//return scan;
		/*
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(inFile));
	        int ch = br.

	        while(ch != -1){	//-1을 EOP 라고 부르며 파일의 끝을 나타낸다. (End Of File)
	          //한글자씩 출력
	          System.out.println((char)ch);
	          //다음 글자를 읽는다.
	          ch = br.read();
	        }
			
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
	    }finally {
	            if(br != null) try {br.close(); } catch (IOException e) {}
	    }
		*/
	}

}
