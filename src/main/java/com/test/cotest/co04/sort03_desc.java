package com.test.cotest.co04;

import java.util.Scanner;

/*
 * 내림차순 
 */

public class sort03_desc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int[] A= new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<N-1;i++) {
			for(int j=0; j<N-1; j++) {
				if(A[j] < A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
	}
	
}
