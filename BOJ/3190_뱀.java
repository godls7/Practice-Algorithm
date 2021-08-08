package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_3190 {

	static int[] rot_x = {1,-1}; // R L
	static int[] rot_y = {-1,-1};
	static int N =0;
	static int[][] map;
	static int head_x;
	static int head_y;
	static int head_dir = 13; //D
	static int tail_x;
	static int tail_y;
	static int tail_dir = 13;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2]; // 사과있으면 1, 없으면 0, 뱀 위:11 아래:12 D(오른쪽):13 L(왼쪽):14
		map[1][1] = 2; // 뱀 (1,1)에서 시작
		
		//사과 넣기
		int apple_num = Integer.parseInt(br.readLine());
		for(int i=0; i<apple_num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
//		System.out.println(Arrays.deepToString(map));
		
		// 방향전환 받기
		Map<Integer, Character> rotation = new HashMap<Integer, Character>();
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			rotation.put(t, d);
		}
		System.out.println(rotation);
		
		int time=0;
		int nx=1;
		int ny=1;
		// 시작 오른쪽 방향
		int dx=0; 
		int dy=1; 
		
		// 사과 먹고, 조건 확인하면서 뱀 이동
		while(true) {
			time++;
			nx += dx;
			ny += dy;
			System.out.printf("now : (%d,%d)\n", nx, ny);
			
			if(nx<1 || nx>N || ny<1 || ny>N || map[nx][ny]>=2) break; // 범위에 벗어나거나 자신 몸이랑 만나면 게임종료
			
			// 그렇지 않다면
			if(map[nx][ny]==1) { // 사과가 있다면
				map[nx][ny] = head_dir; // 해당칸 뱀 섬렵 :방향값 넣어주기
				head_x = nx; // 뱀 시작위치바꿔주기
				head_y = ny;
			} else { //  사과가 없다면
				map[tail_x][tail_y] = 0; // 꼬리를 있는 칸을 0으로
				tranform_tail_direction(tail_dir);
				map[nx][ny] = head_dir; // 해당칸 뱀 섬렵 : 방향값 넣어주기
			}
			System.out.printf("머리:(%d,%d) 방향:%d / 꼬리:(%d,%d) 방향:%d\n", head_x, head_y, head_dir, tail_x, tail_y, tail_dir);
			
			if(rotation.containsKey(time)) {
				if(rotation.get(time) == 'D') {
					dx = rot_x[0];
					dy = rot_y[0];
					head_dir = 13;
				}
				else {
					dx = rot_x[1];
					dy = rot_y[1];
					head_dir = 14;
				}
			}
			System.out.printf("머리:(%d,%d) 방향:%d / 꼬리:(%d,%d) 방향:%d\n", head_x, head_y, head_dir, tail_x, tail_y, tail_dir);
		}
		System.out.println(time);
		br.close();
	}
	
	static void tranform_tail_direction(int dir) {
		switch (dir) {
		case 11: // 위
			tail_x -=1;
			tail_dir = map[tail_x][tail_y];
			break;
		case 12: // 아래
			tail_x +=1;
			tail_dir = map[tail_x][tail_y];
			break;
		case 13: // 오른
			tail_y +=1;
			tail_dir = map[tail_x][tail_y];
			break;
		case 14: // 왼
			tail_y -=1;
			tail_dir = map[tail_x][tail_y];
			break;
		}
	}
}