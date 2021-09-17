package h0917;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2 {
	
	static int N,M,answer;
	static int map[][], temp_map[][];
	static int[] dx = {-1,0,1,0}; // 상우하좌 
	static int[] dy = {0,1,0,-1};


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; // 섬 지도 
		temp_map = new int[N][M]; // 복사할 지도 
		
		// map 입력 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
