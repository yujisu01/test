package com.test.cotest.co07;
//모르겠음;
import java.util.Scanner;

/*
 * 거의소수 구하기
 * 어떤수가 소수의 N제곱 일때 이 수를 '거의소수'라 함. A,B가 있을때 A보다 크거나같고, B보다 작거나 같은 
 * 거의소수가 몇갠지 출력
 * 
 * 1번쨰 줄에 왼쪽범위A와, 오른쪽범위B가 주어짐.
 * A의 범위는 10의14제곱보다 작거나 같은 자연수, B는 A보다 크거나 같고 10의 14제곱보다 작거나 같은 자연수
 * (A<=10의14승), (10의14승>=B>=A)
 * 
 * ex입력
 * 1 1000
 * 출력
 * 25
 */
public class integer02_approxiDecimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		
		long[] A= new long[1001];
		for(int i=2; i<A.length; i++) { 
			A[i] = i;
		}
		// 2부터 제곱근까지 수행
		// 에라토스테네스의 체 
		for(int i=2; i<= Math.sqrt(A.length); i++) {
			if (A[i] == 0) { 
				continue; 
			}
			for(int j= i+i; j< A.length; j=j+i) { 
				A[j] = 0; 
			}
			System.out.printf("A[i]: " + A[i] + "\n"); 
		} 
		
		// 정수의 소인수분해 결과가 2의 거듭제곱의 곱으로 나타낼수 있는 정수의 개수가 출력됨
		// 2~1000까지의 소수를 에라토스테네스 알고리즘으로 구한뒤,이 소수들을 이용해서 min부터 max까지
		// 범위에 있는 안에 있느 모든정수를 소인수분해하면서
		// 그 소인수들이 2의 거듭제곱의 곱으로 표현될수 있는지ㄴ를 판단하고
		// 그렇게 표현될수 있는 경우마다 count++ 하는 방식...
		int count = 0; 
		
		for(int i=2; i<1001; i++) {
			// temp라는 임시변수를 사용해서 min과 max범위안에 속하는지 판단 
			if (A[i] != 0) {
				long temp = A[i]; 
				
				while((double)A[i] <= (double)max/(double)temp) {
					if((double)A[i] >= (double)min/(double)temp) {
						count++; 
						System.out.printf("A[i]" + A[i] + "\n"); 
					} 
					temp = temp * A[i];
				}
			}
			
		}
		System.out.printf("count:" + count + "\n"); 
	}

}
