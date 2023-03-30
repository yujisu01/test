package com.test.cotest.co05;

import java.util.Scanner;

/*
 * 블루레이 만들기
 * 블루레이에는 총 N개의 레슨이 들어간다. 블루레이를 녹화할떄 레슨 순서가바뀌면 안된다
 * 즉 i,j번 레슨을 같은 블루레이에 녹화하려면 i와 j사이의 모든레슨도 같은 블루레이에 녹화해야 한다.
 * 제작개수는 최소한으로 해야됨. 
 * M개의 블루레이에 모든 기타레슨동영상 녹화함. 이떄 블루레이 크기는 최소, M개의 블루레이는 모두같은크기로 만들기
 * 각레슨 길이가 분단위로 주어질떄 가능한 블루레이의 크기중 최솟값을 구하는 프로그램 작성
 * 
 * 1번째줄에는 레슨수 N, 2번째줄에는 기타레슨길이가 레슨순서대로 분단위로 주어진다
 * 
 * 9 3 // 레슨수, 블루레이 개수
 * 1 2 3 4 5 6 7 8 9 
 * 
 * 출력
 * 17
 * 
 * 문제분석
 * - 블루레이 크기는 모두같고, 녹화순서가 바뀌면 안된다. -> 이진탐색 알고리즘 
 * 첫레슨부터 마지막 레슨까지 차례대로 저장하다 보면 지정한 블루레이 크기로 모든레슨을 저장할수 있는지 판단할수 있기떄문...
 * 모두 저장가능하다면 블루레이 크기를 줄이고, 저장할수 없다면 블루레이 크기 늘리기
 */
public class search10_binaryBlueray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A= new int[N];
		int start=0; int end=0;
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
			// 레슨 최댓값을 시작인덱스로 저장하기
			// 
			if(start < A[i]) start = A[i];
			end = end + A[i];
		}
		while(start<=end) {
			int mid = (start+end)/2;
			int sum=0;
			int count=0;
			// mid 값으로 모든 레슨 저장할수 있는지확인
			for(int i=0; i<N; i++) {
				if(sum + A[i] > mid) {
					count++;
					sum=0;
				}
				sum= sum+A[i];
			}
			// 탐색후 sum이 0 이 아니면 블루레이가 1개 더 필요하므로 count++
			if(sum != 0) count++;
			// 중간인덱스값으로 모든 레슨저장 불가능 하면
			if(count>M) start = mid + 1; 
			// 중간인덱스값으로 모든 레슨 저장가능하면
			else end = mid - 1;
		}
		System.out.println(start);
	}

}
//다시