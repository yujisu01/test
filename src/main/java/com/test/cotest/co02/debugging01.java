package com.test.cotest.co02;

import java.util.Scanner;

public class debugging01 {
	// todo배열에서 주어진범위의 합 구하기
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase= sc.nextInt();
		//int answer=0;
		
		int A[]= new int[100000];
		int S[]= new int[100000];
		
		//System.out.println("아 ㅋㅋ");
		for(int i=1; i<10000; i++) {
			A[i] = (int)(Math.random() * Integer.MAX_VALUE);
			S[i] = S[i-1] + A[i];
			//System.out.println(answer);
		}
		for(int t=1; t<testcase; t++) {
			
			int query= sc.nextInt();
			
			for(int i=0; i<query; i++) {
				int answer =0;
				int start= sc.nextInt();
				int end=sc.nextInt();
				answer += S[end] - S[start-1];
				System.out.println("testcase:" + t + ",answer:" +answer);
				System.out.println(answer);
				System.out.println(S[end]);
				System.out.println(S[start]);
			}
		}
	}
}
