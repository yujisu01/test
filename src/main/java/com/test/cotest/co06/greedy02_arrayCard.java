package com.test.cotest.co06;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 카드정렬하기
 * 
 * 정렬된 두묶음의 숫자가 있음. 각 묶음 카드가 각각 A,B 일떄 보토 두묶음을 합쳐 1개로 만들려면 A+B번 비교해야 한다
 * 예를들어 20장, 30장씩 있는 카드묶음을 합치려면 50번의 비교가 필요함
 * 
 * 예를들어 (10+20) 합치고 이 (30+40) 합치면 100번이 필요함
 * 그러나 (10+40) 하고 (20+50) 하면 120번 필요함 덜효율적임.
 * 
 * N개의 숫자가카드묶음 최소한 몇번 개수가 필요한지 구하는 프로그램 작성하기
 * 
 * 1번째줄에 N개 (카드묶음수) 그다음줄에 숫자카드묶음 각각의 장수
 * 
 * ex
 * 3 //카드묶음수
 * 10
 * 20
 * 40
 * 출력
 * 100
 */
public class greedy02_arrayCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//int A[] = new int[N];
		// 우선순위 큐 선언
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		
		// for문으로 우선순위 큐에 카드묶음 data를 넣음
		for(int i=0;i<N;i++) {
			// 둘다가능
			//int data = sc.nextInt();
			//pq.add(data); 
			pq.offer(sc.nextInt());
		}
		int data1=0;
		int data2=0;
		int sum=0;
		
		// 원소가 하나남을때까지 
		// 카드묶음이 한개가될때까지 합침
		while(pq.size() != 1) {
			// 가장작은원소 2개를 꺼내서 변수에 각각 저장함
			// 우선순위큐에 넣으면 따로 Arrays.sort 정렬 안해줘도된다. 내부적으로 원소들이 정렬됨
			data1= pq.remove(); 
			data2= pq.remove();
			
			int dataSum = data1 + data2;
			// sum변수에 dataSum을 더한후 저장
			sum += dataSum;
			// 더한결과를 다시 우선순위큐에 추가해준다.
			// 이렇게 하면 우선순위큐에서는 두카드 묶음을 합친결과가 가장작은값이 되므로 다음반복에선느 원하는 결과를 얻을수있음
			pq.add(dataSum);
		}
		System.out.println(sum);
	}

}

/*
 * 우선순위 큐선언이유
 * 카드묶음 개수가 작은 순서대로 먼저 합치는것이 전체비교회수를 줄인다.
 * 현재 데이터중 가장작은 카드 개수묶음 2개를 뽑아야 하고, 이걸기준으로 합친 새로운묶음을 다시 데이터에 넣고 
 * 재정렬 해야함. 
 * 즉 데이터의 삽입삭제정렬이 자주일어나므로 이문제는 우선순위큐를 이용해야한다고 한다
 * 
 * 큐에서 메서드
 * 		예외발생		값리턴
 * 추가 add			offer
 * 삭제 remove		poll
 * 검사 element		peek
 */
