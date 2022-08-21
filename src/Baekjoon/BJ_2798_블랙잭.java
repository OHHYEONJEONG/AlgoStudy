package Baekjoon;

import java.util.Scanner;

public class BJ_2798_���� {
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
		// ���� M�� �ִ��� ����� ī�� 3���� �� ���ϱ�
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
			// ī�� 3���� ���� �ʾҴµ�, ���� M���� Ŀ���� ��͸� �� Ÿ�� �ʵ���.
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
