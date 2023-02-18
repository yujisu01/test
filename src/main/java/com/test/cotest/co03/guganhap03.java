package com.test.cotest.co03;

import java.util.Scanner;

public class guganhap03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();	// 수열 개수
		int M = sc.nextInt();	// 나눠떨어져야 하는수
		long[] S= new long[N];	// 합배열
		long[] C= new long[M];	// 같은나머지의 인덱스 카운트 배열
		
		long answer =0;
		S[0] = sc.nextInt();
		
		// for문으로 수열합 배열 만들기 
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + sc.nextInt();
		}
		// 합 배열의 모든 값에 % 연산 수행
		for(int i=0; i<M; i++) {
			int reminder = (int) (S[i]%M);
			
			// 0 ~ i 구간합자체가 0이면 정답에 더하기
			if(reminder ==0) answer ++;
			// 나머지가 같은 인덱스 개수 카운팅하기
			C[reminder]++;
		}
		for(int i=0; i<M; i++) {
			if(C[i] > 1) {
				// 나머지가 같은 인덱스중 2개를 뽑는 경우의 수 더하기 
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}
