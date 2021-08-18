package h0818;

import java.io.*;
import java.util.*;

public class Main_bj_1992_쿼드트리 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];		
		
		// map에 주어진 수 입력받기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str.substring(j,j+1));
//				map[i][j] = str.charAt(j)-"0";
			}
		}
		
		divide(N,0,0);
		System.out.println(sb);
		br.close();
	}
	
	// 배열안에 요소들이 같은지 확인
	static boolean check(int n, int row, int col) {
		int now = map[row][col];
		
		for(int i=row; i<row+n; i++) {
			for(int j=col; j<col+n; j++) {
				if(now != map[i][j]) return false;
			}
		}
		return true;
	}
	
	// 2*2 단위로 나눔
	static void divide(int n, int row, int col) {
		if(check(n, row, col)) sb.append(map[row][col]);
		else {
			sb.append("(");
			divide(n/2, row, col); // 1사분면
			divide(n/2, row, col+n/2); // 2사분면
			divide(n/2, row+n/2, col); // 3사분면
			divide(n/2, row+n/2, col+n/2); //4사분면
			sb.append(")");
		}
	}
}