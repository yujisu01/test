package com.test.cotest.co07;

import java.util.Scanner;

/*
 * 유클리드 호제법
 * 두수의 최대공약수를 구하는 알고리즘. 
 * mod연산을 이해하고 있어야됨. (두값을 나눈 나머지를 구하는 연산) 10 MOD 4 = 2 (10%4)
 * 
 * (1) MOD연산 수행
 * (2) 앞단계에서 작은수와 MOD연산 결과값으로 MOD연산 수행
 * (3) 나머지가 0이 되는순간의 작은수를, 최대공약수로 선택
 * 
 * 최소공배수 구하는 거는
 * 두수 곱하고 최대공약수 나눠주면됨
 */
public class integer06_euclideanAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 두수 곱한거에 최대공약수 나누기
			int result = a*b / gcb(a,b);
			System.out.println(result);
		}
	}
	public static int gcb(int a, int b) {
		// 재귀함수 형태로 구현 
		// b가 0이면 a를 반환
		if(b==0) return a;
		else
			return gcb(b, a % b);
	}

}
