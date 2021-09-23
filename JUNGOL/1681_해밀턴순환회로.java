package h0923;

import java.io.*;
import java.util.*;

public class Main_jo_1681_해밀턴순환회로 {
	
	static final int INF=987654321;
	static int N,answer;
	static int map[][];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 초기값은 max로 두기 
		answer =INF;
		// 처음 시작장로 다시 돌아와야함 
		dfs(0,0,0);
		System.out.println(answer);
	}
	
	static void dfs(int start, int idx, int cost) {
		// 비용이 answer보다 크다면 리턴 
		if(cost>=answer) return;
		
		//모든 장소 방문 했다면 
		if(idx==N-1) {
			// 회사로 돌아오는 길이 있으면 
			if(map[start][0]!=0) {
				// 현재 장소까지 비용을 더한 값과 비교해서 저장 
				answer = Math.min(answer, cost+map[start][0]);
			}
			return;
		}
		
		for(int i=1; i<N; i++) {
			// 다음장소로 가는길이 있고, 아직방문하지 않았다면  
			if(map[start][i]!=0 && !visited[i]) {
				visited[i]=true; // 방문처리 
				dfs(i, idx+1, map[start][i]+cost);
				visited[i]=false; // 방문처리 해제 
			}
		}
	}
}
