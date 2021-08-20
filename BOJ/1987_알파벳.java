package h0819;

import java.io.*;
import java.util.*;


// LinkedHashSet : LinkedList인데 set으로 중복허용안함 을 이용해보자!
public class Main_bj_1987_알파벳_서울_12반_이해인2 {
	
	static int R,C,count;
	static char[][] board;
	static int[] dx = {-1,0,1,0}; // 상우하좌
	static int[] dy = {0,1,0,-1}; //  상우하좌
	static String visit;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visit = "";
		
		// 알파벳 입력받기
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0);
		System.out.println(count);
		br.close();
	}
	
	static void dfs(int x, int y) {
		// 현재 알파벳 넣어주기
		visit += board[x][y];
		// count와 visit 길이 비교해서 크면 count에 저장
		if(count<visit.length())
			count=visit.length();
		
		// 사방탐색하면서
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			
			// 범위 벗어나거나, 예전 경로중 같은 알파벳이면 넘기기
			if(0>nx || nx>=R || 0>ny || ny>=C || visit.contains(Character.toString(board[nx][ny]))) 
				continue;
			// 아니라면,dfs
			dfs(nx, ny);
			// dfs에서 return되었다면, 마지막 알파벳 빼기
			visit = visit.substring(0,visit.length()-1);
		}
	}
}