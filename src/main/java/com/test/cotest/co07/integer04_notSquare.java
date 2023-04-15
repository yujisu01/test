package com.test.cotest.co07;

import java.util.Scanner;

/*
 * 제곱이 아닌수 찾기
 * 어떤수 X가 1보다 큰제곱수로 나눠떨어지지 않았을때 이를 제곱이아닌수 라고 가정함
 * 여기서 제곱수는 정수의 제곱이다. min,max값이 주어질때 min보다 크고 max보다 작은값중
 * 제곱이 아닌수가 몇갠지 출력
 * 
 * 1번째줄에 min,max
 * (1<=min<=1,000,000,000,000,min<=max<=min+1,000,000)
 * 
 * 
 */
public class integer04_notSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		// 최댓값과 최소값의 차이만큼 배열 선언하기
		boolean[] check = new boolean[(int)(max - min + 1)];
		// 2의 제곱수인 4부터 max보다 작거나 같은값까지 반복하기
		for(int i=2; i*i <= max; i++) {
			long pow = i*i;
			long start_index = min/pow;
			// 나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨
			if(min % pow != 0) start_index++;
			
			for(long j = start_index; pow * j<=max; j++) {
				check[(int) ((j * pow) - min)] = true;
			}
		}
		int count = 0;
		for(int i=0;i<=max-min; i++) {
			if(!check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
