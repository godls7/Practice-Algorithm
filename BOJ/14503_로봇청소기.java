package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_14503_로봇청소기 {
	
	static int N,M,answer;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {-1,0,1,0}; // 북동남서  (북동남서 왼쪽으로 회전 )
	static int dy[] = {0,1,0,-1};
	

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		answer=0;
		
		// 로봇 처음위치 입력 
		st = new StringTokenizer(br.readLine());
		int rx = Integer.parseInt(st.nextToken());
		int ry = Integer.parseInt(st.nextToken());
		int rd = Integer.parseInt(st.nextToken());
		
		
		// map 입력 받기 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(rx,ry,rd);
		System.out.println(answer);
		br.close();
	}
	
	static void dfs(int r, int c, int d) {
		boolean flag = false;
		
		// 현재 위치가 아직 청소안했다면 청소함으로 
		if(!visited[r][c]) {
			visited[r][c]=true;
			answer++;
		}
		
		// 2-1 왼쪽방향부터 탐색 
		for(int i=0; i<4; i++) {
			d=rotation(d);
			int nx=r+dx[d];
			int ny=c+dy[d];
			
			// 2-b 청소할  공간있다면  
			if(map[nx][ny]==0 && !visited[nx][ny]) {
				dfs(nx, ny, d);
				flag = true;
				// 일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만, 
				// 후진할 때만 이전 길을 되돌가 가며 확인할 수 있으므로 
				// break을 해서 다시 되돌아 와도 더 이상 움직이면 안된다.
				break;
			}
		}
		
		// 2-c,d
		if(flag==false) {
			// 지금 방향에서 후진 
			int nx = r-dx[d];
			int ny = c-dy[d];
			
			// 아직 청소를 안했을때만 다시 dfs 
			if(map[nx][ny]==0)
				dfs(nx, ny, d);
		}
	}

	static int rotation(int d) {
		if(d==0) return 3;
		else if(d==1) return 0;
		else if(d==2) return 1;
		else return 2;
	}
}
