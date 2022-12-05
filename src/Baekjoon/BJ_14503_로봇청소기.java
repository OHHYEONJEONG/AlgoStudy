package Baekjoon;

import java.util.Scanner;

public class BJ_14503_로봇청소기 {
	static int[][] map;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 }; // 왼쪽으로(북 서 남 동)
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		// 로봇의 현재 위치와 방향
		int row = sc.nextInt();
		int col = sc.nextInt();
		int direction = sc.nextInt();
		
		if(direction == 1) direction = 3;
		else if(direction == 3) direction = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		map[row][col] = 2; // 현재 위치 청소 (2:청소상태)
		result++;
		int nr, nc;
 		while (true) {
			int cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				direction = (direction+1)%4; // 왼쪽방향으로
				nr = row + dr[direction];
 				nc = col + dc[direction];
				if (map[nr][nc] == 0) { // 왼쪽 방향에 청소하지 않은 공간이 있다면 로봇 전진
					row = nr;
					col = nc;
					map[row][col] = 2; // 현재 위치 청소 (2:청소상태)
					result++;
					break;
				}
				cnt++;
			}
			if (cnt == 4) {// 네 방향 모두 청소되어있거나 벽인 경우,
				int back = 0;// 후진할 방향
				if (direction == 0)
					back = 2;
				else if (direction == 1)
					back = 3;
				else if (direction == 2)
					back = 0;
				else
					back = 1;
				nr = row+dr[back];
				nc = col+dc[back];
				if(map[nr][nc]==2) {// 후진한 방향에 벽이 없으면 바라보는 방향은 유지한채로 한칸 후진하고 2번으로 돌아간다.
					row = nr;
					col = nc;
				}else {
					break; // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 작동 멈춘다.
				}
			}
		}
		System.out.println(result);
	}
}