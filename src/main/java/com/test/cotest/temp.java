package com.test.cotest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class temp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> plsQ= new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minQ= new PriorityQueue<Integer>();
		int one =0; 
		int zero =0;
		
		for(int i=0; i<N; i++) {
			int data = sc.nextInt();
			if(1<data) {
				plsQ.offer(data);
			}else if(1==data) {
				one++;
			}else if(0==data) {
				zero++;
			}else {
				minQ.offer(data);
			}
		}
		int sum = 0;
		
		while(plsQ.size() > 1) { 
			int first = plsQ.poll();
			int second = plsQ.poll();
			sum += first*second;
		}
		if(!plsQ.isEmpty()) {
			sum += plsQ.poll();
			System.out.println(plsQ.poll());
		}
		System.out.printf("plsQ sum:" + sum + "\n");
		
		while(minQ.size() > 1) {
			int first = minQ.poll();
			int second = minQ.poll();
			sum += first*second;
		}
		if(!minQ.isEmpty()) {
			if(zero==0) { 
				sum += minQ.poll();
			}
		}
		System.out.printf("minQ sum:" + sum + "\n");
		sum += one; 
		System.out.println(sum);
	}
}