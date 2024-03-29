package com.test.cotest.co05;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 총N명이 참가하는 알고리즘캠프. 사람들은 0번부터 N-1 번으로 번호가 매겨져 있고 일부 사람들은친구다.
 * 오늘은 다음과 같은 친구관계를 가진 사람 A,B,C,D,E가 존재하는지 구해보려고 한다.
 * A - B 친구
 * B - C 친구
 * C - D 친구
 * D - E 친구
 * 위와같은 친구관계가 존재하는지 여부를 구하는 프로그램 
 * 
 * 1번쨰줄에 사람수(N)과 친구 관계의수(M), 
 * 2번째줄부터 M개의 줄에 정수a와 b가 주어짐. a와 b가 친구라는뜻이다. 같은 친구관계는 2번이상 안주어짐.
 */
public class search05_DFS_findFriend {
	static boolean visited[];		// 방문기록 저장 배열 boolean으로 확인
	static ArrayList<Integer>[] A;	// 그래프데이터 저장인접 리스트
	static boolean arrive;			// 도착 확인 변수
	// DFS 구현하기
	// 함수인자로 now(현재위치), depth(현재까지 탐색한깊이) 를 받음.
	public static void main(String[] args) {
		int N; 		// 노드 개수 (사람수)
		int M;		// 에지 개수 (친구관계수)
		Scanner sc = new Scanner(System.in);	// 입력하게 스캐너 선언
		// 코드 쓰면서 읽히기..;^^:
		arrive=false;
		// int N= 0 을 할당하고 visited 선언하면 'ArrayIndexOutOfBoundsException' 에러가 난다.
	//	visited = new boolean[N];
		N=sc.nextInt();
		M=sc.nextInt();
		// 위치 옮김 에러 해결
		visited = new boolean[N];
		A = new ArrayList[N];
		
		// for문 N개수만큼 반복
		// A인접리스트의 각 ArrayList 초기화 
		for(int i=0; i<N; i++) {
			A[i]= new ArrayList<Integer>();
		}
		
		//for문 M개수만큼 반복 (엣지)
		//M은 입력으로 주어진 엣지(간선의수)이다. 
		for(int i=0; i<M; i++) {
			// S는 시작노드, E는 끝노드를 입력받는거임
			int S=sc.nextInt();
			int E=sc.nextInt();
			// 노드 'S'(시작)에 연결된 노드들을 리스트로 저장하고있는 인접리스트에서 S의 리스트에 E를 add
			// 노드 'E'의 리스트에 S를 add
			// 이렇게 함으로써 엣지를 사용하여 노드들간의 관계를 표현할수가 있다.
			// 즉 엣지연결 
			A[S].add(E);
			A[E].add(S);
		}
		for(int i=0; i<N; i++) {
			DFS(i,1);		// 현재,depth는 1부터 시작
			if(arrive)
			break;
		}
		
		// 최종적으로 arrive 변수 값이 true면 '1'을, false면 '0'을 출력
		if(arrive) System.out.println("1");
		else System.out.println("0");
	}
	// 이 DFS 알고리즘에서는 현재노드에서 갈수있는 인접한 노드를 찾아가면서 깊이를 1씩 증가시킨다.
	// 깊이가 5에 도달하면 탐색종료
	public static void DFS(int now, int depth) {
		// 만약 depth가 5거나, 이미 목적지에 도착한 경우에는
		if(depth == 5 || arrive) {	
			// arrive 변수를 true로 설정하고
			arrive= true;
			// 함수종료
			return;
		}
		// 방문노드 표시를 위해 visited[] 에 체크
		visited[now] = true;
		
		// DFS 함수를 재귀호출한다
		for(int i: A[now]) {
			if(!visited[i]) {
				DFS(i, depth+1);
			}
		}
		// 이후 재귀호출이 끝나면 DFS함수 호출 이전상태로 돌아오기 위해 방문한노드를 다시 방문하지 않도록
		// 이 구문실행 (체크해제)
		// 백트래킹 구현하며, 다음탐색시에는 이전에 방문한 노드를 다시 방문할수 있도록함
		visited[now] = false;
		
	}
}
