package com.test.cotest.co06;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 그리디 알고리즘: 현재 상태의 선택지중 최선의 선택을 하는 알고리즘. 
 * 수행과정
 * 1단계. 현재 상태에서 가장최선이라고 생각하는 해 선택
 * 2단계. 적절성검사: 현재선택한 해가 전체문제의 제약조건에 벗어나지 않는지 검사
 * 3단계. 해검사: 현재 선택한 해집합이 전체문제를 해결할수 있는지 검사. 전체문제 해결못한다면 1단계부터...ㅋ
 * 
 * 동전개수의 최솟값 구하기
 * A가 소유한 동전은 총 N종류이고, 각 동전의 개수가 많다. 동전을 적절히 사용해 그 가격의 합을 K로 만들려 한다.
 * 이때 필요한 동전개수의 최솟값을 구하는 프로그램
 * 
 * 1번째 줄에는 K원을 만드는데에 필요한 동전개수의 최솟값을 출력 (동전수/목표금액) (10 4200)
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * 
 * 전형적인 그리디 알고리즘 문제이다. 동전을 최소로 사용하여 K를 만드려면 가장 가격이 큰 돈부터 차례대로 사용
 * 
 * count 값을 구함
 * 
 */
public class greedy01_coinMin { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A[] = new int[N];
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt(); 
		}
		// 동전개수를 저장할 변수 count
		int count =0;
		// 일단 오름차순 정렬해줌 안하면 결과 엉뚱하게나옴
		Arrays.sort(A);
		
		// 가치가 큰 동전부터 사용하기위한 내림차순 for문 
		for(int i = N-1; i>=0; i--) {
			// 만약 현재 동전 가치가 K보다 작거나 같으면 구성에 추가 
			if(K >= A[i]) {
				count = count + (K / A[i]);  
				//System.out.printf("for문 속의 K (1)  : " + K + "\n");
				//K = K / A[i]; 4200, 4, 8, 4 
				K = K % A[i]; 
				//System.out.printf("for문 속의 K (2)  : " + K + "\n");
			}
		}
		System.out.printf("count : " + count + " ,K: " + K + "\n"); 
	}

}
