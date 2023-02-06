package com.test.cotest;

// run-coverage 
public class timeComplexityExample01 {
	public static void main(String[] args) {
		int findNum= (int)(Math.random() * 100);
		for(int i=0; i<100; i++) {
			if(i==findNum) {
				System.out.println(i);
				break;
			}
		}
	}

}
