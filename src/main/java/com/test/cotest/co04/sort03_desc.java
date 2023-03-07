package com.test.cotest.co04;

import java.util.Scanner;

/*
 * 내림차순 
 */

public class sort03_desc {
	public static void main(String[] args) {
// (1) 내림차순 정렬 방법 
//		Scanner sc = new Scanner(System.in);
//		int N= sc.nextInt();
//		int[] A= new int[N];
//		
//		for(int i=0; i<N; i++) {
//			A[i] = sc.nextInt();
//		}
//		for(int i=0; i<N-1;i++) {
//			for(int j=0; j<N-1; j++) {
//				if(A[j] < A[j+1]) {
//					int temp = A[j];
//					A[j] = A[j+1];
//					A[j+1] = temp;
//				}
//			}
//		}
//		for(int i=0; i<N; i++) {
//			System.out.println(A[i]);
//		}
		
		
/*
 *  (2) 입력값을 String으로 받은후 substring() 함수를 이용해 다시 int형으로 변경해 배열에 저장하여 
 *  	내림차순으로 정렬하는 방법
 */
		Scanner sc = new Scanner(System.in);
		// 선언해주기
		int n = sc.nextInt();
		String str = sc.next();
		int A[] = new int[str.length()];
		
		// A[] 배열 저장할떄 str.substring() 사용
		// str길이만큼 반복
		for(int i=0; i<str.length(); i++) {
			// A[i] = Integer.parseInt(str.substring(i, i+1));
			// int startindex와, int endindex 리턴
			A[i] = Integer.parseInt(str.substring(i, i+1)); 
		}
		// 현재 범위에서 max값 찾기 
		for(int i=0; i<str.length(); i++) {
			int max= i;		
			for(int j = i+1; j<str.length(); j++) {
				// j가 max 값 보다 크면 max에 j대입 그리고 swap 이것두 가능
				if(A[j] > A[max]) max = j;
				int temp = A[i];
				A[i]=A[max];
				A[max] = temp;
			}
			// 현재 i의 값과 max값중 max값이 더 크면 swap 
			// 이것도 가능
//			if(A[i] < A[max]) {
//				int temp = A[i];
//				A[i]=A[max];
//				A[max] = temp;
//			} 
			
		}
		// 내림차순 정렬된 A[]배열출력
		for(int i=0; i<str.length(); i++) {
			System.out.print(A[i]);
		}
	}
	
}
