package com.test.cotest.co06;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 수를 묶어서 최댓값 만들기
 * 
 * 길이가 N인 수열이 주어질떄 수열의 합구하기 근데 수열의 합을 구하기 전에 먼저 수열안에 있는 임의의 두수를 묶으려 한다
 * 단 같은위치에 있는 수 (자기자신)못 묶음.
 * 묶인 두수는 수열의 합을 구할떄 서로 곱한후 계산함
 * 수열의 모든수는 각각 한번씩만 묶을수 있다. 주어진 수열의 각 수를 적절히 묶어서 그 합을 최대로 만드는 프로그램 작성하기
 * 
 * 입력
 * 9 //수의개수
 * -1
 * -8
 * 2
 * 1
 * 3
 * 6
 * -5
 * 0
 * 1
 * 출력
 * 62
 * 
 * 
 */
public class greedy03_maxShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 우선순위큐에서 양수는 내림차순 정렬
		PriorityQueue<Integer> plsQ= new PriorityQueue<Integer>(Collections.reverseOrder());
		// 우선순위큐 - 음수 
		PriorityQueue<Integer> minQ= new PriorityQueue<Integer>();
		// 0과 1인 수 선언
		int one =0; 
		int zero =0;
		
		// for문 N만큼 반복 (데이터를 4개 그룹에 분리저장)
		// 1보다 큰 양수그룹, 1인그룹, 0인그룹, 1보다 작은 음수그룹
		for(int i=0; i<N; i++) {
			int data = sc.nextInt();
			if(1<data) {
				plsQ.add(data);
			}else if(1==data) {
				one++;
			}else if(0==data) { 
				zero++;
			}else {
				minQ.add(data);
			}
		}
		int sum = 0;
		
		// 양수 처리하기
		while(plsQ.size() > 1) { 
			// 두수 뽑아서 
			int first = plsQ.remove();
			int second = plsQ.remove();
			sum += first*second;
			System.out.printf("first:" + first + ", second :" + second + ", sum:" + sum + "\n"); 
		}
		if(!plsQ.isEmpty()) {
			sum += plsQ.remove();
		}
		System.out.printf("plsQ sum:" + sum + "\n");
		
		// 움수 처리하기 
		while(minQ.size() > 1) {
			int first = minQ.remove();
			int second = minQ.remove();
			sum += first*second;
		}
		if(!minQ.isEmpty()) {
			if(zero==0) { 
				sum += minQ.remove();
			}
		}
		System.out.printf("minQ sum:" + sum + "\n");
		// 1처리
		sum += one;  
		System.out.println(sum); 
	}
}
