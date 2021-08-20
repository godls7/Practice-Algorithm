package h0819;

import java.io.*;
import java.util.*;

public class Main_bj_3109_빵집 {
	
	static int R,C,count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1}; // 우상 우 우하
	static int[] dy = {1,1,1};
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		// map 입력
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 첫번째열의 모든행을 돌면서 dfs
		for(int i=0; i<R; i++) {
			flag = false; // 매번 초기화.. 무조건...!!!
			dfs(i,0);			
		}
		
		System.out.println(count);
		br.close();
	}
	
	static void dfs(int x,int y) {
		
		// 현재 위치 방문처리
		visited[x][y] = true;
		
		// 현재위치가 빵집의 위치이면, count 증가해주고 리턴
		if(y==C-1) {
			count++;
			flag = true;
			return;
		}
		
		// 우상 우 우하 3방 탐색
		for(int d=0; d<3; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			// 해당 위치가 아직 방문하지 않았고 비어있는곳이면
			if(0<=nx && nx<R && 0<=ny && ny<C && !visited[nx][ny] && map[nx][ny]=='.') {
				dfs(nx, ny); // 다시 dfs
				if(flag) return; // 앞의 dfs가 리턴시 완료됐으면 끝까지 return으로 바로 빠져나오게 하기위해
			}
		}
	}
}