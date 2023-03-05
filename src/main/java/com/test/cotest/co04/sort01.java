package com.test.cotest.co04;

import java.util.Scanner;

/*
 * n개의 숫자가 주어졌을떄 오름차순으로 정렬. sort() 이용하지 않고 정렬해보기 
 * 1번쨰 줄에 수의 개수 n(1<=n<=1000), 2번쨰 줄부터 n개의 줄에 숫자가 주어진다.
 * ㅂㅓ블정렬 알고리즘 사용 (인접한거)
 */
public class sort01 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		// A[i] 배열 입력 
		for(int i=0; i<N; i++) {
			A[i]=sc.nextInt();
		}
		//이중 for문 
		// N-1까지 하는이유 두수 비교하니까 0부터 N-1 까지 해도됨 
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				// 현재 A배열 값보다 1칸 오른쪽 배열의 값이 더작으면 두수 바꾸기
				if(A[j] > A[j+1]) {
					// temp에 임시보관 해서 반복
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				} 
			}
		}
		// (2) 이게 그냥 Arrays.sort() 사용해서 오름차순 정렬한거 
		//Arrays.sort(A);
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
	}						

}
