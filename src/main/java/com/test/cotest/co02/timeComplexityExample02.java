package com.test.cotest.co02;
// 버블정렬(O(n의제곱), 병합정렬(O(nlogn)
public class timeComplexityExample02 {
	public static void main(String[] args) {
		// n개의 수가 주어졌을때 오름차순 정렬
		// 1번째줄에 수의개수 N(1<=N<=1000000), 
		// 2번쨰줄부터는 N개의 줄에 숫자 주어짐
		// 이수는 절댓값이 1000000보다 작거나 같은정수다.
		
		int N = 1000000;
		int cnt =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.println("연산횟수:"+cnt++);
				
			}
		}
	}
}
