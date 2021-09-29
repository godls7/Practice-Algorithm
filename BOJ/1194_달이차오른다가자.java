package h0929;

import java.io.*;
import java.util.*;

public class Main_bj_1194_달이차오른다가자 {

	static class Point {
		int x,y;
		int key;
		int count;

		public Point(int x, int y, int key, int count) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	}

	static int N,M,answer;
	static char map[][];
	static boolean visited[][][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static Queue<Point> queue = new ArrayDeque<>();
	// int로 26차이 
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1<<6]; //2^6
		// f e d c b a
		// 1 1 1 1 1 1 아항.... 
		// 어느 키를 저장하고 있는지 비트로 표헌...
		answer=987654321;
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = line[j];
				if(map[i][j]=='0') { // 민식의 현재위치 저장 
					queue.offer(new Point(i,j, 0,0)); // 처음 민식 자리넣기
					map[i][j]='.'; // 지나긴 위치 빈칸만들기 
				}
			}
		}
		
		bfs();
		if(answer==987654321) System.out.println(-1);
		else System.out.println(answer);
		br.close();
	}

	static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			if(visited[now.x][now.y][now.key]) continue; //이미 해당 키를 가지고 방문했으면 넘기기
			visited[now.x][now.y][now.key]=true;
			
			for(int d=0; d<4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				
				// 범위 벗어나거나 벽이면 넘어가기 
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]=='#') continue;
				
				// 출구이면 최솟값 계산해서 넘기기 
				if(map[nx][ny]=='1') {
					answer = Math.min(answer, now.count+1);
				}
				
				// 빈칸일 경우
				if(map[nx][ny]=='.') {
					queue.offer(new Point(nx, ny, now.key,now.count+1));
				}
				// 열쇠가 있을 경우에
				else if('a'<=map[nx][ny] && map[nx][ny]<='f') {
					// (1<<(map[nx][ny]-'a')); 'a'=97
					queue.offer(new Point(nx, ny, now.key | (1<<(map[nx][ny]-'a')),now.count+1));
				}
				// 문을 만날 경우에 
				else if('A'<=map[nx][ny] && map[nx][ny]<='F') {
					int key = now.key & (1<<map[nx][ny]-'A'); // 'A'=65
					if(key>0) 
						queue.offer(new Point(nx, ny, now.key,now.count+1));
				}
			}
		}
	}
}
