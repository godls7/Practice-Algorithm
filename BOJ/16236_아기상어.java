package h0924;

import java.io.*;
import java.util.*;

class Position{
	
	int x,y,dist;

	public Position(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class Main_bj_16236_아기상어 {
	
	static int N, help, size, count;
	static int map[][];
	static boolean visited[][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static Position shark;
	static List<Position> fishes;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size=2; // 처음 아기 상어사이즈 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark = new Position(i, j, 0);
					map[i][j]=0; // 현재 상어위치 0으로 초기화 
				}
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		bfs();
		System.out.println(help);
		br.close();
	}
	
	static void bfs() {
		
		while(true) {
			Queue<Position> queue = new ArrayDeque<Position>();
			fishes = new ArrayList<Position>(); // 먹이 담는 리스트 
			visited = new boolean[N][N];// 방문 배열 
			queue.offer(shark); // 현재 상어넣기 
//			System.out.println("현재상어위치 : "+shark.x+","+shark.y);
			visited[shark.x][shark.y]=true; // 현재 위치 방문처리
			
			while(!queue.isEmpty()) {
//				System.out.println("상어있음!!");
				Position now = queue.poll(); // 현재 상어 
				int dist = now.dist;
				
				for(int d=0; d<4;d++) {
					int nx = now.x+dx[d];
					int ny = now.y+dy[d];
					
					// 범위 벗어나고 이미 방문 했으면 넘기기 
					if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny])  continue;
					
					// 상어위치 바꾸고 먹기 가능한 생선 리스트에 넣기 
					if(map[nx][ny] !=0 && map[nx][ny]<size) {
//						System.out.println("먹이넣기성공");
						queue.offer(new Position(nx, ny, dist+1)); // 현재 아기상어 위치보다 거리+1
						fishes.add(new Position(nx, ny, dist+1)); // 먹이리스트 삽입 
						visited[nx][ny]=true; // 방문처리 
					}
					// 먹을 수는 없지만 지나가는 경우 
					else if(map[nx][ny]==0 || map[nx][ny]==size) {
//						System.out.println("그냥 지나감 ");
						queue.offer(new Position(nx, ny, dist+1)); // 상어위치만 바꾸기
						visited[nx][ny]=true; // 방문처리 
					}
				}
				
			}
			// 먹이 없다면 리턴 
			if(fishes.isEmpty()) return;
			
			// 먹이가 있는 경우 
			Position now_fish = fishes.get(0);
			for(int i=0; i<fishes.size(); i++) {
				// 거리가 최소인 먹이로 바꿔주기 
				if(now_fish.dist > fishes.get(i).dist)
					now_fish = fishes.get(i);
				// 거리가 같다면 가장 위에, 
				if (fishes.get(i).dist==now_fish.dist) {
					if(now_fish.x >fishes.get(i).x) {
						now_fish = fishes.get(i);
					} // 그리고 왼쪽 먹이로 바꿔주기 
					if(now_fish.x==fishes.get(i).x) {
						if(now_fish.y > fishes.get(i).y)
							now_fish = fishes.get(i);
					}
				}
			}
//			System.out.println("nowfish : "+now_fish.x+","+now_fish.y);
			
			help += now_fish.dist; // 먹을 물고기 거리를 추가 
//			System.out.println("help mom :"+help);
			count++; // 먹은 먹이 수 증가 
			map[now_fish.x][now_fish.y] =0; // 먹이 자리 0으로 
			
			// 상어 크기와 먹은 먹이 수 같은 경우  
			if(size==count) {
				size++; // 사이즈 1증가 
				count=0; // 먹은 먹이수 0으로 
			}
			
			shark.x = now_fish.x;
			shark.y = now_fish.y;
		}
	}
}