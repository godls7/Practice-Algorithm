package h0819;

import java.io.*;
import java.util.*;


// LinkedHashSet : LinkedList인데 set으로 중복허용안함 을 이용해보자!
public class Main_bj_1987_알파벳_서울_12반_이해인3 {
	
	static int R,C,count;
	static int[][] board;
	static int[] dx = {-1,0,1,0}; // 상우하좌
	static int[] dy = {0,1,0,-1}; //  상우하좌
	static boolean[] visited = new boolean[26];// 알파벳26개 체크

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		
		// 알파벳 입력받기 - int형으로..!!
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = input.charAt(j)-'A';
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(count);
		br.close();
	}
	
	static void dfs(int x, int y, int depth) {
		// 현재 알파벳이 이미 방문되었다면, 개수세주기
		if(visited[board[x][y]]) {
			count = Math.max(count, depth);
			return;
		}
		
		// 현재알파벳 방문처리
		visited[board[x][y]] = true;
		
		// 사방탐색하면서
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			
			// 범위 벗어나면 넘기기
			if(0>nx || nx>=R || 0>ny || ny>=C) continue;
			// 아니라면,dfs
			dfs(nx, ny, depth+1);
		}
		
		// dfs에서 return되면 방문처리없앰
		visited[board[x][y]] = false;
	}
}