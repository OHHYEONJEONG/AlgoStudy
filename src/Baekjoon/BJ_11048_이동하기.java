package Baekjoon;

import java.util.Scanner;

public class BJ_11048_이동하기 {
	static int N,M;
	static int[][] miro;
	static int[][] memoization;
	static int[] dx = {0,1,1};
	static int[] dy = {1,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		miro = new int[N][M];
		memoization = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				miro[i][j] = sc.nextInt();
			}
		}
		memoization[N-1][M-1] = miro[N-1][M-1]; // 도착점은 memoization에 저장
		move(0,0);
		System.out.println(memoization[0][0]);
	}
	
	static int move(int x, int y) {
		if(memoization[x][y]!=0) {
			return memoization[x][y];
		}
		
		for(int d=0;d<3;d++) {
			int nx = x+dx[d]; int ny = y+dy[d];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			memoization[x][y] = Math.max(move(nx,ny)+miro[x][y], memoization[x][y]); // 움직이는 곳의 값+현재 miro값과 저장되어있는 memoization 값 중 큰 값 저장
		}
		return memoization[x][y];
	}
	
	//디버깅
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(memoization[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
