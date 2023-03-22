package com.test.cotest.co05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 너비우선탐색(BFS: breadth first search) 
 * 시작노드에서 출발해, 시작노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색한다
 * 특징: FIFO탐색, 큐 자료구조(Queue) 
 * 선입선출 방식이여서 큐를 이용한다. 
 * 
 * BFS도 DFS와 마찬가지로 한번 방문했떤 노드는 다시 재방문 하지 않음. 그래서 방문한 노드를 체크하기 위한 배열이 필요함
 * 그래프를 인접리스트로 표현하는것 역시 DFS와 동일. 
 * 
  (1) 그래프를 인접리스트로 표현하는게 무슨 뜻이냐?
   ex 
   A --- B --- C
   |     |     |
   D --- E --- F
   이런식으로 있는걸
   
    A: B, D
	B: A, C, E
	C: B, F
	D: A, E
	E: B, D, F
	F: C, E
	이렇게 표현하는것
	
   (2) 여기서 그럼 BFS의 원리는 어떻게 되느냐?
   1. BFS를 시작할 노드를 정한후 사용할 자료구조 초기화함: 이때 스택이 아닌 큐(선입선출) 이용함
   2. 큐에서 노드를 꺼낸후 꺼낸노드의 인접노드를 다시 큐에 삽입함 :이건 정확히 이해가 안되므로 코드보면서 이해하기..
   3. 큐 자료구조에 값이 없을때까지 반복하기. 
   
   * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램 작성
   * (단, 방문할수 있는 노드가 여러개일 경우에는 노드번호가 작은것을 먼저 방문하고 더이상 방문할수 있는 노드가 없을때 종료)
   * 
   * 노드개수, 엣지개수, 시작점을 입력하고 출력결과의 첫번째줄에는 DFS수행결과, 두번쨰줄에는 BFS수행결과를 출력

 */
public class search06_BFS {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M =sc.nextInt();
		int start =sc.nextInt();
		A= new ArrayList[N+1];
		
		// (1) for문 N개 개수만큼 A 인접리스트 각 ArrayList 초기화 
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// (2) for문 M개 개수만큼 A 인접리스트 그래프 데이터 저장 (엣지)
		// 엣지를 사용하여 노드들간 관계표현 (엣지연결)
		for(int i=0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		// 위 문제에서 방문할수 있는 노드가 여러개일 경우 노드번호가 작은걸 먼저 방문하라고 했음
		// (3) for문, 번호가 작은것을 먼저 방문하기 위해 정렬하기
		for(int i=1; i<=N; i++) {
			// List인터페이스를 구현한 컬렉션(List,ArrayList등)을 정렬하는 메소드임. 
			// 오름차순 정렬이 기본 (근데 Comparator 이용해서 내림차순 정렬도 가능)
			Collections.sort(A[i]);
		}
		
		visited = new boolean[N+1];	// 방문 배열 초기화 해서 DFS 맞이함
		DFS(start);
		System.out.println();
		visited = new boolean[N+1];	// 방문 배열 초기화 해서 BFS 맞이
		BFS(start);
		System.out.println();
		
	}
	// DFS 구현
	public static void DFS(int node) {
		
	}
	// BFS 구현
	public static void BFS(int node) {
		
	}

}
