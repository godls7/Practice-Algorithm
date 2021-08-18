package h0817;

import java.io.*;
import java.util.*;

public class Main_bj_3025_돌던지기 {
	
	static int R,C,N;
	static char[][] map;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// map크기와 원소 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j]= line[j];
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		// 날아온 화산탄 순서대로 queue에 저장
		N = Integer.parseInt(br.readLine());
		queue = new LinkedList<>();
		for(int n=0; n<N; n++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
//		System.out.println(queue);
		
//		
		
		while(!queue.isEmpty()) {
			int now_col = queue.poll()-1;
//			System.out.println(queue);
//			System.out.println("now_row : "+now_row);
			dfs(now_col,0); // 날라오는 화산탄별로 dfs 탐색
			
			for(char[] m:map) System.out.println(Arrays.toString(m));
			System.out.println();
			
		}
	}

	static void dfs(int now_col, int start) {
//		System.out.println(now_row);
		for(int r=start; r<R; r++) { // 행을 돌면서
			int now_row = r-1;
//			System.out.println("현재행 : "+r+"현재열 :"+now_row);
			if(map[r][now_col]=='X') { // 아래에 장애물이나 땅을 만나면
//				System.out.println("장애물 만남");
				map[r-1][now_col] = 'O'; // 그 자리에 굳기
				return;
			} 
			else if(r+1==R) {
//				System.out.println("땅끝");
				map[r][now_col] = 'O'; // 그 자리에 굳기
				return;
			}
			
			else if(map[r][now_col]=='O') { // 아래에 굳은 돌을 만나면
//				System.out.println("굳은돌 만남");
				// 왼쪽과 왼쪽아래가 비어있을 경우
				if(0<=now_col-1 && r-1<R && map[r][now_col-1] =='.' && map[r-1][now_col-1]=='.') {
//					System.out.println("왼쪽 행: "+(now_row-1));
					dfs(now_col-1, r-1); // 현 위치에서 왼쪽 위치로 다시 아래로 굴러떨어짐 (dfs)
				}
				// 오른쪽과 오른쪽아래가 비어있을 경우
				else if(0<=now_col+1 && r-1<R && map[r][now_col+1] =='.' && map[r-1][now_col+1]=='.') {
//					System.out.println("오른쪽 열: "+(now_row+1)+" 현재행 : "+(r-1));
					dfs(now_col+1, r-1); // 현 위치에서 왼쪽 위치로 다시 아래로 굴러떨어짐 (dfs)
				}
			}
		}
	}
}