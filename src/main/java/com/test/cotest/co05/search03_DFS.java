package com.test.cotest.co05;

import java.util.List;

public class search03_DFS {
	// 그래프를 인접리스트로 받아와 그래프의 모든 노드를 방문하면서 연결요소 개수 구함
	public int countConnectComponents(List<Integer>[] graph) {
		// 방문여부를 저장하는 'visited'배열
		boolean[] visited = new boolean[graph.length];
		int count =0; 
		// dfs객체 생성
		search02_DFS dfs = new search02_DFS();
		
		// 그래프 모든 노드를 방문하면서 
		for(int node=0; node<graph.length; node++) {
			// 방문하지 않은 노드가 있다면 해당 노드를 시작으로 DFS수행
			if(!visited[node]) {
				// DFS를 수행할떄마다 'count' 1씩 증가하면서 연결개수 ++
				count++;
				dfs.dfs(graph, node, visited);
			}
		}
		// count리턴
		return count;
	}

}
