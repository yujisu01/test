package com.test.cotest.co06;
/*
 * 회의실 배정하기
 * 1개의 회의실에서 N개의 회의를 진행하기위해 회의실 사용표를 만드려고 한다
 * 각 회의마다 시작시간,끝나는시간이 주어질때 회의시간이 겹치지않으면서 회의를 가장 많이 진행하려면 최대 몇번까지 할수 있는지
 * 알아보자. 
 * (단 회의를 시작하면 중단할수 없고, 회의를 끝내는것과 동시에 다음회의 시작이 바로 가능하다)
 * 회의 시작시간과 끝나는시간이 같을수도 있다. 이떄는 시작하자마자 끝나는걸로 생각
 * 
 * 1번째 줄에 회의개수 
 * 2번째줄부터 N+1 줄까지 각 회의 시작시간과 끝시간이 주어짐. 
 * 
 * 만약 종료시간이 같으면 시작시간이 빠른순으로 정렬하는 기준이 포함되야 ㅏ한다..
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class greedy04_huiyishi {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 배열 입력받기 
		// int[] A 면 정수 하나만 입력받을수있음
		int[][] A= new int[N][2];
		
		// N개의 행을 가지는 2차원배열 A를 생성하고, 사용자로부터 N개의 두개 정수값을 받아서 A배열 행에 저장
		for(int i=0; i<N; i++) {
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}
		
		// 2차원 배열 A를 종료시간을 기준으로 오름차순으로 정렬함
		// 오버라이딩 이유? Comparator인터페이스를 이용하여 종료시간을 기준으로 오름차순 할수 있도록 오버라이딩
		// Comparator인터페이스는 compare메서드를 구현해야 하며, 두개의 인자를 받아 비교한후
		// int값을 반환해야 한다.
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] S, int[] E) {
				// 종료시간이(S[1],E[1] 같으면
				// 시작시간을 비교하여 오름차순 정렬
				if(S[1] == E[1]) {
					return S[0] - E[0];
				}
				// 아니면 그냥 종료시간으로 비교
				return S[1] - E[1];
			}
		});
		
		int count =0;
		// 회의 종료시간을 end변수에 저장. 
		// 0이 아닌 -1 이유? 만약 0으로 초기화한다면 첫번째 회의 종료시간이 0이상이면 선택가능한 회의라 판단함
		// 하지만 첫번째회의 종료시간이 0보다 작은경우, 이전회의가 없었다는 가정하에 선택가능한 회의라 판단할수 있으므로
		// 결과가 잘못나올수 있음. 따라서 -1로 하는 이유는 선택가능한 회의가 없다는 의미로 초기화.
		// 첫번째 회의종료시간을 이전회의 종료시간으로 판단하지 않도록
		int end = -1;	
		
		for(int i=0; i<N; i++) {
			// 겹치지않는 다음회의가 나온경우 (시작시간이 종료시간보다 많)
			if(A[i][0] >= end) {
				// 종료시간 업데이트하기
				end= A[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
