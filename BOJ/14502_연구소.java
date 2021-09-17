package h0917;

import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소 {
	
	static int N,M,answer;
	static int map[][], temp_map[][];
	static List<int[]> virus_point;
	static int[] dx = {-1,0,1,0}; // 상우하좌 
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; // 연구소 지도 
		temp_map = new int[N][M]; // 복사할 지도 
		virus_point = new ArrayList<int[]>(); // 바이러스위치 저장위한 리스트 
		
		// map 입력 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 2인경우 바이러스 리스트에 저장 
				if(map[i][j]==2) virus_point.add(new int[] {i,j});
			}
		}
		
		makeWall(0); // 벽만들기 시작 
		
		System.out.println(answer);
		br.close();
	}

	// 벽 만들기 -조합 
	private static void makeWall(int wall) {
		// 벽을 3개 다세웠을 경우 
		if(wall==3) {
			copyMap(); // 바이러스 퍼지기 전 상황 변경하지 않기위해 temp에 현재 map 복사 
			for(int[] virus:virus_point) {
				dfs(virus[0],virus[1]); // 바이러스 좌표 하나씩 받으며 dfs
			}
			
			// 바이러스가 퍼지고 안전영역 구하기 
			int safe=0;
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++) {
					if(temp_map[i][j]==0) safe++;
				}
			}
			// 지금 경우의 안정영역과 이미 저장된 값중 최대값 저장 
			answer = Math.max(safe, answer);
			return;
		}
		
		// 벽 3개를 아직 다 안세웠을 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) { // 빈칸일경우 
					map[i][j]=1; // 벽을세우고 
					makeWall(wall+1); // 벽3개일때까지 넘김 (백트랙킹) 
					map[i][j]=0; // 원래대로 돌려놈 
				}
			}
		}
	}

	// 바이러스 퍼트리는 dfs
	private static void dfs(int x, int y) {
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			
			if(temp_map[nx][ny]==0) { // 0인경우 
				temp_map[nx][ny]=2; // 2로 바이러스 퍼트리기 
				dfs(nx, ny);
			}
		}
	}

	// 현재 map 복사하기 
	private static void copyMap() {
//		for(int i=0; i<map.length; i++) {
//			temp_map[i] = map[i].clone();
//		}
		// 이게 제일 쉽다!!! 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp_map[i][j] = map[i][j];
			}
		}
	}
	
}
