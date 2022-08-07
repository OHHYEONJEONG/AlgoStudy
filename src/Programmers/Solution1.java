package Programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/12977
//소수만들기
public class Solution1 {
	static int[] N = {1,2,7,6,4,5,11,29,41,1021};
    static int R = 3;
    static boolean visited[];
    static int result = 0;
    
	public static void main(String[] args) {
		visited = new boolean[N.length];
		combi(0,0);
		System.out.println(result);
	}

	static void combi(int start, int cnt) {
		if(cnt == R) {
			int sum = 0;
			int count = 0;
			//방문한 숫자만 수 더하기
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					sum+=N[i];
					System.out.print(N[i] +" ");
				}
			}
			if(isSosu(sum)) {
				result+=1;
			}

			System.out.println();
			
			return;
		}
		for(int i=start;i<N.length;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combi(i+1,cnt+1);
			visited[i] = false;
		}
	}

	public static boolean isSosu(int n) {
		for(int i=2;i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
