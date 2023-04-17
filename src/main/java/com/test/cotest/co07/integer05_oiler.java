package com.test.cotest.co07;
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
public class integer05_oiler {
	public static void main(String[] args) {
		
	}

}
