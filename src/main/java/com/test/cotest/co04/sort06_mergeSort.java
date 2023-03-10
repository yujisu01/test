package com.test.cotest.co04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 병합정렬
 * N개의수가 주어졌을때 이를 '병합정렬'로 오름차순 프로그램 작성
 */
public class sort06_mergeSort {
	public static int[]A, tmp;
	public static long result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); 
		A = new int[N+1];
		tmp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		// 병합정렬 실행
		merge_sort(1,N);
		// 결과 for문 출력 
		for(int i=1; i<=N; i++) {
			bw.write(A[i] + " ");
		}
		bw.flush();
		bw.close();
	}
	private static void merge_sort(int s, int e) {
		// 여기서 e는 m값 (재귀함수므로 e-s값이 1보다 작아질때까지 계속 )
		if(e - s < 1) 
			return;
		//System.out.println(e-s);
			int m = s + (e-s) / 2;
			// 재귀함수 형태로 구현
			// 계속 분할하며 정렬
			merge_sort(s,m);			// 시작~중간
			merge_sort(m+1, e);			// 중간~종료
			
			// 임시 배열 tmp에 넣어서 저장
			for(int i=s; i<=e; i++) {
				tmp[i] = A[i]; 
			}
			int k = s;
			int index1 = s;
			int index2 = m + 1;
			
			// 오름차순 정렬 while문
			while(index1 <= m && index2 <= e) {
				if(tmp[index1] > tmp[index2]) {
					A[k] = tmp[index2];
					k++;
					index2++;
				}else {
					A[k] = tmp[index1];
					k++;
					index1++;
				}
			}
			// while문 종료
			
			// while문 오름차순정렬된대로 순서대로 출력하게 
			while(index1<=m) {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
			while(index2<=e) {
				A[k] = tmp[index2];
				k++;
				index2++;
			}
			// while문 종료
	}

}
