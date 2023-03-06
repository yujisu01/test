package com.test.cotest.co04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sort02_bubbleSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData[] A = new mData[N];
		// A[i] 배열 
		for(int i=0; i<N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		// 오름차순 정렬 
		Arrays.sort(A);
		// 최댓값 선언
		int max= 0;
		
		for(int i=0; i<N; i++) {
			// 최댓값보다 A[i]의 인덱스가 클때
			if(max < A[i].index - i) max= A[i].index - i;
		}
		System.out.println(max + 1); // 최댓값보다 +1 
	}

}
	// 별도의 클래스 선언 
	// 데이터 표현
	class mData implements Comparable<mData> {
		int value; 
		int index;
		
		public mData(int value, int index) {
			// index, value를 가지며 value기준 오름차순 정렬 함수 Comparable 구현
			super();
			this.value = value;
			this.index = index;
		}
		 @Override
		 public int compareTo(mData o) {
			 return this.value - o.value;
		 }
	}
