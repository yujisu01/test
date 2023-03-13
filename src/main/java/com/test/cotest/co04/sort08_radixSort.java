package com.test.cotest.co04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * radixSort 기수정렬 : 값을 비교하지 않는 특이한 정렬이다. 기수 정려은 값을 놓고 비교할 자릿수를 정한다음
 *  해당 자릿수만 비교를 한다. 기수 정렬 시간복잡도는 O(kn)
 *  예를들어, 234, 123을 비교한다면 2와1, 3과2, 4와3을 비교한다. 
 *  
 *  기수정렬로 오름차순 정렬 프로그램 작성 
 */
public class sort08_radixSort {
	// main함수 외에 radix_sort 함수 존재하므로 A[], result 전역함수 선언
	public static int[] A;
	public static long result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N= Integer.parseInt(br.readLine());
		int A[] = new int[N];
		// A[i] 배열 for문 선언 
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		// 기수정렬 함수 실행 
		radix_sort(A,5);
		// 기수정렬 함수 출력 for문
		for(int i=0; i<N; i++) {
			bw.write(A[i] + " ");
		}
		// bw close
		bw.flush();
		bw.close();
	}
	// 여기까지 main 함수
	
	// 여기부터 radix_sort() 실행 
	// 일반적 기수정렬은 우선순위 큐를 사용해 비교적 간단하게 구현하는 방법이 있지만, 시간복잡도를 느리게 하므로
	// 구간합을 이용하는 방법으로 구현
	// bucket 배열의 정확한 의미와 bucket 배열로 현재자리를 기준으로 정렬하는 방법
	public static void radix_sort(int[] A, int max_size) {
		
	}

}
