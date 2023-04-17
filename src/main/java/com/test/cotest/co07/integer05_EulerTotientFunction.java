package com.test.cotest.co07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 오일러의 피 
 * 자연수 n이 주어졌을때 GCD(n,k)=1(1<=k<=n) 을 만족하는 자연수 개수 구하기
 * 1번쨰줄에 자연수 n 입력
 * GCD 만족하는 자연수 개수 출력
 * ex입력
 * 1	5	10	45	99	
 * 출력 
 * 1	4	4	24	60
 * 
 * (1)서로소(두 수의 최대공약수가 1인경우) ex 8,15 (공약수 없음) 의 개수를 표현하는  result와
 * 현재 소인수 구성을 표시하는 변수n을 선언. 예제입력 4의 경우 변수 초기화는 n=45, result=45로 한다.
 * (2) 오일러피 핵심이론을 참고하여 2~N의 제곱근까지 탐색하면서 소인수일때 result=result(result/소인수)
 * 연산으로 result값 업데이트함. 이떄 n에서 이 소인수는 나누기연산으로 삭제함
 * 
 * 
 */
public class integer05_EulerTotientFunction {
	// 양의 정수 N이 주어졌을때 N보다 작거나 같은 수중,N과 서로소인 수의 개수를 나타내는 함수
		public static void main(String[] args) throws Exception{
			// BufferedReader로 받아도되고, Scanner로 받아도되고 상관없음
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			//long N = Long.parseLong(br.readLine());
			long N = sc.nextLong();
			// result 변수를 N으로 초기화 한다.
			long result = N;
			
			// for문에서 2~N의 제곱근까지 
			// if문은 N%i 나누어떨어지는 i를 찾아서, i는 N의 소인수중 하나이므로
			// result값 업데이트를 해준다
			// while문: N%i ==0 이 되는값에서 N을 i로 나눈값을 N에 저장한다
			// 계속 while문으로 반복하면, N은 i로 나누어떨어지지않는 값이 되며, 다음 i를 찾기위해 for문진행
			for(long i = 2; i <= Math.sqrt(N); i++) {
				if(N % i == 0) {
					result = result - result/i;
					System.out.printf("result = result-result/i="+result+"\n");
					while(N % i == 0) {
						N = N/i;
						System.out.printf("N=N/i ="+N+"\n");
					} 
				}
			}
			// for문 이후 1보다 큰 N이 있을수 있으므로 이때에도 result값 갱신함.
			if(1<N) {
				System.out.printf("if문 들어오고 나서 result:"+result+", N값: "+N+"\n");
				result = result - result/N; 
				System.out.println(result); 
			}
		}

}
