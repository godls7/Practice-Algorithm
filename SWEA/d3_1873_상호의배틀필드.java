package s0804;

import java.io.*;
import java.util.*;

// 입력
//1
//3 7
//***....
//*-..#**
//#<.****
//23
//SURSSSSUSLSRSSSURRDSRDS

// 출력
//#1 **....v
//.-..#..
//#......

public class d3_1873_상호의배틀필드 {
	
	// 상 하 좌 우
	static int[] dx= {-1,1,0,0}; 
	static int[] dy= {0,0,-1,1};
	static char[] dir_s = {'^','v','<','>'};
	
	// map
	static int H=0;
	static int W=0;
	static char[][] map;
	
	// 현재 전차위치
	static int X = 0; 
	static int Y = 0;
	static int dir = 0; // 현재 바라보는 방향
	
	static void action(int dir) { // 방향입력에 따라 조건확인
		map[X][Y] = dir_s[dir]; // 현재위치에서 방향먼저 바꿔주고
		int nx = X+dx[dir]; 
		int ny = Y+dy[dir];

		if(0<=nx && nx<H && 0<=ny && ny<W) {
			if(map[nx][ny] == '.') { // 이동할 좌표가 평지면
				map[X][Y] = '.'; // 현재를 평지로 바꿔주고
				X += dx[dir]; Y += dy[dir]; // 현재좌표 바꿔주기
				map[nx][ny] = dir_s[dir]; // 그리고 현재위치 방향 또한 바꿔주기
			}
//			System.out.printf("이동 : (%d,%d) %d\n",X,Y,dir);
		}
	}

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		for(int c=0; c<count; c++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			// map 입력받기
			for(int h=0; h<H; h++) {
				String line = br.readLine();
				for(int w=0; w<W; w++) {
					map[h][w] = line.charAt(w);
				}
			}
			// 사용자 입력받기
			int user = Integer.parseInt(br.readLine()); 
			char[] user_input = new char[user];
			String s = br.readLine();
			for(int u=0; u<user; u++) {
				user_input[u] = s.charAt(u);
			}
			
			// 현재 전차 위치,방향 찾기
			for(int x=0; x<H; x++) {
				for(int y=0; y<W; y++) {
					switch(map[x][y]){
						case '^' : X=x; Y=y; dir = 0; break;
						case 'v' : X=x; Y=y; dir = 1; break;
						case '<' : X=x; Y=y; dir = 2; break;
						case '>' : X=x; Y=y; dir = 3; break;
						default : break;
					}
				}
			}
			
			// 사용자 입력 하나씩 확인
			for(char u:user_input) {
//				System.out.printf("현재위치 : (%d,%d) %d\n", X,Y,dir);
				switch(u) {
					case 'U' : {
						dir=0; action(dir); break;
					}
					case 'D' : {
						dir=1; action(dir); break;
					}
					case 'L' : {
						dir=2; action(dir); break;
					}
					case 'R' : {
						dir=3; action(dir); break;
					}
					case 'S' : {
//						System.out.println("shoot");
						int nx = X+dx[dir];
						int ny = Y+dy[dir];
						while(true) {
//							System.out.printf("(nx,ny) = (%d,%d)\n",nx, ny);
							if(nx<0 || nx>=H || ny<0 || ny>=W || map[nx][ny] == '#') break;
							if(map[nx][ny] == '*') {map[nx][ny] = '.'; break;}
							nx += dx[dir];
							ny += dy[dir];
						}
						break;
					}
					default : break;
				}
				// 각각 map 출력
//				for(char[] m:map) {
//					System.out.println(Arrays.toString(m));
//				}
//				System.out.printf("이동후 : (%d,%d) %d\n",X,Y,dir);
			}
			sb.append("#").append(c+1).append(" ");
			for(char[] line:map) {
				sb.append(line).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}