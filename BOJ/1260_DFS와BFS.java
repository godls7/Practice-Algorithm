package h0823;

import java.io.*;
import java.util.*;

public class 1260_DFS와BFS {
	
	static int N,M,V;
	static boolean[][] matrix;
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		matrix = new boolean[N+1][N+1];
		
		// 간선정보로 인접노드행렬 입력
		for(int m=0; m<M;m++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = true;
		}
		
		dfs(V,new boolean[N+1]);
		sb.append('\n');
		bfs();
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		sb.append(current).append(" ");
		for(int i=1; i<=N; i++) {
			if(!visited[i] && matrix[current][i]) {
				dfs(i, visited);
			}
		}
	}
	
	static void bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		boolean[] visited= new boolean[N+1];
		
		// 시작점 방문처리 & queue에 넣어주기
		visited[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for(int i=1; i<=N; i++) {
				if(!visited[i] && matrix[current][i]) {
					visited[i]=true;
					queue.offer(i);
				}
			}
		}
	}
}