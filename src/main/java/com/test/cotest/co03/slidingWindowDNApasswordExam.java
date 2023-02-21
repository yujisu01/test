package com.test.cotest.co03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 슬라이딩윈도우가 뭘까? 2개의 포인터로 범위 지정한다음 범위를 유지한채로, 이동하여 문제 해결하는거
 * 투포인터 알고리즘과 비슷(i,j..)
 * 
 * DNA비밀번호 문제
 * DNA문자열은 모든 문자열에 등장하는 문자가 {A,C,G,T}인것이다. 예를들어 ACKA는 아닌데, ACCA는 해당함..
 * 이런 문자열에 매료가 됐대 (대체왜??..) 근데 이런방법에는 큰 문제가 있다. 임의의 DNA문자열 추출했을때 AAAA같은 보안에 취약한 문자열이 발생가능!
 * 그래서 A는 1개이상, C는 1개이상, G는 1개이상, T는 0개이상 이런식으로 등장해야 비번을 사용할수 있다고 가정 해보자.
 * 이떄 ACCT는 조건만족 X, GCCA는 가능. 
 * 
 * 민호가 만든 임의의 DNA문자열과 비밀번호로 사용할부분 문자열의 길이, 그리고 ACGT가 각각 몇번이상 등장해야 비번 사용할수 있는지..
 * 순서대로 주어졌을떄 민호가 만들수 있는 비번 종류 수를 구하는 프로그램 작성하라..
 * 
 * ( 단 부분 문자열 등장위치가 다르면 부분문자열 내용이같더라도 다른 문자열로 취급함. )
 * 
 * 
 */
public class slidingWindowDNApasswordExam {
	
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 전체 문자열 크기 선언 (입력가능)
		int S = Integer.parseInt(st.nextToken());
		// 부분문자열 크기 선언 (입력가능)
		int P = Integer.parseInt(st.nextToken());
		int result= 0;
		
		char A[] = new char[5]; 	// 문자열 데이터 (+1)
		checkArr = new int[4];		// 비밀번호 체크배열
		myArr = new int[4];			// 현재상태 배열
		checkSecret =0;				// 몇개의 문자와 관련된 개수를 충족했는지 판단하는 변수
		
		A = bf.readLine().toCharArray();			// A배열도 문자열도 char배열로 친절히 쪼개주기위해
		st = new StringTokenizer(bf.readLine());	// for문 전 선언
		
		// DNA비밀번호 문자열 입력 (ex: CGTA..)
		for(int i=0; i<4; i++) {
			// 비밀번호 체크배열 파싱
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) checkSecret++;
		}
		// 0번째부터 P까지 일단 첫번째로 DNA패스워드 확인하고 Add
		for(int i=0; i<P; i++) {
			Add(A[i]);
		}
		// checkSecret이 ACGT 다 해당되면 result++
		if(checkSecret==4) result++;
		
		//슬라이딩윈도우 처리부분
		// 위에서 0번째부터P까지 DNA 확인했으니 이제 한칸씩 이동하면서 제거되는 문자열과, 새로 들어오는 문자열 처리
		for(int i= P; i<S; i++) {
			int j =i-P;
			Add(A[i]);
			Remove(A[j]);
			
			// 유효한 비밀번호인지 (checkSecret==4) 판단해 결과값에 업데이트
			if(checkSecret==4) result++;
		}
		System.out.println(result);
		bf.close();
	}
	
	
	// Add, Remove 함수 처리 부분 
	private static void Add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) checkSecret++;
			break;
		
		}
	}
	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}
}
