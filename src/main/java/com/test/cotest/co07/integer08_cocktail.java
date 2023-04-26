package com.test.cotest.co07;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 칵테일 만들기
 * 재료 N개 공개되잇음. 재료쌍 N-1개 비율을 알아냈고 이 비율을 이용하면 칵테일에 들어가는 전체재료의 비율을 알수있다.
 * 총재료쌍 N-1개의비율이 입력으로 주어질때 다음조건을 만족하는 칵테일을 만드는데필요한 각재료의 양을 구하는 프로그램
 *  - 필요한 재료 질량을 모두더한값이 최소가 되야함
 *  - 칵테일 만드는 재료의 양은 정수이고, 총질량은 0보다큼
 *  - 비율은 'a b p q'와 같은 형식으로 주어지는데 a번 재료의 질량을 b번 재료의 질량으로 나눈값이 p/q라는 뜻이다
 *  
 *  첫번쨰줄에 재료개수가 주어지고 N은 10보다 작거나 같음
 *  2번째줄은 N-1 개의 줄에는 재료쌍의 비율이 1줄에 1개씩 주어지고, 문제설명에 나온형식인 'a b p q'로 주어짐
 *  재료는 0번부터 N-1까지이고, a와 b는 모두 N-1보다 작거나 같은 자연수. p와 q는 9보다 작거나 같은 자연수다
 *  
 *  ex입력
 *  5
 *  4 0 1 1   4:0이 1:1?
 *  4 1 3 1
 *  4 2 5 1
 *  4 3 7 1
 *  출력
 *  105 35 21 15 105
 *  이해가안돼요 ㅋㅋ
 */
public class integer08_cocktail {
	static ArrayList<cNode>[] A;
	static long lcm;
	static boolean visited[];
	static long D[];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		
		for(int i=0; i<N; i++) {
			A[i]= new ArrayList<cNode>();
		}
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,p,q));
			lcm *= (p*q / gcd(p,q));
		}
		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		for(int i=1; i<N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for(int i=0; i<N; i++) {
			System.out.print(D[i] / mgcd+" ");
		}
	}
	
	public static long gcd(long a, long b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
	
	public static void DFS(int Node) {
		visited[Node] = true;
		for(cNode i : A[Node]) {
			int next = i.getB();
			if(!visited[next]) {
				D[next] = D[Node] * i.getQ() / i.getP();
				DFS(next);
			}
		}
	}
}

	class cNode{
		int b;
		int p;
		int q;
		public cNode(int b, int p, int q) {
			super();
			this.b=b;
			this.p=p;
			this.q=q;
		}
		public int getB() {
			return b;
		}
		public int getP() {
			return p;
		}
		public int getQ() {
			return q;
		}
	}
  


