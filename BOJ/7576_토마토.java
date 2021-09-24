package h0924;

import java.io.*;
import java.util.*;

class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_bj_7576_토마토 {
	
	static int N,M,answer;
	static int map[][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static ArrayDeque<Point> queue;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		queue = new ArrayDeque<>();
		answer = Integer.MIN_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					// 익은 토마토 queue에 넣기 
					queue.offer(new Point(i, j));
			}
		}
		System.out.println(bfs());
		br.close();
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			int x = now.x;
			int y = now.y;
			
			for(int d=0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				// 범위 넘으면 넘기기 
				if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
				// 토마토가 아직 안 익었다면 
				if(map[nx][ny]==0) {
					queue.offer(new Point(nx, ny)); // 해당 토마토 추가 
					map[nx][ny]=map[x][y]+1; // 해당 토마토의 익은날짜 
				}
			}
		}
		
		// 마지막 확인작업 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				// 안익은 토마토 발견되면 -1 
				if(map[i][j]==0) return -1;
				answer=Math.max(answer, map[i][j]);
			}
		}
		// 토마토가 모두 익은 경우
		if(answer==1) return 0;
		
		// 걸린 일수는 최대날짜에서 1을 뺴줘야해
		else return answer-1;
	}

}
