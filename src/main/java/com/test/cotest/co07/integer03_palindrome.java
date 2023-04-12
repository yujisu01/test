package com.test.cotest.co07;

import java.util.Scanner;

/*
 * 소수와 팰린드롬 수중에서 최솟값 찾기
 * 팰린드롬수 양방향으로 읽어도 같은수 (ex: 121, 1221, 12321..)
 * 방법은 해당수를 문자열로 변환한후 문자열을 뒤집어서 원래문자열과 같은지 확인법,
 * 해당수를 10으로 나눈 나머지와 몫을 이용하여 뒤집은수 구하는방법..
 * 
 * (1)에라토스테네스 체 이용해서 일단 모든 소수를 구해서
 * (2)이 소수들 집합에서 n보다 크거나 같으면서
 * (3)팰린드롬수인거 찾아내기 
 * 
 * N부터 오름차순으로 시작해서 최초로 팰린드롬 수가 나오면 프로그램 종료
 *  
 */
public class integer03_palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[100001];
		
		for(int i=2; i< A.length; i++) {
			A[i] = i;
		}
		for(int i=2; i<Math.sqrt(A.length); i++) {
			if(A[i] == 0) { 
				continue;
			}
			for(int j=i+i; j<A.length; j=j+i) {
				A[j] = 0;
			}
		}
		int i = N;
		
		while(true) {
			if(A[i] != 0) {
				int result= A[i];
				if(palindrome(result)) {
					System.out.println(result);
					break; 
				}
			}
			i++;
		}
	}
	private static boolean palindrome(int result) {
		char temp[] = String.valueOf(result).toCharArray();
		int s = 0;
		int e = temp.length-1;
		while(s<e) {
			if(temp[s] != temp[e]) return false; 
			s++;
			e--;
		}
		return true;
	}

}
