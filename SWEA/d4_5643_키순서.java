package s0929;

import java.io.*;
import java.util.*;

public class d4_5643_키순서 {
	
	static final int INF=987654321;
	static int N, M, answer;
	static int adj[][];

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1];
			answer=0;
			
			// 처음에 다 무한대로 채우기 
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=N; j++) {
					adj[i][j]=INF;
				}
			}
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			}
			
			// 플루이드 워샬
			for(int k=1; k<=N; k++) { // 경  
				for(int i=1; i<=N; i++) { // 출 
					for(int j=1; j<=N; j++) { // 도 
						if (adj[i][j] > adj[i][k] + adj[k][j]) {
                            adj[i][j] = adj[i][k] + adj[k][j];
                        }
					}
				}
			}
			
			int[] knows = new int[N+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(adj[i][j]!=INF) {
						knows[i]++;
						knows[j]++;
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				if(knows[i]==N-1)
					answer++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
