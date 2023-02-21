package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 좋은수 찾기
 * 주어진 N개의 수에서 다른 두수의 합으로 표현되는 수가 있다면 그수를 좋은수 라고 한다. 
 * N개의 수중 좋은수가 몇개인지 출력하기..
 * 
 * 1번째 줄에는 수의 개수 N(1<=N<=2000), 2번째 줄에는 N개 수의 값(A i)값이 주어진다. 
 * 
 * 
 */
public class qiuhaoshu {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	// 배열 Scanner 역할
		int N = Integer.parseInt(bf.readLine());
		int result =0;
		long[] A = new long[N];
		
		// A[] 배열 for문 돌리기 전 선언해주는거 가틈
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<N; i++) {
			// A[i] = Integer.parseInt : 문자열을 int형으로 변환하는거
			// A[i]= Long.parseLong : 문자열을 long 으로 변환 
			// twoPointer02 클래스에서 Integer.parseInt로 변환하는거는 A[i]를 int 형으로 선언했기 때문 (여기선 long으로 선언) 
			A[i]= Long.parseLong(st.nextToken());
		}
		
				
	}

}
