package h0825;

import java.io.*;
import java.util.*;

public class Main_bj_10026_적록색약 {
	
	static int N;
	static char[][] painting; // 인접행렬
	static boolean[][] visited; // 방문배열
	static int[] dx= {-1,0,1,0}; // 상우하좌
	static int[] dy= {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		painting = new char[N][N];
		visited = new boolean[N][N];
		int cnt=0;
		
		// 그림입력
		for(int i=0;i<N;i++) {
			painting[i] = br.readLine().toCharArray();
		}
		
		// 정상인 사람이 봤을때
		// 같은색 방문하면서 카운트
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) { // 방문안한경우만
					cnt++; // 증가시키기
					dfs(i, j, painting[i][j]);
				}
			}
		}
		sb.append(cnt).append(" ");
		
		// 적록색약이 보이는 그림으로 리셋
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(painting[i][j]=='G') {
					painting[i][j]='R';
				}
			}
		}
		// 다시 같은색 방문하면서 카운트
		cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					dfs(i, j, painting[i][j]);
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
		br.close();
		
	}
	
	static void dfs(int x, int y, char color) {
		if(visited[x][y]) return; // 방문했으면 리턴
		visited[x][y] = true; // 아니라면, 방문체크
		
		for(int d=0; d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny] && color==painting[nx][ny]) {
											  // 아직 방문하지 않았고 색깔 같은 경우만 dfs
				dfs(nx, ny, color);
			}
		}
	}
}