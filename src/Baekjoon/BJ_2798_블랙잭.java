package Baekjoon;

import java.util.Scanner;

public class BJ_2798_블랙잭 {
	static int N, M;
	static boolean[] visited;
	static int max=0;
	static int sum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] deck = new int[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			deck[i] = sc.nextInt();
		}
		// 블랙잭 M에 최대한 가까운 카드 3장의 합 구하기
		combi(0,0,deck);
		System.out.println(max);
	}
	
	public static void combi(int start, int cnt, int[] cards) {
		if(cnt==3) {
			if(max<sum&&sum<=M) max = sum;
			return;
		}
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sum+=cards[i];
			// 카드 3개를 고르지 않았는데, 합이 M보다 커지면 재귀를 더 타지 않도록.
			if(sum>M) {
				sum-=cards[i];
				visited[i] = false;
				continue;
			}
			combi(i+1,cnt+1,cards);
			visited[i] = false;
			sum-=cards[i];
		}
	}
}
