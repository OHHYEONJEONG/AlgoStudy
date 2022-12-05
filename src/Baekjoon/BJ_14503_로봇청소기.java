package Baekjoon;

import java.util.Scanner;

public class BJ_14503_�κ�û�ұ� {
	static int[][] map;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 }; // ��������(�� �� �� ��)
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		// �κ��� ���� ��ġ�� ����
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

		map[row][col] = 2; // ���� ��ġ û�� (2:û�һ���)
		result++;
		int nr, nc;
 		while (true) {
			int cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				direction = (direction+1)%4; // ���ʹ�������
				nr = row + dr[direction];
 				nc = col + dc[direction];
				if (map[nr][nc] == 0) { // ���� ���⿡ û������ ���� ������ �ִٸ� �κ� ����
					row = nr;
					col = nc;
					map[row][col] = 2; // ���� ��ġ û�� (2:û�һ���)
					result++;
					break;
				}
				cnt++;
			}
			if (cnt == 4) {// �� ���� ��� û�ҵǾ��ְų� ���� ���,
				int back = 0;// ������ ����
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
				if(map[nr][nc]==2) {// ������ ���⿡ ���� ������ �ٶ󺸴� ������ ������ä�� ��ĭ �����ϰ� 2������ ���ư���.
					row = nr;
					col = nc;
				}else {
					break; // ���� ������ ���̶� ������ �� �� ���� ��� �۵� �����.
				}
			}
		}
		System.out.println(result);
	}
}