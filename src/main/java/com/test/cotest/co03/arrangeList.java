package com.test.cotest.co03;

import java.util.Scanner;
// N개의 숫자를 입력받아서, 이숫자를 모두합해 출력하는 프로그램.
public class arrangeList {
	public static void main(String[] args) {
		// 1.n값 입력받기 (Scanner함수)
		// 2.길이 n의 숫자를 입력받어서 String변수에 저장
		// 3.int형 변수 sum선언..
		// 4.for문 돌리고, 
		// 5.sum출력
		
		Scanner sc=  new Scanner(System.in);
		
		int N = sc.nextInt();
		String sNum = sc.next();
		
		char[] cNum = sNum.toCharArray();
		
		int sum =0;
		
		for(int i=0; i<cNum.length; i++) {
			sum += cNum[i]-'0';
		}
		System.out.println(sum);
		
	}

}
