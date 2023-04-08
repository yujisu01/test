package com.test.cotest.co06;

import java.util.Scanner;

/*
 * 최솟값을 만드는 괄호배치 찾기..
 * 수식의 괄호를 적절하게 배치해 수식값을 최소로 만드는 프로그램을 작성하라
 * 1번째 줄에 식이 주어짐 0~9, 그리고 +,- 만으로 이뤄져있다. 가장 처음과 마지막 문자는 숫자임. 
 * 연속해서 두개 연산자가 나타날수 없음. 5자리보다 많이 연속되는 숫자는 없다
 * 수는 0으로 시작할수 있음. 입력으로 주어지는 식의길이는 50보다 작거나 같다
 * 
 * ex입력
 * 100-40+50+74-30+29-45+43+11
 * 출력
 * -222
 * 
 * 최솟값을 만드려면 가능한 큰수를 뺴야됨. 더하기에 해당되는 부분에 괄호를 쳐서 먼저 모두 계산한후에 빼기를 실행해보자
 * 
 */
public class greedy05_minShu {
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exam = sc.nextLine();
		String[] str = exam.split("-");
		
		for(int i=0; i<str.length; i++) {
			int temp = mySum(str[i]);
			// 첫번째수식은 값을 더하고, 이후 수식들은 값을 빼며 계산한다
			if(i==0) ans = ans + temp;
			else ans = ans-temp;
		}
		System.out.println(ans);
	}
	// String타입의 인자 a를 받아 '+' 기호로 분리하여, sum에 누적반환하는 함수
	static int mySum(String a) {
		int sum = 0;
		// 이렇게 입력시 아래와 같은 에러 발생
		// Exception in thread "main" java.util.regex.PatternSyntaxException: Dangling meta character '+' near index 0
		// String[] temp = a.split("+");  
		String[] temp = a.split("[+]"); 
		for(int i=0; i<temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}

}

/*
 * a.split("[+]") 로 적어야 하는이유
 * split() 메소드를 이용하여 문자열 분리시, 분리기준 문자열을 전달하는 인자는 정규표현식 형태로 전달된다
 * '+' 가 메타문자로서 특별한 의미를 갖게되어 에러발생.
 * '+' 는 정규표현식에서, 바로앞의 문자가 한번이상 나타남을 의미한다. 그래서 문자가 포함된 문자열을 구분기준으로 분리하려는 의도와는 다르게 동작할수있음
 * 반면 [+] 로 감싸서 전달하면, 이는 정규표현식에서 []안의 문자들이 리터럴로 해석되서 그대로 문자열을 분리기준으로 사용함.
 * 따라서 원하는대로 올바르게 분리할수 있다.
 * 
 * 
 */
