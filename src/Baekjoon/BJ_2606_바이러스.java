package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606_���̷��� {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ��ǻ�� ��
		int conN = sc.nextInt(); // ����� ��Ʈ��ũ��
		boolean visited[] = new boolean[N+1];
		boolean network[][] = new boolean[N+1][N+1];
		int answer = 0;
		
		for(int i=1;i<conN+1;i++) { // ����� ��Ʈ��ũ üũ
			int r = sc.nextInt();
			int c = sc.nextInt();
			network[r][c] = true;
			network[c][r] = true;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		//1�� ��ǻ�� ���̷��� �ɸ�
		visited[1] = true;
		for(int i=1;i<N+1;i++) {
			if(network[1][i]==true) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int nc = que.poll(); // ���� ���̷��� �ɸ� ��ǻ��
			if(visited[nc]==true) continue; // �̹� �湮�� ��ǻ�͸� pass
			visited[nc] = true; // �湮üũ
			answer++;
			for(int i=1;i<N+1;i++) {
				if(visited[i]==false&&network[nc][i]==true) que.add(i);
			}
		}
		
		System.out.println(answer);
	}
}