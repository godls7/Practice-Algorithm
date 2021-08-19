package h0819;

import java.io.*;
import java.util.*;

public class Main_bj_2630_색종이만들기 {
	
	static int N,white,blue;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	static void cut(int r, int c, int size){
		int sum=0;
		
		// 현재 시작점에서 size만큼 paper의 수 다 더하기
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				sum+=paper[i][j];
			}
		}
		
		if(sum==size*size) blue++; // 현재 다 1로 채워져 있다는 것=> 파랑 
		else if(sum==0) white++; // 현재 다 0으로 채워져 있다는 것 => 하얀
		else {
			int half = size/2; // 사이즈 반으로 줄이고
			cut(r, c, half); // 1사분면
			cut(r, c+half, half); // 2사분면
			cut(r+half, c, half); // 3사분면
			cut(r+half, c+half, half); // 4사분면
		}
	}
}
