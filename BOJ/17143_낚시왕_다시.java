package h1001;

import java.io.*;
import java.util.*;

public class Main_bj_17143_낚시왕 {
	
	static class Shark{
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R,C,M;
	static int map[][], map_count[][];
	static int[] dr= {0,-1,1,0,0}; // 1:위 2:아래 3:오 4:왼
	static int[] dc= {0,0,0,1,-1};
	static Map<Integer,Shark> sharks = new HashMap<>();
	static Queue<Shark> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		map_count = new int[R+1][C+1];
		map[0][0] = -1; // 낚시왕위치 
		
		int number=1;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			// 들어온 순서대로 map과 상어 List에 넣어주기 
			map[r][c]=number;
			map_count[r][c]=1;
			sharks.put(number, new Shark(r, c, s, d, z));
			number++;
		}
		for(int[] m:map) System.out.println(Arrays.toString(m));
		
		int total=0;
		
		// 1.낚시왕 이동 
		for(int c=1; c<=C; c++) {
			map[0][c] = -1;
			
			// 오른쪽으로 한칸씩 이동 
			for(int r=1; r<=R; r++) {
				// 2.땅에 가까운 상어 잡기 
				if(map[r][c]!=0) {
					total += sharks.get(map[r][c]).z; // 크기를 더해주고
					map[r][c]=0; // map에서 지워주고 
					map_count[r][c]=0; // map_count에서 지워주고 
					sharks.remove(map[r][c]); // hashmap에서 지워주고 
				}
				// 3.상어이동
				move();
			}
		}
		System.out.println(total);
		br.close();
	}

	static void move() {
		int size = sharks.size();
		
		// 현재 남아있는 상어들 한마리씩 
		for(int key:sharks.keySet()) {
			Shark now = sharks.get(key);
//			int s = now.s;
			int d = now.d;
			// 속도만큼 이동 정해진 방향으로 이동 
			for(int s=0; s<now.s; s++) {
//				System.out.printf("방향:%d\n",d);
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				
				// 벽에 닿게 된다면 방향 바꾸고 이동후 넘기기 
				if(nr<1 || nr>R || nc<1 || nc>C) {
					d = change_dir(d);
					now.r += dr[d];
					now.c = dr[d];
					continue;
				}
				// 벽에 안닿는다면 같은 방향으로 이동 
				now.r = nr;
				now.c = nc;
			}
			int winner=0;
			// 이미 이동한 자리에 다른상어 있다면 두마리 이상 있는 위치
			if(map[now.r][now.c]>0) { // key가 있단 소리 
				int other_key=map[now.r][now.c];
				Shark other = sharks.get(other_key);
				// 둘중 사이즈 작은거 hashmap에서 지우기 
				if(now.z > other.z) {
					sharks.remove(other_key);
					winner = key;
				}
				else  {
					sharks.remove(key);
					winner=other_key;
				}
			}
			// 최종상어 map에 넣어주기 
			map[now.r][now.c] = winner;
		}
	}
	
	// 방향 바꾸기 
	static int change_dir(int d) {
		int cd=0;
		switch (d) {
		case 1:
			cd=2; break;
		case 2:
			cd=1; break;
		case 3:
			cd=4; break;
		case 4:
			cd=3; break;
		}
		return cd;
	}
}
