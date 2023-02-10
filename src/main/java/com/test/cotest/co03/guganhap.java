package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class guganhap {
	public static void main(String[] args) throws IOException {
		// 수N개가 주어졌을때 i번째수에서 j번째 수까지의 합을 구하는 프로그램
		
		// 숫자 갯수 입력받기, 질의 갯수 입력받기 ex(5,3)
		// for(숫자갯수만큼 반복하기){
		//  합 배열 생성 (S[i] = S[i-1] + A[i])
		// for(질의갯수만큼 반복하기) {
		// 	질의범위받기 (i~j)
		// 구간합 출력하기 
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in)); 	//Scanner와 유사
		// bufferedReader 한줄로 입력. Integer.parseInt 형변환해서 함께쓰임
		StringTokenizer stringToken = new StringTokenizer(bufferReader.readLine());				
		
		int suNo= Integer.parseInt(stringToken.nextToken());	// 숫자개수
		int quizNo= Integer.parseInt(stringToken.nextToken());	// 질의개수 저장
		
		long[] S= new long[suNo+1];
	
		// 한번더 가져오는 이유: java.util.NoSuchElementException 발생
		// 객체에서 더이상 가져올게 없어서 에러 발생
		stringToken = new StringTokenizer(bufferReader.readLine());
		
		// 숫자 개수만큼 for문
		for(int i=1; i<=suNo; i++) {
			// 구간합 합배열 생성 
			// S[i]=S[i-1]+A[i]
			S[i] = S[i-1] + Integer.parseInt(stringToken.nextToken());
		}
		// 질의개수만큼 반복하기
		for (int q=0; q<quizNo; q++) {
			stringToken = new StringTokenizer(bufferReader.readLine());
			// 질의 범위받기 i~j
			int i= Integer.parseInt(stringToken.nextToken());
			int j= Integer.parseInt(stringToken.nextToken());
			System.out.println(S[j]-S[i-1]);
//				
		}
	}

}
