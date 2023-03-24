package com.test.cotest.co05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BFS를 이용해서 미로탈출 프로그램 작성
 * 1은 이동가능, 0은 이동불가
 * 문제 요구사항: 지나야 하는 칸수의 최솟값 찾으면됨.
 * (1,1) 부터 (N,M) 까지 갈때 몇칸 가는지 
 * BFS 이용..큐 사용.. fifo.선입선출 
 * (BFS 쓰는 이유: 해당깊이에서 갈수있는 노드탐색을 마친후 다음깊이로 넘어가기 떄문
 * 	시작 노드에서부터 거리가 점차 멀어지는 순서대로 노드를 탐색한다. 이떄 각 depth에서 해당깊이에 위치한
 * 	노드들을 모두 방문한후 다음깊이의 노드들을 방문하게 된다!!)
 * 
 */
public class search07_miro {
	static int[][] A;				// 데이터 저장 2차원 행렬 A 선언
	static int N,M;					// N은 행, M은 열
	static boolean[][] visited;		// 방문 확인 배열
	// 상하좌우 탐색하기위한 배열 (이동방향을 나타내는 상수배열)
	static int[] dx= {0,1,0,-1};	// 북동남서 위에서 아래로 증가?
	static int[] dy= {1,0,-1,0};	// 동북서남 왼쪽에서 오른쪽으로 증가?
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		
		// N x M크기의 '미로 정보를 입력'받기 위해 이중반복문 사용됨 i(row), j(column)
		// N개수만큼 반복
		for(int i=0; i<N; i++) {
			// 각 행마다 미로정보는 StringTokenizer를 사용해서 공백으로 분리되어 있다.
			st = new StringTokenizer(br.readLine());
			// st.nextToken() 메서드를 통해 공백을 기준으로 분리된 문자열 하나씩 갖고옴
			// 이떄 한줄의 미로정보를 문자열로 저장하고있기 때문에 line변수에 st.nextToken메서드로 반환된 문자열 할당함
			String line = st.nextToken();
			// M개수만큼 반복해서 A배열에 저장하는 과정까지
			for(int j=0; j<M; j++) {
				// line문자열에서 각 열 정보를 가져와서 A배열에 저장함
				// j부터, j+1번째 문자까지 추출해서 문자열로 반환한다. 그리고 A[i][j]배열에 저장
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		BFS(0,0);
		// A[N][M]은 인덱스 범위 벗어남
		System.out.println(A[N-1][M-1]);
	}
	// 시작점 i,j 전달 
	public static void BFS(int i,int j) {
		// <int[]> 는 큐에 담을 데이터 타입을 지정하는거 즉 int[]배열을 큐에 담는거
		// 예를들어 문자열을 담는다면 Queue<String> 으로 지정해줄수 있다 
		Queue<int[]> q = new LinkedList<int[]>();
		// 큐의 맨뒤에 새로운 요소 추가
		// 큐 맨뒤에 크각 2인 int배열 [i,j]를 추가하는 코드이다. 
		q.offer(new int[] {i,j});
		// q.offer ~ 대신 아래 코드도 가능 
		// int[] position = new int[] {i,j};
		// q.offer(position); 
		visited[i][j] = true; 	// 방문 체크
		while(!q.isEmpty()) {
			int now[] = q.poll();
			// 상하좌우 탐색 
			for(int k=0; k<4; k++) {
				// 현재 지점에서 이동한 다음 지점의 조ㅏ표 계산
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				// 좌표 유효성 검사 (미로범위를 벗어나나요?..)
				// x,y 0이상이고, x,y가 각각 N,M보다 작으면
				if(x >= 0 && y >= 0 && x < N && y < M) {
					// 갈수있는칸이고 (0이 아니고), 방문한칸이 아니면
					if(A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; 	// 깊이 업데이트 하기, 시작점으로부터 거리정보 저장
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
