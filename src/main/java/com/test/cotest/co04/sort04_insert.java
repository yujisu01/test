package com.test.cotest.co04;

import java.util.Scanner;

public class sort04_insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A[] = new int[N];
		int S[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i]= sc.nextInt();
		}
		// -----여기까진 선언 & 배열 저장 
		// -----여기부터 삽입정렬하기위해 for문 돌리기 (최솟값을 구하는 과정)
		// 현재범위에서 삽입위치 찾기
		for(int i=1; i<N; i++) {
			// 삽입이 들어가는 포인트,value값 설정
			int insert_point =i;
			int insert_value= A[i];
			for(int j=i-1; j>=0; j--) {
				if(A[j]<A[i]) {
					insert_point =j+1;
					break;
				}
				if(j==0) {
					insert_point=0;
				}
			}
			// 삽입을 위해 삽입위치에서 i까지 데이터를 한칸씩 뒤로 밀기
			for(int j=i; j>insert_point; j--) {
				A[j] = A[j-1];
			}
			A[insert_point] = insert_value;
		}
		// 삽입 위치에 현재 데이터 삽입하기 
		// 이 코드를 입력해줘야 0번인덱스부터 잘 출력이됨
		S[0] = A[0];
		
		// 합배열 구하기
		for(int i= 1; i<N; i++) {
			// A[i] 합해야 내가 입력한거 대로 합배열 출력됨
			S[i] = S[i-1]+A[i];
			System.out.println(S[i]);
			
		}
		// sum출력
		int sum=0;
		for(int i=0; i<N; i++) {
			sum =sum+S[i];
		}
		System.out.println(sum);
	}

}
