package com.test.cotest.co04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * K번째수 구하기
 * 오름차순 해서 k번째의 수 구하기 (퀵정렬을 이용한 문제)
 */
public class sort05_quick {
	public static void main(String[] args) throws IOException {
		// 선언 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 배열 돌리기전에 한번더 선언
		st = new StringTokenizer(br.readLine());
		int[] A= new int[N];
		// A[] 배열 저장 for문
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 퀵소트 실행하기 (A[]배열, 시작, 종료, K번째)
		quickSort(A,0,N-1,K-1);
		// K번쨰 데이터 실행
		System.out.println(A[K-1]);
	}//main여기까지 
	
		// 배열A, 시작, 종료, K
		public static void quickSort(int[] A, int S, int E, int K) {
			// 종료가 더 커야지
			if (S<E) {
				int pivot = partition(A,S,E);
				if(pivot==K) return;	// K번째수가 pivot이면 더이상 구할필요 없음 
				// 시작, 피벗-1, K
				// pivot의 왼쪽 부분에 K가 있으므로 왼쪽 (시작(S)~pivot-1)만 정렬 수행한다
				else if(K<pivot) quickSort(A, S, pivot-1, K);	
				// 피벗+1, 종료, K
				// pivot의 오른쪽부분에 K가 있으므로 오른쪽(pivot+1~종료(E))까지 정렬 수행한다.
				else quickSort(A, pivot+1, E, K);	
			
		}
	}
		public static int partition(int A[], int S, int E) {
			if(S+1 == E) {
				if(A[S] > A[E]) swap(A,S,E);
				return E;
			}
			int M = (S+E)/2;
			swap(A,S,M);
			int pivot=A[S];
			
			int i = S+1;
			int j = E;
			
			while(i<=j) {
				while(pivot < A[j] && j>0) { j--; }
				while(pivot > A[j] && i < A.length-1) { i++; }
				if(i<=j) { swap (A, i++, j--); }
		}
			// i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
			A[S] = A[j];
			A[j] = pivot;
			return j;
		}
		
		public static void swap(int[] A, int i, int j) {
			int temp =A[i];
			A[i] = A[j];
			A[i]= temp;
		}
}
