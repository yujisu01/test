package com.test.cotest;

import java.util.Scanner;

public class temp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long start= 1;
		long end = K;
		long answer =0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			long midMinCnt =0;
			for(int i=1; i<=N; i++) {
				midMinCnt += Math.min(mid/i, N);
				
			}
			if(midMinCnt < K) {
				start= mid+1;  
			}else {
				answer=mid; 
				end=mid-1;
			}
			
		}
		System.out.printf(K + "번째 수는 :" + answer); 
	}

}