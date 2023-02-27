package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * 오큰수 구하기
 * 크기가 N인수열 A 가있다. 각 원소 A에 관련된 오큰수 NGE(i)를 구하려 한다.
 * 오큰수란? 오른쪽에 있으면서 Ai보다 큰수중 가장 왼쪽에 있는 수를 의미한다. 
 * 
 * 첫번째 줄에 수열의 크기, 2번쨰 줄에 수열의 원소 가 주어진다.
 * 
 * - 스택에 새로 들어오는 수가 top에 있는 수보다 크면 그 수가 오큰수가 된다
 * - 오큰수 구하고 수열에서 오큰수가 존재하지 않는 숫자에 -1 출력
 */
public class stack_rightBigNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열의 크기
		int N = Integer.parseInt(bf.readLine());	
		// N만큼 A[]배열 선언 
		int A[] = new int[N];
		// 정답 배열 선언
		int[] ans = new int[N];	
		
		// 스택이 채워져 있거나 A[i] > A[top]인경우 에는 pop한 인덱스를 이용하여 정답수열에 오큰수를 저장.
		// pop은 조건 만족하는 동안 계속 반복 
		// 현재 인덱스를 스택에 push하고 다음 인덱스로 넘어가기
		// 과정 1~3을 수열길이만큼 반복한 다음, 현재스택에 남아있는 인덱스에 -1을 저장한다
		
		String[] str = bf.readLine().split("  ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack<Integer>();
		
		// 스택 초기화 해주기 (처음에는 항상 스택이 비어있으므로, 최초값을 push해 초기화)
		myStack.push(0);
		
		for(int i=1; i<N; i++) {
			// 스택이 비어있지 않고, 현재 스택의 top인덱스가 가리키는 숫자가 top인덱스보다(peek) 클경우
			while(!myStack.isEmpty() && A[i] > A[myStack.peek()]) {
				ans[myStack.pop()] = A[i]; 	// 정답배열에 오큰수를 현재수열로 저장한다
			}
			myStack.push(i);		// 신규데이터push
		}
		//  반복문 다 돌고 나왔는데 스택이 비어있지 않다면 빌 떄까지
		while(!myStack.isEmpty()) { 
			// 스택에 쌓인 index에 -1을 넣음 
			ans[myStack.pop()] = -1;
		}
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<N; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.close();
		
		
		
		
		
		
	}

}
