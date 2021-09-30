package s0930;

import java.io.*;
import java.util.*;

class Thief {
	int r,c;

	public Thief(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class d4_1953_탈주범검거 {

	static int N,M,R,C,L,answer;
	static int map[][];
	static boolean visited[][];
	static int[] dx= {-1,1,0,0}; // 상하좌우 
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			answer=1;
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void bfs() {
		int time=0;
		
		Queue<Thief> queue = new ArrayDeque<Thief>();
		visited[R][C] = true;
		queue.offer(new Thief(R, C)); // 현재 탈주범위치 
		
		while(!queue.isEmpty()) {
			time++;
			if(time>=L) return; // 현재시간이 소요시간과 같다고 아웃 
			
			int size=queue.size();
			for(int i=0; i<size; i++) {
				Thief now = queue.poll();
				int now_type = map[now.r][now.c]; // 현재 터널타입 받기 
				
				for(int d=0; d<4; d++) {
					int nr = now.r + dx[d];
					int nc = now.c + dy[d];
					
					// 범위 벗어나고 비어있거나 이미 방문한경우 넘기기 
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || visited[nr][nc]) continue;
					
					int next_type = map[nr][nc]; // 다음위치의 터널타입 
					switch (d) {
					case 0: // 다음 방향 상
						// 현재 터널타입이 위로갈수 있고, 다음 터널타입이 아래가 뚫려있어야 가능 
						if (now_type==1 || now_type==2 || now_type==4 || now_type==7) {
							if(next_type==1 || next_type==2 || next_type==5 || next_type==6) {
								visited[nr][nc] = true;
								queue.offer(new Thief(nr, nc));
								answer++;
							}
						}
						break;
					case 1: // 다음 방향 하 
						// 현재 터널타입이 아래로갈수 있고, 다음 터널타입이 위가 뚫려있어야 가능
						if (now_type==1 || now_type==2 || now_type==5 || now_type==6) {
							if(next_type==1 || next_type==2 || next_type==4 || next_type==7) {
								visited[nr][nc] = true;
								queue.offer(new Thief(nr, nc));
								answer++;
							}
						}
						break;
					case 2: // 다음 방향 좌 
						// 현재 터널타입이 좌로갈수 있고, 다음 터널타입이 우가 뚫려있어야 가능
						if (now_type==1 || now_type==3 || now_type==6 || now_type==7) {
							if(next_type==1 || next_type==3 || next_type==4 || next_type==5) {
								visited[nr][nc] = true;
								queue.offer(new Thief(nr, nc));
								answer++;
							}
						}
						break;
					case 3: // 다음 방향 우 
						// 현재 터널타입이 우로갈수 있고, 다음 터널타입이 좌가 뚫려있어야 가능
						if (now_type==1 || now_type==3 || now_type==4 || now_type==5) {
							if(next_type==1 || next_type==3 || next_type==6 || next_type==7) {
								visited[nr][nc] = true;
								queue.offer(new Thief(nr, nc));
								answer++;
							}
						}
						break;
					}
				}
			}
		}
	}
}
