package h0915;

import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈 {
	
	static int N,M,count,answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer=0;
		map = new int[N][M];
		visited= new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(answer=0; isCheese(); answer++) {
			for(boolean[] arr:visited) {
				Arrays.fill(arr, false);
			}
			
			visited[0][0] = true;
			count=0; //	for 을 탈출할때까지 계속 초기
			dfs(0, 0);
		}
		sb.append(answer).append("\n").append(count);
		System.out.println(sb);
		br.close();
	}
	
	private static boolean isCheese() {
		// 2가 공기와 맞닿은 치즈이므로 2인경우 0으로 바꿔주기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					map[i][j]=0;
				}
			}
		}
		
		//치즈가 남아있을때까지 실행 	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}

	// 공기와 맞닿은 치즈 찾기 
	static void dfs(int x,int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
			
			visited[nx][ny]=true;
			if(map[nx][ny]==1) { // 1이면 
				map[nx][ny]=2; // 2로 변경 => 공기로 맞닿은곳 표시 
				count++;
			} else {
				dfs(nx, ny);
			}
		}
	}
}