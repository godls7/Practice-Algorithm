package s0825;

import java.io.*;
import java.util.*;

public class d4_1251_하나로_prim {
	
	static class Node { // 정점,가중치
		int vertex; 
		long weight;
		
		public Node(int vertex, long weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine()); // 테스트케이스
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine()); // 섬개수
			List<Node>[] adjList = new ArrayList[N]; // 간선정보 저장위한 인접리스트
			for(int i=0; i<N; i++) { // 각 배열자리에 ArrayList객체 채워주기
				adjList[i] = new ArrayList<Node>();
			}
			
			boolean[] visited = new boolean[N]; // 방문배열
			long[] minEdge = new long[N]; // 최소간선비용배열
			Arrays.fill(minEdge, Long.MAX_VALUE); 
			
			int[] x = new int[N]; // x 좌표 
			int[] y = new int[N]; // y 좌표
			
			// 섬 x,y 좌표 입력
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			
			for(int i=0; i<N; i++) {
				x[i] = Integer.parseInt(st1.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
			}
			
			// 세율 입력
			double E = Double.parseDouble(br.readLine());
			
			// 모든 가능한 간선 정보 저장
			long sX, sY, dX, dY;
			for(int i=0; i<N; i++) {
				sX = x[i]; // 시작정점 x좌표
				sY = y[i]; // 시작정점 y좌표
				for(int j=0; j<N; j++) {
					if(i==j) continue; // 시작,도착이 같은 경우만 제외하고 넘기면 모든 양방향 간선정보 입력 가능
					dX = x[j];  // 도착정점 x좌표
					dY = y[j];  // 도착정점 y좌표
					long disX = Math.abs(sX-dX);
					long disY = Math.abs(sY-dY);
					adjList[i].add(new Node(j,disX*disX+disY*disY)); // 각 섬별로 간선정보 저장
				}
			}
			
			long result = 0; // 최소신장트리 비용
			minEdge[0] = 0; // 임의의 시작점 0으로 설정 -> 간선비용 0으로 설정 
			
			for(int i=0; i<N; i++) {
				// 1. 신장트리에 포함되지않은 정점 중 최소간선비용의 정점 찾기
				long min = Long.MAX_VALUE;
				int minVertex = -1; // 최소간선비용 정점번호
				for (int j = 0; j < N; j++) { // 전체 정점을 탐색하면서
					if(!visited[j] && min>minEdge[j]) { // 아직방문하지 않았고, 이전의 min보다 작은경우 업데이트
									min = minEdge[j];
									minVertex = j;
					}
				}
				if(minVertex==-1) break; //-1 이라는 것은 최소가중치를가진 정점으로 선택되지 않았다는것 =>종료
				visited[minVertex] = true; // 신장트리에 포함시킴
				result += min; // 간선비용 누적
				
				// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
				for(Node next:adjList[minVertex]) { 
					// 현재 선택정점에서 인접정점탐색하면서 아직방문하지 않았고, 이전의 min보다 작은경우 업데이트
					if(!visited[next.vertex] && minEdge[next.vertex] > next.weight) {
												minEdge[next.vertex] = next.weight;
					}
				}
			}
			
			// Math.round로 정수*실수 연산에 대해 소수점첫째자리에 대해 반올림해서 정수로 리턴
			sb.append("#").append(t).append(" ").append(Math.round(result*E)).append("\n");
			// (long) (reuslt*E +0.5)
		}
		
		System.out.println(sb);
		br.close();
	}
}