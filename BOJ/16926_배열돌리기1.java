package h0811;

import java.io.*;
import java.util.*;

// 돌아야하는 그룹수가 있다
//-> 행열 중 작은것의 /2 만큼 정의해줘야함

public class Main_bj_16926_배열돌리기1 {
	
	static int[] dx = {0,1,0,-1};// 우하좌상
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int group = Math.min(N, M)/2;

		for(int r=0; r<R; r++) { // 회전수 만큼
			for(int g=0; g<group; g++) { // 각 그룹마다
				int x=g ,y=g; 
				int start = arr[x][y]; // 그룹의 시작점 (왼쪽위 꼭짓점)
				
				int d=0;
				while(d<4) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(g<=nx && nx<N-g && g<=ny && ny<M-g) {
						arr[x][y] = arr[nx][ny];
						x=nx;
						y=ny;
					} 
					else d++; // 방향전환
				}
				arr[g+1][g] = start; // 시작점 아래에 시작점넣어주기
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}