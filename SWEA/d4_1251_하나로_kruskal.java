package s0825;

import java.io.*;
import java.util.*;

import sun.print.resources.serviceui;

public class d4_1251_하나로_kruskal {
	
	static class Edge implements Comparable<Edge>{
		int start,end;
		long weight;

		public Edge(int start, int end, long d) {
			super();
			this.start = start;
			this.end = end;
			this.weight = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents;
	static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] =i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aR = find(a);
		int bR = find(b);
		if(aR==bR) return false;
		parents[bR] = aR;
		return true;
	}
	
	static int N;
	static List<Edge> edgeList;
	static int[] x,y;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine()); // 테스트케이스
		for(int t=1; t<=T; t++) {
			
			N = Integer.parseInt(br.readLine());
			edgeList = new ArrayList<>();
			x = new int[N];
			y = new int[N];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			
			for(int i=0; i<N; i++) {
				x[i] = Integer.parseInt(st1.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
			}
			
			Double E = Double.parseDouble(br.readLine());
			
			// 모든 간선 만들기
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					long disX = Math.abs(x[i]-x[j]);
					long disY = Math.abs(y[i]-y[j]);
					edgeList.add(new Edge(i, j, disX*disX+disY*disY));
				}
			}
			
//			for(Edge edge:edgeList) {
//				System.out.println(edge.start+", "+edge.end+" : "+edge.weight);
//			}
			// 가중치 오름차순 정렬
			Collections.sort(edgeList);
			
			make();
			long result=0, cnt=0;
			for(Edge edge:edgeList) {
				if(union(edge.start, edge.end)) {
					result += edge.weight;
					cnt++;
					if(cnt==N-1) break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(result*E)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}