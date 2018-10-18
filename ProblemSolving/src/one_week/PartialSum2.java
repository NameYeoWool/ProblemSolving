package one_week;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PartialSum2 {

	public static void main(String[] args) throws IOException {

		int max = 0, tMax = 0;

		int start = 1, end = 1, tStart = 1, tEnd = 1;

		int r;
		int minusCnt = 0;

		String numLine;

		// 파일 불러오기
		File inFile = new File("C:\\Users\\aaa\\Desktop\\자료\\8학기\\문제해결기법\\과제\\gen\\hello.txt");

//		BufferedReader br = new BufferedReader(new FileReader(inFile));

		Scanner scan = new Scanner(inFile);
		

		while (scan.hasNextLine()) {
			
			numLine = scan.nextLine();
			char c;

			for (int i = 0; i < numLine.length(); i++) {
				// 텍스트 파일 읽어온 자료를 한 글자씩 뽑아내기
				c = numLine.charAt(i);

				// 마이너스 숫자인 경우
				if (c == '-') {
					minusCnt++;

					// 음수가 나오기 전까지 범위의 합이 부분합의 최대값 이므로, max값과 비교한다.
					if (tMax > max) {
						max = tMax;
						end = tEnd;
						start = tStart;
					}

					// '-' , '숫자 ' 건너 뛴 다음부터 시작 , tMax는 0으로 초기화 된다.
					// i 는 for 문에서 ++ 로 자동 카운트가 1 올라가므로 +1만 해준다.
					tEnd += 2;
					i += 1;
					tStart = tEnd;
					tMax = 0;

					// 양수 값인 경우
				} else {
					r = c - '0';
					tMax += r;
					tEnd++;

				}

			}
		}//end while 
		
		// 사람이 보기에 '-4'과 같음 음수는 하나의 수이지만, 컴퓨터는 String 에서 -와 숫자를 다르게 인식한다.
		// 일한 부분을 수정하기 위해, minusCnt를 빼서 사람이 보는 것과 같게 출력한다.
		System.out.println(tMax);
		System.out.println(tStart - minusCnt);
		System.out.println(tEnd - 1 - minusCnt);

	}

}
