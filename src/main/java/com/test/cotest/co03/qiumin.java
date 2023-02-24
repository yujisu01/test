package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.xml.soap.Node;

/*
 * 플래 ㅅ;
 * 
 * 최솟값 찾기..
 * 1번째줄에 N(1<=L<=5,000,000),
 * 2번째줄에 N개의수 A가 주어진다 (-109<=A<=109)
 * 
 * addFirst(), removeFirst() 함수로 삽입,삭제 역할을 한다.
 * addLast(), removeLast() 마찬가지로 삽입,삭제 역할. 덱을 이용한 정렬효과
 */
public class qiumin {
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		int N = Integer.parseInt(st.nextToken());		// 데이터 개수
		int L = Integer.parseInt(st.nextToken());		// 최솟값을 구하는 범위, 슬라이딩 윈도우의 크기
		st = new StringTokenizer(br.readLine());
		
		// LinkedList<> : 각 노드가 데이터와 포인터를 가지고 한줄로 연결되어 있는 방식의 자료구조
		// 덱(데크)사용 큐Node로 삽입/삭제 가능 
		Deque<Node> myDeque = new LinkedList<Node>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 새로운값이 들어올때마다 정렬대신 현재수보다 큰 값을 덱에서 제거해 시간복잡도 줄임
			while(!myDeque.isEmpty() && myDeque.getLast().value > now) {
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(now,i));
			
			//범위에서 벗어난 값은 덱에서 제거
			//슬라이딩윈도우(L)의 범위를 벗어난 값은 덱에서 제거한다.
			
			// 이거 나한테 설명좀해주실분
			if(myDeque.getFirst().index <= i - L) {
				System.out.println("myDeque.getFirst().index=" + myDeque.getFirst().index);
				System.out.print("i=" + i);
				System.out.println(",L=" + L);
				
				myDeque.removeFirst();
			} 
			bw.write(myDeque.getFirst().value + " ");
		}
//		bw.newLine();
		// 남아있는 데이터 모두 출력
		bw.flush();
		// 스트림 닫기
		bw.close();
	}
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value=value;
			this.index=index;
		}
	}
}


/*
 * N(데이터 개수), L(최솟값을 구하는범위) 입력받기
 * Deque<Node> mydeque (데이터를 담을 덱 자료구조 선언)
 * 
 * for문으로 데이터개수 N만큼 반복 한다.
 *  {
 *  	now(헌재 데이터값)
 *  	덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거하기
 *  	덱의 마지막위치에 now값 저장하기
 *  	덱의 첫번째위치에서부터 L의 범위를 벗어난 (now index-L <= index) 덱에서 제거하기
 *  	덱의 1번째 데이터 출력하기
 *  }
 *  
 *  덱에 저장할 노드클래스 별도생성하기
 *  노드 클래스에서는 index(자신의위치), value(자신의 값) 담기.
 *  
 * (GG)모르겠어요
 */

/*
 * 아 알겠다 나 왜 몰랐지
 * 근데 이걸 코드로 어케써
 * ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
 * 
 */
