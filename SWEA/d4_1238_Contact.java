package s0823;

import java.io.*;
import java.util.*;

public class d4_1238_Contact {
	
	static class Node{
		int vertex;
		int cnt;
		
		public Node(int vertex, int cnt) {
			super();
			this.vertex = vertex;
			this.cnt = cnt;
		}
	}
	
	static int length,start,answer;
	static List<Integer>[] adjList;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1238.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt=1;
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				adjList[i] = new ArrayList<>();
			}
			visited = new int[101];
			answer=0;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=length/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			
			bfs();
			sb.append("#").append(cnt).append(" ").append(answer).append('\n');
			cnt++;
		}
		System.out.println(sb);
		br.close();
	}

	static void bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>(); // 번호,깊이
		int max_cnt = Integer.MIN_VALUE;
		visited[start] = 1;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0; i<adjList[current].size(); i++) {
				int v=adjList[current].get(i);
				if(visited[v] ==0) {
					visited[v] = visited[current]+1;
					queue.offer(v);
				}
			}
			max_cnt = visited[current];
		}
		
		for(int i=1; i<101; i++) {
			if(max_cnt != visited[i]) continue;
			answer = (answer<i)? i:answer;
		}
	}
}