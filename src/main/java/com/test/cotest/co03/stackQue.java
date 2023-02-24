package com.test.cotest.co03;
/*
 * 스택과 큐는 후입선출. 개념자체가 재귀함수 알고리즘원리와 일맥상통하다.
 * 
 * 스택으로 오름차순 수열 만들기. 
 * 임의의 수열을 스택에 넣었다가 출력하는 방식. 
 * 
 * 1번째줄에 수열의개수 N(1<=N<=100,000) 이 주어지고
 * 2번째줄에서 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어짐.
 * 
 * 오름차순 수열ㅇ르 만들기 위한 연산수열을 출력함. push연산은 +, pop연산은 - 로출력. 불가능할때는 NO 출력
 */

//import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class stackQue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		// 스택 선언
		Stack<Integer> stack = new Stack();
		StringBuffer bf = new StringBuffer();
		
		int num=1;
		boolean result= true;
		for(int i=0; i<A.length; i++) {
			int su= A[i]; 		// 현재 수열의수
			if(su>=num) {		// 현재 수열값>=오름차순 자연수: 값이 같아질떄까지 push()수행.
				while(su>=num) {
					stack.push(num++);
					bf.append("+ ");
					//System.out.println(stack.push(num++));
				}
				stack.pop();
				bf.append("- ");
				//System.out.println(stack.pop());
			}else {			// 현재수열값<오름차순자연수 :pop()을 수행해 수열원소를 꺼냄
				int n = stack.pop();
				
				if(su<n) {
			//		System.out.println("NO");
					result=false;
					break;
				}
				else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
	}

}
