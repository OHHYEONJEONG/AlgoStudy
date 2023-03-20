package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927_√÷º“»¸ {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> lowestHeap = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(bf.readLine());
			if(x==0) {
				if(lowestHeap.peek()==null) {
					System.out.println(0);
				}else {
					int outN = lowestHeap.poll();
					System.out.println(outN);
				}
			}else {
				lowestHeap.add(x);
			}
		}
	}
}
