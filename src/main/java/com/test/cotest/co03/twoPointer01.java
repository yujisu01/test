package com.test.cotest.co03;

import java.util.Scanner;

public class twoPointer01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// count 값도 N값 자체를 빼고 시작하므로 미리 초기화 해놓고 시작
		// ex: N이 15일때 숫자 15만 뽑는 경우의수를 미니렇고 초기화 했기 때문
		int count=1;
		// index 값은 1부터 시작
		int start_index =1;
		int end_index= 1;
		int sum =1;
		
		while(end_index != N) {
			// if 현재 연속 합 sum이 N과 같은 경우, 일치하므로 count++
			if(sum == N) {	
				count++;
				end_index++;
				sum = sum + end_index;
			// else if 현재 연속 합이 N 보다 더큰 경우, count++ X
			} else if(sum > N){
				// start_index 한칸 이동하는것은, 연속된 자연수에서 왼쪽값을 삭제하는것과 효과가 같음
				// 그러므로 sum값에서 start_index를 빼주는겨
				sum = sum - start_index;	
				start_index++;
			} else if(sum < N) {
				// sum이 N값보다 작을때는 end_index가 증가해야됨. 다음꺼 찾아야댐
				end_index++;
				sum = sum + end_index;
			}
		}
		System.out.println(count);
		
	}

}
