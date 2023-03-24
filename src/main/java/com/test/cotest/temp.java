package com.test.cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class temp {
	static int[][] A;				// 데이터 저장 2차원 행렬 A 선언
	static int N,M;					// N은 행, M은 열
	static boolean[][] visited;		// 방문 확인 배열
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}
	public static void BFS(int i,int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		visited[i][j] = true; 	// 방문 체크
		while(!q.isEmpty()) {
			int now[] = q.poll();
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M) {
					if(A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; 	// 깊이 업데이트 하기
						int[] position = new int[] {x,y};
						q.add(position);
					}
				}
			}
		}
	} 

}

// 예제입력
/*
 * 4 6
 * 110110
 * 110110
 * 111111
 * 111101
 * 
 * 예제출력
 * 9
 */
