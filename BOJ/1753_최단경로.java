package h0824;

import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로 {
	
	static class Node {
		int vertex, weight; // 도착정점,가중치

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken()); // 정점개수
		int E = Integer.parseInt(st.nextToken()); // 간선개수
		int K = Integer.parseInt(br.readLine()); // 시작점
		
		List<Node>[] adjList = new ArrayList[V+1]; // 간선정보 저장위한 인접리스트
												   // 정점이 1~V개 이므로 배열크기 V+1
		// adjList는 배열객체만 만들어 진것이므로(null로 되어있음), 각 배열자리에 ArrayList 객체 만들어서 넣어줌
		// NullPointException 안돼!
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		boolean[] visited = new boolean[V+1]; // 방문배열
		int[] distance = new int[V+1]; // 거리배열
		Arrays.fill(distance, Integer.MAX_VALUE); // 모든 정점 distance 최대값으로 저장
		
		
		// 간선수 만큼 돌면서 인접리스트에 간선정보 저장
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine()," ");
			int v1 = Integer.parseInt(st.nextToken()); // 시작정점
			int v2 = Integer.parseInt(st.nextToken()); // 도착정점
			int w = Integer.parseInt(st.nextToken()); // 가중치
			adjList[v1].add(new Node(v2, w)); // 인접리스트에 각 간선정보 저장 (유향그래프)
		}
				
		distance[K] = 0; // 처음 시작정점 distance 0으로 설정
		
		for(int i=1; i<=V; i++) {
			// 1. 방문하지 않은 정점들 중 최소가중치의 정점 선택
			int min = Integer.MAX_VALUE; // 최소가중치
			int minVertex = -1; // 해당 최소가중치의 정점
			
			// 정점들을 돌면서
			for(int j=1; j<=V; j++) {
				// 아직 방문하지 않았고, 현재 최소가중치보다 시작점에서 j정점까지 거리가 작은경우
				if(!visited[j] && min > distance[j]) {
								  min = distance[j]; // 더 작은 거리를 min에 업데이트
								  minVertex = j; // 그때의 정점을 선택
				}
			}
			if(minVertex == -1) break; // -1 이라는 것은 최소가중치를가진 정점으로 선택되지 않았다는것이므로 경로존재X => 종료
			visited[minVertex] = true; // 선택 정점 방문처리
			// 모든 정점으로의 최단경로를 구해야하므로 탈출조건을 따로 주지않음
			
			
			// 2. 헌재 선택정점을 경유지로 하여 갈수있는 아직 방문하지 않은 정점들에 대한 처리
			for(Node next:adjList[minVertex]) {
				// 아직 방문하지 않았고, (list이기때문에 인접해있는 것만 해당)
				// (시작점부터 선택정점까지의 거리 + 선택정점에서 다음인접정점의 거리)가
				// 이미 존재하는 시작점부터 다음정점까지 거리보다 작은경우
				// 해당 다음정점 거리배열에 새로운 거리 업데이트
				if(!visited[next.vertex] && distance[next.vertex] > min+next.weight) {
											distance[next.vertex] = min+next.weight;
				}
			}
		}
		
		// 각 정점까지의 거리 출력
		for(int d=1; d<=V; d++) {
			if(distance[d]==Integer.MAX_VALUE) sb.append("INF");
			else sb.append(distance[d]);
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
