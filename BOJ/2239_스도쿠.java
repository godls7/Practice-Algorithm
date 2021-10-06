package h1006;

import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠 {
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int board[][];
	static List<Point> list=new ArrayList<>();
	static boolean finished=false;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		board = new int[9][9];
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j]=input.charAt(j)-'0';
				// 0인칸 넣어주기 
				if(board[i][j]==0) list.add(new Point(i, j));
			}
		}
		int size=list.size();
		play(size,0);
		
		br.close();
	}

	static void play(int size,int cnt) {
		// 기저조건 
		if(size==cnt) {
			finished = true;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			return;
		}
		if(finished) return;
		
		// 0인칸 좌표
		int x = list.get(cnt).x;
		int y = list.get(cnt).y;
		
		for(int i=1; i<10; i++) {
			// 이미 사용되었다면 넘기기  
			if(!check(x,y,i)) continue;
			board[x][y]=i; // 해당값 넣어주고 
			play(size,cnt+1); // 재귀 
			board[x][y]=0;
		}
	}
	
	static boolean check(int x, int y, int value) {
		// 가로에서 0~9 중 이미 있는 숫자 체크  
		// 세로에서 0~9 중 이미 있는 숫자 체크
		for(int i=0; i<9; i++) {
			if(board[x][i]==value) return false;
			if(board[i][y]==value) return false;
		}
		// 3*3 정사각에서 0~9 중 이미 있는 숫자 체크 
		int nx = (x/3)*3;
		int ny = (y/3)*3;
		for(int i=nx; i<nx+3; i++) {
			for(int j=ny; j<ny+3; j++) {
				if(board[i][j]==value) return false;
			}
		}
		return true;
	}
}
