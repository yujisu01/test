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
		A = new ArrayList[N+1];	// 노드인덱스 1부터 시작 
		
		// for문 인접리스트 방식으로 트리구조 저장할 배열
		// 각 노드마다 연결된 간선들의 목록을 저장하기위해 edge클래스 사용 
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList< Edge>();
		}
		// 트리의 간선정보를 읽어서 인접리스트 생성하는 코드 
		// 트리 각노드에 대해 반복,
		for(int i=0; i<N; i++) {
			int S = sc.nextInt();
			// 입력으로 주어지는 인접한 노드들의 정보를 다읽을때까지 반복.
			// E 인접한 노드번호, V 가중치
			while(true) {
				int E = sc.nextInt();
				if(E==-1) break;
				int V = sc.nextInt();
				// A[S] 리스트에 엣지객체를 생성하여 추가함. 
				// 이렇게 하면 S와 E노드사이에 가중치 V를 갖는 간선이 인접리스트에 추가
				A[S].add(new Edge(E,V));
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		// BFS() 임의의 점을 시작으로 실행
		// 두번실행? 먼저 어떤한 정점에서 가장 먼 정점을 찾아야 되므로,
		// 이를 위해 첫번째실행에서 구할수있다....
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
		Arrays.sort(distance); 	// distance 배열 정렬
		System.out.println(distance[N]);	// 배열 가장 마지막값이 트리의 지름이 된다.
	}
	public static void BFS(int index) {
		Queue<Integer> q = new LinkedList<Integer>();
		// 시작노드를 큐에넣고, visited배열에 방문여부 저장
		q.add(index);
		visited[index] = true;
		
		// while문 : 큐 빌때까지 실행
		while(!q.isEmpty()) {
			int now_node = q.poll();
			for(Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				// 아직 방문하지 않은 노드라면 큐에넣고, visited[]에도 방문 저장
				if(!visited[e]) {
					visited[e] = true;
					q.add(e);
					// distance배열에 거리(가중치) 정보저장함
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}
}
// 완전 밖에 써야되구나;
// 두개의 노드를 연결하는 간선을 표현하기 위한 클래스
/*
 * 각 엣지 객체는 시작노드와 끝노드를 정수형변수 e로 표현하며 간선의 가중치(거리)를 정수형 변수 value로 표현함
 * 트리지름을 구하는과정에서 각 노드를 연결하는 간선 정보를 저장하기위해 edgeㅡ클래스 사용
 * 또한 BFS알고리즘에서 각 노드 방문여부와 거리 정보를 함께저장하기 위해 큐에 Edge클래스를 넣어서 사용가능 
 */
	class Edge{
		int e;
		int value;
		public Edge(int e, int value) {
			this.e=e;
			this.value = value;
	}

}
