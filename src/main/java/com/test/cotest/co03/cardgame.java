package com.test.cotest.co03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 카드게임
 * Que 이해하기 
 * 1에서 N까지의 번호가 있다. 1이 위, N이 제일아래. 
 * 가장위에 있는 카드를 버리고, 그다음 가장위에 있는 카드를 가장 아래에 있는 카드밑으로 옮김
 * 그래서 마지막에 남는 숫자 구하기
 */

public class cardgame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> que= new LinkedList<Integer>();
		int N= sc.nextInt();	// N만큼 입력받는다.
		
		// for문 돌려서 카드를 큐에 저장한다. 
		// i는 1부터 시작해야됨. 
		for(int i=1; i<=N; i++) {	
			que.add(i);
		}
		while(que.size() > 1) {	// 카드가 하나남을떄까지
			que.poll();			// 맨위 카드를 버리고
			que.add(que.poll());	// 맨위 카드를 가장 아래 카드로 옮김.
		}
		System.out.println(que.poll());	// 마지막으로 남은 카드 출력하기
	}

}
