 package s0806;

import java.io.*;
import java.util.*;

public class d4_1861_정사각형방 {
	
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	
	static int N=0;
	static int[][] rooms;
	static int result_number = 0;
	static int result_count = 0;
	static int temp_count = 0;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			
			// 입력받기
			for(int x=0; x<N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int y=0; y<N; y++) {
					rooms[x][y] = Integer.parseInt(st.nextToken());
				}
			}

			int now = 0;
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					now = rooms[x][y]; // 현재 위치 방
//					System.out.printf("(%d,%d) : %d\n",x,y,now);
					temp_count++; // 우선 현재 방있으므로 path의 방개수 +1
					path(x,y,now);
				
					// 원래 최종 방이동수 보다 현재방기준으로 계산한 방이동수가 크다면
					// 또한 최종방이동수와 현재방 이동수가 같고 현재 방번호가 작으면
					if(result_count < temp_count || (result_count == temp_count && result_number > now)) { 
						result_count = temp_count; // 현재방기준 이동수 넣어주고
						result_number = now; // 현재방을 최종 값에 넣어줌
					}
					temp_count= 0;
				}
			}
			sb.append("#").append(i+1).append(" ").append(result_number).append(" ").append(result_count).append("\n");
			result_number = 0; result_count = 0; temp_count =0;
		}
		System.out.println(sb);
		br.close();
	}
	
	static void path(int x, int y, int now) {
		
		int in_now=0; // 현재 인접 방
		for(int d=0; d<4; d++) { // 현재 방에서 상하좌우 보면서
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0<=nx && nx<N && 0<=ny && ny<N && ((now+1) == rooms[nx][ny])) { // 범위안에 있고 현재방보다 1큰 경우
				in_now = rooms[nx][ny]; // 해당 방을 인정해주고
				temp_count++; // path의 방개수 +1
//				System.out.printf("들어옴 - (%d,%d) now:%d / temp : %d\n",nx,ny,in_now, temp_count);
				path(nx,ny, in_now); // 인접 방들 계속 확인
			}
		}
	}
}