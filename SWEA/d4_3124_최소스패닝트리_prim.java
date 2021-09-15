package s0915;

import java.io.*;
import java.util.*;

public class d4_3124_최소스패닝트리_prim {
	
	static class Edge{	
		int vertex,weight;

		public Edge(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static int V,E;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[V];
			
			List<Edge>[] edgeList = new ArrayList[V];
			
			for(int i=0; i<V; i++) {
				edgeList[i] = new ArrayList<Edge>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				
				// edgeList 출발 idx에 목적 idx와 가중치 
				edgeList[start].add(new Edge(end, weight));
				edgeList[end].add(new Edge(start,weight));
			}
			
			// vertex,weight 넣고 w순으로 정렬 
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return Integer.compare(o1.weight,o2.weight);
				}
			});
			
			// 결과는 long으로
			long result=0;
			int cnt =0;
			
			visited[0]=true; // 임의 출발 
			
			// 0과 연결된거 pq에 넣어주기
			for(Edge e:edgeList[0]) {
				pq.add(e);
			}
			
			// pq가중치 작은 간선들부터 탐색 
			while(!pq.isEmpty()) {
				Edge now=pq.poll();
				
				// 이미 방문했으면 넘기고 
				if(visited[now.vertex]) continue;
				// 아니라면 가중치 더해주고 방문처리 
				result += now.weight;
				visited[now.vertex]=true;
				
				if(cnt++==V-1) break;
				
				for(Edge e:edgeList[now.vertex]) {
					// 방문 정점 넘기
					if(visited[e.vertex]) continue;
					pq.offer(e);
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
