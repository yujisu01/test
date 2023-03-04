package com.test.cotest.co03;
/*
 * 절댓값 힙 구현하기 . 절댓값 힙은 다음과 같은 연산을 지원한다
 * - 배열에 정수 x을 넣는다 (x != 0)
 * - 배열에서 절댓값이 가장작은 값을 출력한후 그값을 제거한다. 절댓값이 가장 작은 값이 여러개일 경우에는 그중
 *   가장 작은수를 출력하고, 그값을 배열에서 제거함.
 *   절댓값이 같을땐 음수를 우선 출력함. 
 *  (1) x=0일때, 큐가 비어있을떄는 0을 출력하고, 비어있지 않을때는 절댓ㅂ값이 최소인값을 출력. 절댓값 같으면 음수 우선출력
 *  (2) x!=0 일때, add로 큐에 새로운값 추가하고, 우선순위 큐 정렬기준으로 자동정령.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class absHip {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request==0) {
				if(q.isEmpty()) System.out.println("0");
				else System.out.println(q.poll());
			}else { 
				q.add(request);
			}
		} 
	}

}
