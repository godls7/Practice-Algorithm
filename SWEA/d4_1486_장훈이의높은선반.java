package study.algorithm;

import java.io.*;
import java.util.*;


public class d4_1486_장훈이의높은선반 {
	
	static int N,B, answer;
	static int member[];
	

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			member = new int[N];
			answer = 987654321;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				member[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0,0,0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void combi(int cnt, int start, int total) {
		// 기저조건 
		if(total>=B) {
			answer = Math.min(answer, total-B);
			return;
		}
		
		for(int i=start; i<N; i++) {
			combi(cnt+1, i+1, total+member[i]);
		}
	}
}
