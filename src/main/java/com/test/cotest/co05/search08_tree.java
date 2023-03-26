package com.test.cotest.co05;
/*
 * BFS를 이용하여 트리지름 구하기 
 * 트리를 구성하는 노드중 두 노드사이의 거리가 가장긴것을 말한다. 
 * 노드개수를 입력하고 -1이 종료하는거임
 * 그래프를 인접리스트로 저장하면 (노드,가중치) 이렇게 표현 ..
 * 
 * BFS로 표현하는 이유?
 *  - BFS느 탐색을 시작하는 노드에서부터 거리가 가까운 노드부터 탐색하므로 큐에서 가장 마지막에 나오는 노드는
 *    시작노드에서 가장 멀리 떨어진 노드이므로
 *  - 가장 먼노드에서 다시 BFS를 실행하여 트리의 지름을 찾을수 있다. 
 *    가장 먼노드를 찾은ㅇ 이후 이노드를 시작으로 다시 BFS를 실행하여 가장 먼노드를 찾으면 이 두 노드 사이의 거리가 트리 지름됨
 *    
 * Edge 클래스를 사용하여 간선 정보를 저장하면 간선의 가중치를 비교하여 거리를 계산하는게 용이해진다. ..
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class search08_tree {
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList< Edge>();
		}
		for(int i=0; i<N; i++) {
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E==-1) break;
				int V = sc.nextInt();
				A[S].add(new Edge(E,V));
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		// BFS() 임의의 점을 시작으로 실행
		BFS(1); 
		int max = 1;
		
		// 2부터 시작 
		// distance 배열에서 가장 큰값으로 다시 시작점 설정
		for(int i =2; i<=N; i++) {
			if(distance[max] < distance[i]) max = i;
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		// BFS() 새 시작점 (max)으로 실행
		BFS(max);
		Arrays.sort(distance); 	// 정렬
		System.out.println(distance[N]);
	}
	public static void BFS(int index) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(index);
		visited[index] = true;
		while(!q.isEmpty()) {
			int now_node = q.poll();
			for(Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					q.add(e);
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}
}
// 완전 밖에 써야되구나;
	class Edge{
		int e;
		int value;
		public Edge(int e, int value) {
			this.e=e;
			this.value = value;
	}

}
