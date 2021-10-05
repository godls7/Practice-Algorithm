package s1001;

import java.io.*;
import java.util.*;

public class d4_1868_파핑파핑지뢰찾기_bfs {
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,answer;
	static int map_count[][];
	static char map[][];
	static boolean visited[][];
	static int[] dx= {-1,-1,0,1,1,1,0,-1}; // 상 상우 우 우하 하 좌하 좌 좌상 
	static int[] dy= {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("res/input_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			map_count = new int[N][N];
			visited = new boolean[N][N];
			answer=0;
			
			for(int i=0; i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			count_bomb();
			
			// 주변에 지뢰가 없는 곳 클릭 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 현재 지뢰가 아니고 주변지뢰가 0인곳 
					if(map[i][j]!='*' && map_count[i][j]==0 && !visited[i][j]) {
						bfs(i,j);
						answer++;
					}
				}
			}
			
			// 아직 안눌린곳 마저 클릭 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]!='*' && map_count[i][j]>0 && !visited[i][j])
						answer++;
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// 주변 지뢰 개수 세기 
	static void count_bomb() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='.') {
					int count=0;
					for(int d=0; d<8; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						// 범위에 벗어나고 폭탄이 아니면 넘기고 
						if(nx<0 || nx >=N || ny<0 || ny>=N || map[nx][ny]=='.') continue;
						// 폭탄이라면 count 증가 
						count++;
					}
					map_count[i][j]=count;
				}
			}
		}
	}
	
	// 지뢰없는 부분부터 탐색하면서 숫자 입력해주기 
	static void bfs(int x,int y) {
		Queue<Point> q=new ArrayDeque<Point>();
		visited[x][y]=true; // 방문체크 
		q.offer(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int d=0; d<8; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				
				// 범위를 벗어나거나 이미 방문했거나 지뢰하면 넘기기 
				if(nx<0 || nx >=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]=='*') continue;
				
				// 아니라면 방문체크하고 큐에 넣어주기 
				if(map_count[nx][ny]==0) {					
					q.offer(new Point(nx, ny));
				}
				visited[nx][ny]=true;
			}
		}
	}
}
