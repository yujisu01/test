package com.test.cotest.co07;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 최대공약수 구하기
 * 두수의 최대공약수 구하는 프로그램, 
 * ex입력
 * 3 4 	// A와 B의 길이임
 * 출력
 * 1
 * 입력
 * 3 6
 * 출력
 * 111	// 3은 A(111), 6은 B(111111) 의 최대공약수 길이로 나타난다
 */
public class integer07_GCD {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long a= sc.nextLong();
		long b= sc.nextLong();
		long result = gcd(a,b);
		
		System.out.printf("result:" + result + "\n");
		// result값만큼 1을 출력한다
		while(result > 0) {
			bw.write("1"); 
			result--;
		}
		bw.flush();
		bw.close();
	}
	public static long gcd(long a, long b) {
		if(b==0) return a;
		else 
			return gcd(b, a%b);
	}

}
