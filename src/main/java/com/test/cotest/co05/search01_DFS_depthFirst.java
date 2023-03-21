package com.test.cotest.co05;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 깊이우선 탐색 : 그래프 시작노드에서 출발하여 탐색할 한쪽분기를 정하여 최대깊이까지 
 *  탐색을 마친후 다른쪽 분기로 이동해서 다시 탐색 수행. 후입선출
 *  
 *  -재귀함수로 구현, 스택 자료구조 이용
 *  -시간복잡도 : O(V+E) , 노드수 V / 에지수 E
 *  
 *  1.DFS를 시작할 노드 정한후 사용할 자료구조 초기화하기
 *  2.스택에서 노드를 꺼낸후 꺼낸노드의 인접노드를 다시 스택에 삽입하기
 *  
 *  연결요소 개수구하기
 *  
 */
public class search01_DFS_depthFirst {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<n+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		// m=엣지 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s =Integer.parseInt(st.nextToken());
			int e =Integer.parseInt(st.nextToken());
			A[s].add(e);
			System.out.printf("A[s] = "+A[s] + "\n" );
			A[e].add(s);
			System.out.printf("A[e]= "+A[e] + "\n");
		}
		int count=0;
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		} 
		System.out.println(count);
	}
	
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v]=true;
		
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}

}
