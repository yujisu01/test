package com.test.cotest.co03;

import java.util.Scanner;

public class average {
	public static void main(String[] args) {
		// 자기점수중 최댓값을 고름.
		// 최댓값을 M이라 할때, 모든점수를   점수/M*100  으로 고침. (50/70*100)
		// 새로운 평균을 구하는 방법
		// 1번째줄엔 과목 개수 (ex:3개)
		// 2번째줄엔 현재 성적 점수입력
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i]= sc.nextInt();
		}
		long max=0;
		long sum=0;
		
		for(int i=0; i<N; i++) {
			if(A[i]>max) max=A[i];
			sum = sum+A[i];
		}
		System.out.println(sum*100/max/N);
		
		
	}

}
