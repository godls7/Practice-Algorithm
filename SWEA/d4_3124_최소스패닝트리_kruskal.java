package s0915;

import java.io.*;
import java.util.*;


class d4_3124_최소스패닝트리_kruskal {
	
	static class Edge implements Comparable<Edge> {
		
		int start,end,weght;
		
		public Edge(int start, int end, int weght) {
			super();
			this.start = start;
			this.end = end;
			this.weght = weght;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weght, o.weght);
		}
	}
	
	// 서로소 집합
	static int[] parents; // 부모원소 관리 
	
	static void make() {
		// 모든원소 자신을 대표로 만듬 
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a; // 자신이 대표자 일때 
		return parents[a] = find(parents[a]); // 자신이 속할 집합의 대표자를 자신의 부모로 
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int c=1; c<=t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E]; // 간선개수만큼 
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start, end, weight);
			}
			
			Arrays.sort(edgeList); // weight 기준으로 오름차순 정렬 
			
			make();
			
			int cnt=0, result=0;
			for(Edge edge:edgeList) {
				if(union(edge.start, edge.end)) {
					result+=edge.weght;
					if(++cnt==V-1) break;
				}
			}
			sb.append("#").append(c).append(" ").append(result).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		br.close();
	}

}
