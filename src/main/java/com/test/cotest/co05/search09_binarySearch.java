package com.test.cotest.co05;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 이진탐색. 데이터가 정렬되있는 상태에서 원하는' 값을 찾아내는' 알고리즘이다. 
 * 대상데이터의 중앙값과 , 찾고자 하는 값을 비교해서 데이터 크기를 절반씩 줄이면서 대상을 찾음
 * 이진탐색은 정렬데이터에서 원하는 데이터를 탐색할때 사용하는 가장 일반적인 알고리즘이다
 * 
 * 이진탐색과정
 * 1. 현재 데이터셋의 중앙값 선택
 * 2. 중앙값>타깃데이터 일때 중앙값 기준으로 왼쪽데이터셋을 선택한다 
 * 3. 중앙값<타깃데이터 일때 중앙값 기준으로 오른쪽데이터셋을 선택한다 
 * 4. 과정 (1)~(3) 반복하다가 중앙값==타깃데이터일때 탐색을 종료한다.
 * 
 * 원하는 정수찾기
 * N개의 정수가 주어졌을떄 이안에 X라는 정수가 존재하는지 찾는 프로그램
 * 1번째줄에 데이터개수N개 입력받기, 2번째줄에 N개의 정수들, 3번째줄에 찾아야할 숫자개수입력, 4번째줄에 M개의 수들이 주어짐 .(?)
 * 
 * 5
 * 4 1 5 2 3
 * 5 
 * 1 3 7 9 5
 * 입력시
 * 
 * 1
 * 1
 * 0
 * 0
 * 1 
 * 출력
 * 41523 중에서 13795 정수가 있는지
 */
public class search09_binarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 변수선언에 따른 문제점..
		//int M = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		} 
		// A배열 오름차순 정렬
		Arrays.sort(A);
		int M = sc.nextInt();
		// for문 M개수만큼 돌리기
		for(int i=0; i<M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			// 이진탐색 시작 (시작인덱스 start(0), 종료인덱스(A배열 -1)
			int start=0;
			int end= A.length-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				int midV = A[mid];
				
				// 중간값이 타겟값보다 크면 왼쪽 탐색
				if(midV > target) {
					end = mid-1;
				}else if(midV < target) {
					start = mid+1;
				// 찾았으면 반복문 종료
				}else {
					find = true;
					break;
				} 
			}
			if(find) {
				System.out.println("1"); 
			}else { 
				System.out.println("0");
			} 
		}
	}

}


/*
 * 변수선언순서에 따른 이슈
 * Arrays.sort(A) A배열 정렬후 int M을 선언해줘야 한다.
 * int N선언하고, int M을 선언하여 출력하면 결과가 그냥 한줄로 나온다.
 * 
 * (정상적으로 선언) M개의 값을 입력받을 때마다 A를 정렬하고 이진탐색을 수행 (->원하는값 출력)
 * (N,M 동시선언) N,M값을 먼저 입력받고 그다음배열 A를 입력받아 정렬한후 M개의 값을 입력받아 이진탐색 수행
 * 한번만 A를 정렬하고 M개의 값을 입력받을 때마다 이진탐색 수행함. (->원하는출력값 안나옴)
 * 배열 A선언하기전에 N과 M값을 입력받으면, 배열 A의 크기를 알수없음 (->오류발생 가능성)
 * 
 * 얘가 어떻게 작동하는지 잘 알어야 이런 이슈가 발생하지 않는다
 * 
 * 
 */
