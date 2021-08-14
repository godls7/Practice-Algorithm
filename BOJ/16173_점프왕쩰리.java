package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_16173_점프왕쩰리 {
	
	static int[] dx = {0,1}; // 우하
	static int[] dy = {1,0};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		q = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.offer(new int[] {0,0});
		bfs();
//		dfs(0,0);
		System.out.println(sb);
		br.close();
		
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] curr = q.poll(); // 제일 앞에 위치 뽑기
			int x = curr[0]; // 첫번째자리 x
			int y = curr[1]; // 첫번쨰자리 y
			int poss = map[x][y]; // 현재위치에서 이동가능한 수
			
			// 아래쪽으로 갈 경우 범위 체크 및 방문 여부 체크
			if(x+poss<N && !visited[x+poss][y]) {
				// 도착지에 도착하면 리턴
				if(map[x+poss][y] == -1) {
					sb.append("HaruHaru");
					return;
				}
				visited[x+poss][y] = true;
				q.add(new int[] {x+poss, y});
			}
			
			// 오른쪽으로 갈 경우 범위 체크 및 방문 여부 체크
			if(y+poss<N && !visited[x][y+poss]) {
				// 도착지에 도착하면 리턴
				if(map[x][y+poss] == -1) {
					sb.append("HaruHaru");
					return;
				}
				visited[x][y+poss] = true;
				q.add(new int[] {x, y+poss});
			}
		}
		sb.append("Hing");
	}
	
	/*static void dfs(int i, int j){
		visited[i][j] = true;
		int poss = map[i][j];
		int cnt=0;
		
		for(int r=0; r<poss; r++) {
			for(int d=0; d<2; d++) {
				int ni = i+dx[d];
				int nj = j+dy[d];
				if(0<=ni && ni<N && 0<= nj && nj<N && !visited[ni][nj]) {
					if(map[ni][nj]==-1) result="HaruHaru";
					dfs(ni,nj);
				}
			}
		}
	}
	*/
}
