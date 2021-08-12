package h0810;

import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이개수
		int[][] paper = new int[101][101];
		
		int count=0;
		//먼저 입력받기
		for(int n=1; n<=N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			// 시작 좌표에서 길이 10 정사각형 만큼 1입력
			for(int x=X; x<X+10; x++) {
				for(int y=Y; y<Y+10; y++) {
					paper[x][y]=1;
				}
			}
		}
		
		for(int x=1; x<=100; x++) {
			for(int y=1; y<=100; y++) {
				if(paper[x][y]==1) count++;
			}
		}
		System.out.println(count);
	}
}