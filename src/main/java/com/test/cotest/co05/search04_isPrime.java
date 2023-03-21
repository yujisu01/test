package com.test.cotest.co05;

import java.util.Scanner;

/*
 * 신기한 소수찾기
 * 7331을 예로 들자. 7331은 733도 소수, 73도 소수, 7도 소수다.
 * 즉 외쪽부터 1자리,2자리,3자리 4자릿수 모두 소수다. 이런 소수를 신기한소수라고 하자
 * 숫자 N이 주어졌을떄 (자릿수) N의 자리숫자중 신기한 소수 모두 찾기 
 * ㅡㅡ
 */
public class search04_isPrime {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	
	static void DFS(int number, int jarisu) {
		// 자릿수가 N이고 소수인수 출력하기
		// 1부터 9까지 for문
		// 짝수를 만들지 않도록 continue하고,
		if(jarisu==N) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return; 
		}
		for(int i=1; i<10; i++) {
			if(i % 2 == 0) {
				continue; 
			}
			// 만약 소수만드는 매개변수에서 number*10 + i 가 소수 면 DFS함수에서 자릿수 +1
			if(isPrime(number * 10 + i)) {
				DFS(number * 10 + i, jarisu + 1);
			}
		} 
	}
	// 소수 검사
	// 나중에 수정하기
	static boolean isPrime(int num) {
		//for(int i=2; i<=num/2; i++) 
		// Math.sqrt(num)은 제곱근 계산 함수 Math.sqrt(16)은 4를 반환한다.
		for(int i=2; i<=Math.sqrt(num); i++) 
			if(num % i == 0) 
				return false;
			return true;
	}
}



/*
 * 위 코드는 Java로 작성된 소수(prime number)를 찾는 프로그램입니다. 주어진 자릿수 N에 대해 N자리의 소수를 찾습니다.

주어진 자릿수 N을 입력받고, DFS 메소드를 4번 호출합니다. DFS 메소드는 현재 숫자와 자릿수를 매개변수로 받으며, 재귀적으로 숫자를 만들어가며 소수인지 검사합니다.

숫자를 만들 때마다, 짝수를 만들지 않도록 continue로 건너뛰고, 소수인 경우에는 자릿수가 N이 되었을 때 출력합니다. 소수 검사는 isPrime 메소드에서 수행합니다.

하지만 isPrime 메소드의 구현은 잘못되어 있습니다. 소수는 1과 자기 자신만을 약수로 가지는 자연수입니다. 
따라서, isPrime 메소드에서는 2부터 num/2까지의 수 중 나누어 떨어지는 수가 있는지 검사하여 소수를 판별하고 있습니다. 하지만, 이 방법은 비효율적이며 큰 수에 대해서는 오류가 발생할 수 있습니다.

정확한 소수 검사를 위해서는, 2부터 sqrt(num)까지의 수 중 나누어 떨어지는 수가 있는지 검사해야 합니다. 
따라서, isPrime 메소드를 다음과 같이 수정할 수 있습니다.

java
Copy code
static boolean isPrime(int num) {
    if (num <= 1) return false;
    for(int i=2; i<=Math.sqrt(num); i++) {
        if(num % i == 0) {
            return false;
        }
    }
    return true;
}
 */
