package com.test.cotest.co05;

import java.util.Scanner;

/*
 * 배열에서 K번째수 찾기
 * 크기가 N*N인 배열 A가 있다. 배열에 들어있는 수는 A[i][j] = i * j 이다. 
 * 이 수를 1차원 배열B에넣으면 B의 크기는 N * N 이된다. 오름차순 정렬했을때 B[k]를 구하라.
 * (배열 A와 B의 인덱스는 1부터 시작한다)
 * 
 * 1번째줄에 배열의크기 N이 주어진다. N은 10의 5제곱보다 작거나,같은 자연수다.
 * 2번째줄에 K가 주어진다.
 * 
 * 입력
 * 3
 * 7
 * 
 * 출력 
 * 6 
 */
public class search11_arraySearchK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long start= 1;
		long end = K;
		long answer =0;
		// 이진탐색 수행하기
		while(start<=end) {
			long mid = (start+end)/2;
			long cnt =0;
			//System.out.printf("start:"+start+"end:"+end+"\n");
			//System.out.println(mid); 
			// 중앙값보다 작은수 몇개인지 count하기
			for(int i=1; i<=N; i++) {
				//System.out.printf("cnt:"+cnt+",mid:"+mid+"\n");
				// Math.min(mid/i, N)은 mid값을 i로 나눈몫과 N중 작은 값을 반환
				// cnt에 값누적합
				cnt += Math.min(mid/i, N);
				
			}
			if(cnt < K) {
				start= mid+1;  
			}else {
				// 현재단계의 중앙값을 정답변수에 저장하기
				answer=mid; 
				end=mid-1;
			}
			
		}
		System.out.printf(K + "번째 수는 :" + answer); 
	}

}
