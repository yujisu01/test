package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 갑옷을 만드는 재료들은 각각 고유한 번호가 있음. 갑옷은 2개의 재료로 만드는데 2가지 재료의 고유한 번호를 합쳐
 * M(1<=M<=10,000,000)이 되면 갑옷이 만들어진다는 사실을 발견했다.
 * A는 자신이 만들고 있는 재료로 갑옷을 몇개나 만들수있는지 궁금해짐. A의 궁금증을 풀기위해
 * N(1<=N<=15,000)개의 재료와 M이 주어졌을때 몇개의 갑옷을 만들수 있는지 구하는 프로그램 작성..
 * >< ?????????????????????????????????????????????????
 */
public class twoPointer02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
	//	Scanner sc = new Scanner(System.in);
		// 배열 입력해야하니까 Scanner 기능처럼 BufferedReader를 사용해준다. 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 재료개수 입력N, 갑옷합번호M 입력
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		// 재료개수 만큼 A 배열 for문으로 돌리기 
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// Arrays.sort 를 이용해서 오름차순 정렬 
		Arrays.sort(A);
		
		// 본격적으로 준비..
		// count,i는 0부터, j는 제일 마지막인덱스이다. 
		// N=6이라고 하면, N개 갯수에서 -1을 해줘야 A[0]~A[5] 이런식으로 나옴 (예시)
		int count=0;
		int i=0;
		int j= N-1;
		
		while(i<j) {
			// 재료 합이 M보다 작을때 작은수(i) ++ 처리
			if (A[i] + A[j] < M) {
				i++;
			// 재료 합이 M보다 클때, 큰수(j) --처리
			}else if(A[i] + A[j] > M) {
				j--;
			// 조건에 만족할때 (M과 같을때)
			// 조건에 만족하므로 count 세주고, 포인터 (i,j) 둘다 이동함 i는 증가, j는 감소
			}else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
	}

}
