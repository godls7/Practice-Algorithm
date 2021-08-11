package h0811;

import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3_서울_12반_이해인 {
	
	// arr배열 하나로 서로 이동되는게 겹치지 않게 움직여야함..!!!
	// (따로 배열선언해서 옮기느냐고.. 삽질했다ㅠㅠ)
	static int N,M,R;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		// 주어진 배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int r=0; r<R; r++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1: first(); break;
			case 2: second(); break;
			case 3: third(); break;
			case 4: fourth(); break;
			case 5: fifth(); break;
			case 6: sixth(); break;
			}
		}
		
		for(int[] row:arr) {
			for(int r:row) { sb.append(r).append(" "); }
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// 반잘라서 swaping...
	static void first() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M; j++) {
				int t = arr[i][j];
				arr[i][j] = arr[(N-i)-1][j];
				arr[(N-i)-1][j] = t;
			}
		}
	}

	static void second() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				int t = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = t;
			}
		}
	}
	
	static void third() {
		// 행열을 바꾼 임시배열선언
		int[][] temp = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 원래배열의 열->행, 행->맨뒤열부터
				temp[j][N-i-1] = arr[i][j];
			}
		}
		int t=M; M=N; N=t; // N,M의 위치 바꿔주기..!
		arr = temp; // 계산한 temp도 arr로 옮겨주기
	}
	
	static void fourth() {
		int[][] temp = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[M-j-1][i] = arr[i][j];
			}
		}
		int t=M; M=N; N=t; // N,M의 위치 바꿔주기..!
		arr = temp; // 계산한 temp도 arr로 옮겨주기
	}
	
	static void fifth() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				int t = arr[i][j];
				arr[i][j] = arr[N/2+i][j];
				arr[N/2+i][j] = arr[N/2+i][M/2+j];
				arr[N/2+i][M/2+j] = arr[i][M/2+j];
				arr[i][M/2+j] = t;
			}
		}
	}
	
	static void sixth() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				int t = arr[i][j];
				arr[i][j] = arr[i][M/2+j];
				arr[i][M/2+j] = arr[N/2+i][M/2+j];
				arr[N/2+i][M/2+j] = arr[i+N/2][j];
				arr[i+N/2][j] = t;
			}
		}
	}
}