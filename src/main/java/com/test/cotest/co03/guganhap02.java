package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N x N 개의 수가 N x N 크기의 표에 채워져있음. 표안의 수중 (X1,Y1)에서 (X2, Y2) 까지의 합을 구하기
// X는 행, Y는 열임. 
// ex) (2,2)에서 (3,4) 까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4,4)에서 (4,4) 까지 합은 7이다
// 즉 2차원 구간합 구하기 
/*
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * 
 * */

public class guganhap02 {
	public static void main(String[] args) throws IOException {
		// (1) D[i][j] 구간합공식
		// D[i][j] = D[i][j-1] + D[i-1][j] + D[i-1][j-1] + A[i][j]
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringToken = new StringTokenizer(bufferReader.readLine());
		
		// N(배열크기) M(질의수)만큼 저장하기
		int N = Integer.parseInt(stringToken.nextToken());
		int M = Integer.parseInt(stringToken.nextToken());
		
		// A[i][j] 배열 선언 
		int A[][] = new int[N+1][N+1];
		
		// for(N만큼 반복하기)
		for(int i=1; i<=N; i++) {
			stringToken = new StringTokenizer(bufferReader.readLine());
			for(int j=1; j<=N; j++) {
				// 합배열 저장
				A[i][j] = Integer.parseInt(stringToken.nextToken());
			}
		}
		int D[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] + D[i-1][j-1] + A[i][j];
			}
		}
		// for(M만큼 반복)
		for(int i=0; i<M; i++) {
			stringToken = new StringTokenizer(bufferReader.readLine());
			
			int x1= Integer.parseInt(stringToken.nextToken());
			int x2= Integer.parseInt(stringToken.nextToken());
			int y1= Integer.parseInt(stringToken.nextToken());
			int y2= Integer.parseInt(stringToken.nextToken());
			
			// 구간합 배열로 질의에 답변하기
			int result= D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
	}
	// ㄹㅇ모르겠따..걍보고한거임

}
