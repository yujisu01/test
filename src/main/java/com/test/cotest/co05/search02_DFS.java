package com.test.cotest.co05;

import java.util.List;
import java.util.Stack;
/*
 * DFS 구현코드 
 * DFS 알고리즘구현. 인접리스트로 표현된 그래프와 시작노드, 방문여부를 저장하는 'visited'배열을
 * 인자로 받음. DFS는 스택을 사용하여 구현하며, 시작노드를 스택에 넣고 방문여부 체크
 * 스택이 비어있을떄까지 다음을 반복
 * 1. 스택에서 노드를 꺼내고 방문했다고 표시
 * 2. 해당 노드의 인접노드들을 스택에 넣고 방문 여부 체크함
 */
public class search02_DFS {

	public void dfs(List<Integer>[] graph, int start, boolean[] visited) {
		// 스택 선언
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		visited[start] = true;
		
		// 스택에 비어있을때까지 
		while(!stack.isEmpty()) {
			// node를 스택에서 뻄
			int node = stack.pop();
			// graph의 노드갯수 만큼 인접노드들을 스택에 넣고 방문여부 체크
			for(int neighbor : graph[node]) {
				// 
				if(!visited[neighbor]) {
					// 스택에 인접노드 push
					stack.push(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}
}
