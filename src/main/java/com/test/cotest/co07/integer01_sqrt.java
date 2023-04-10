package com.test.cotest.co07;

import java.util.Scanner;

/*
 * 정수론 에서 소수부분 배워보기
 * 소수구하기
 * 자신보다 작은 2개의 자연수를 곱해 만들수 없는 1보다 큰 자연수는 소수이다.
 * 이와같은 의미로 1과 자기자신외에 약수가 없음
 * 
 * 에라토스테네스의 체
 * (1)구하고자 하는 소수의 범위만큼 1차원배열생성
 * (2)2부터 시작하고, 현재 숫자가 지워지지않을때는 현재 선택된 숫자의 배수에 해당하는 수를 배열에서 끝까지 탐색하면서 지운다
 * 	이때 처음으로 선택된 숫자는 지우지 않는다
 * (3)배열의 끝까지 (2)를 반복한후 배열에서 남아있는 모든수 출력함
 * 
 * 이걸 이용해서 M이상 N이하의 소수를 모두 출력하는 프로그램 작성
 * 1번째줄에 자연수 M,N 
 * 
 * ex입력
 * 3 16
 * 출력
 * 3
 * 5
 * 7
 * 11
 * 13
 */
public class integer01_sqrt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] A = new int[N+1];
		// 배열 입력 X, 소수인 배열만 나열
		// 1은 소수가 아니므로 2부터 시작
		for(int i=2; i<=N; i++) {
			A[i] = i;
		}
	}

}
