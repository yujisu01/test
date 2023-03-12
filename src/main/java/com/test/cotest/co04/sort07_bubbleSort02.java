package com.test.cotest.co04;
/*
 * 버블소트+병합정렬 
 * 버블정렬은 인접한 두수를 바꾸면서 정렬, 병합정렬은 두 인덱스로 나누면서 정렬
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sort07_bubbleSort02 {
	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		result =0;
		merge_sort(1,N);
		System.out.println(result);
	}
	
	private static void merge_sort(int s, int e) {
		if(e-s<1)
			return;
		int m = s + (e-s)/2;
		
		merge_sort(s,m);
		merge_sort(m+1,e);
		for(int i=s; i<=e; i++) {
			tmp[i] = A[i];
		}
		int k=s;
		int index1 = s;
		int index2 = m+1;
		
		// 오름차순 정렬
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] > tmp[index2]) {
				System.out.printf("셈 이전 result값 :" + result + "\n");
				// 뒤쪽데이터 값이 작은경우 result업데이트 
				// swap 개수 세기
				// 현재 남아있는 앞쪽 데이터 개수만큼 결과값을 더함 
				result = result + index2 - k; 
				System.out.printf("index2 = " + index2 + ", " + "k = " + k + "\n");
				A[k] = tmp[index2];
				k++;
				index2++;
			}else {
				A[k] = tmp[index1];
				k++;
				index1++;
			} 
		}
		// 순서대로 출력되게
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
