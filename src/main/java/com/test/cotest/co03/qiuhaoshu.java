package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 좋은수 찾기
 * 주어진 N개의 수에서 다른 두수의 합으로 표현되는 수가 있다면 그수를 좋은수 라고 한다. 
 * N개의 수중 좋은수가 몇개인지 출력하기..
 * 
 * 1번째 줄에는 수의 개수 N(1<=N<=2000), 2번째 줄에는 N개 수의 값(A i)값이 주어진다. 
 * 
 * 
 */
public class qiuhaoshu {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	// 배열 Scanner 역할
		int N = Integer.parseInt(bf.readLine());
		
		// =count
		int result =0;
		long[] A = new long[N];
		
		// A[] 배열 for문 돌리기 전 선언해주는거 가틈
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<N; i++) {
			// A[i] = Integer.parseInt : 문자열을 int형으로 변환하는거
			// A[i]= Long.parseLong : 문자열을 long 으로 변환 
			// twoPointer02 클래스에서 Integer.parseInt로 변환하는거는 A[i]를 int 형으로 선언했기 때문 (여기선 long으로 선언) 
			A[i]= Long.parseLong(st.nextToken());
		}
		// 일단 오름차순 정렬
		Arrays.sort(A);
		
		for(int k=0; k<N; k++) {
			long find= A[k];
			int i=0;
			int j=N-1;
			
			while(i<j) {
				// 좋은수 찾는 값이 일치하는 경우에 두가지 경우의수 있음.
				// (1) 서로 다른 두수의 합이어야 함을 체크
				// (2) 
				if(A[i]+A[j] == find) {
					// 서로 다른 두수면 ok
					if(i != k && j != k) {
						result++;
						break;
					// else if 두 포인터 i,j가 k와 일치할때, 포인터 변경및 계속 수행하기..
					// 없어도 되는거 아닝가 ??아모르겠다 누가 설명좀..
					}else if(i==k) {
						i++;
					}else if(j==k) {
						j--;
					}
				// 두수 합이 find보다 작을경우 작은값 i증가 
				}else if (A[i]+A[j] < find){
					i++;
				// 두수 합이 find보다 클경우 큰값인 j 감소 
				}else {
					j--;
				}
			}
		}// for문 벗어나서
		System.out.println(result);
		bf.close();
				
	}

}
