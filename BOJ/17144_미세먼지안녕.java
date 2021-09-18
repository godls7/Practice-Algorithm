package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_17144_미세먼지안녕 {
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int R,C,T;
	static int map[][], temp_map[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static List<Point> cleanerList;


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C]; 
		temp_map = new int[R][C];
		cleanerList = new ArrayList<Point>();
		
		for(int r=0; r<R;r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0;c<C;c++) {
				map[r][c] =Integer.parseInt(st.nextToken());
				temp_map[r][c]=map[r][c]; // temp_map 에도 넣기 
				if (map[r][c]==-1) // 공지청정기 위치선언 
					cleanerList.add(new Point(r,c));
			}
		}
//		for(int[]m:map) System.out.println(Arrays.toString(m));
//		for(int[]m:temp_map) System.out.println(Arrays.toString(m));
		
		for(int t=0; t<T; t++) {
			spreadDust();
			copyMap();
			airConditioner();
			copyMap2();
		}
		
//		for(int[]m:map) System.out.println(Arrays.toString(m));
//		System.out.println();
//		for(int[]m:temp_map) System.out.println(Arrays.toString(m));
//		
		int dust =0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==-1) continue;
				dust += map[r][c];
			}
		}
		System.out.println(dust);
	}
	
	// 미세먼지 확산 
	static void spreadDust() {
		for(int r=0; r<R;r++) {
			for(int c=0; c<C;c++) {
				// 빈칸이거나 공기청정기 인경우 넘기기 
				if(map[r][c]==0 || map[r][c]==-1) continue;
				
				for(int d=0; d<4;d++) {
					int nr=r+dx[d];
					int nc=c+dy[d];
					// 범위를 벗어나거나 공기청정기인 경우 넘기기 
					if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==-1) continue;
	
					temp_map[nr][nc]+=map[r][c]/5; // 퍼지는 미세먼지양 더해주기 
					temp_map[r][c]-=map[r][c]/5; // 퍼지는횟수 만큼 원래 미세먼지양 에서 뺴주기 
				}
			}
		}
	}
	// 공기청정기 
	static void airConditioner() {
		// 위쪽 공기청정기
		Point first = cleanerList.get(0);
		// 아래로 
		for(int r=first.x-1; r>0; r--) {
			map[r][0] = map[r-1][0]; 
		}
		// 왼쪽으로 
		for(int c=0; c<C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		// 위로 
		for(int r=0; r<first.x; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		// 오른쪽으로 
		for(int c=C-1; c>0; c--) {
			map[first.x][c] = map[first.x][c-1];
		}
		// 공지청정기 시작부분 0으로 
		map[first.x][1]=0;
		
		
		// 아래쪽 공기청정기 
		Point second = cleanerList.get(1);
		// 위로
		for(int r=second.x+1; r<R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		// 왼쪽으로
		for(int c=0; c<C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		// 아래로
		for(int r=R-1; r>second.x; r--) {
			map[r][C-1] = map[r-1][C-1]; 
		}
		// 오른쪽으로
		for(int c=C-1; c>1; c--) {
			map[second.x][c] = map[second.x][c-1];
		}
		// 공지청정기 시작부분 0으로 
		map[second.x][1]=0;
	}
	
	// 미세먼지 퍼지고 map에 다시 복사
	static void copyMap() {
		for(int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				map[r][c]=temp_map[r][c];
//				temp_map[r][c]=map[r][c];
			}
		}
	}
	
	static void copyMap2() {
		for(int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				temp_map[r][c]=map[r][c];
//				temp_map[r][c]=map[r][c];
			}
		}
	}
}
