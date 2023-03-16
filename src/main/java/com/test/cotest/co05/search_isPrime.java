package com.test.cotest.co05;

import java.util.Scanner;

/*
 * 신기한 소수찾기
 * 7331을 예로 들자. 7331은 733도 소수, 73도 소수, 7도 소수다.
 * 즉 외쪽부터 1자리,2자리,3자리 4자릿수 모두 소수다. 이런 소수를 신기한소수라고 하자
 * 숫자 N이 주어졌을떄 (자릿수) N의 자리숫자중 신기한 소수 모두 찾기 
 * ㅡㅡ
 */
public class search_isPrime {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	static void DFS(int number, int jarisu) {
		if(jarisu==N) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for(int i=1; i<10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			if(isPrime(number * 10 + i)) {
				DFS(number * 10 + i, jarisu + 1);
			}
		}
	}
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) 
			if(num % i == 0) 
				return false;
			return true;
	}
}
