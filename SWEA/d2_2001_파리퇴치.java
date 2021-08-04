package s0804;

import java.io.*;
import java.util.*;

public class d2_2001_파리퇴치 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int c=0; c<count; c++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			// 파리개수 입력받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0; // 최종값
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					int sum = 0; // 각 위치 기준으로 파리채영역 총합
					if(x+M > N || y+M > N) continue; // 현재 위치에서 파리채크기가 map범위를 넘어가면 넘기기
					for(int a=x; a<M+x; a++) {
						for(int b=y; b<M+y; b++) { // 현재 위치에서 파리채크기만큼 순회
							if(a<0 || a>=N || b<0 || b>=N) break; // 순회중 파리채위치가 map 범위를 넘어가면 그만
							sum += map[a][b];							
						}
					}
					if(max<sum)	
						max = sum;
				}
			}
			sb.append("#").append(c+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();	
	}
}