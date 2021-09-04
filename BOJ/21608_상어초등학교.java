package study.algorithm;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main_bj_21608_상어초등학교 {
	
	static int N;
	static int s_num;
	static int[] student_list;
	static int[][] student_like;
	static int[][] map;
	static int[] dx = {-1,0,1,0}; // 상우하좌 
	static int[] dy = {0,1,0,-1}; 
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		s_num = N*N; // 학생수 
		student_list = new int[s_num]; // 학생순서 
		student_like = new int[s_num+1][4]; // 각학생이 좋아하는 학
		map = new int[N][N];
		
		for(int i=0; i<s_num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int now = Integer.parseInt(st.nextToken());
			student_list[i] = now;
			for(int j=0; j<4; j++) {
				student_like[now][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.toString(student_list));
//		System.out.println(Arrays.deepToString(student_like));
		
		// 첫번째 학생넣기
		map[N/2][N/2] = student_list[0];
				
		for(int i=1; i<s_num; i++) { // 학생리스트 순서대
			int now = student_list[i]; // 현재 학생 
			int[] likes = student_like[now]; // 현재 학생이 좋아하는 학생들 
			
			int max = 0;
			List<int[]> selecet_position = new ArrayList<>();
			
			// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			// 0,0 부터 돌면서 
			for(int x=0; x<N; x++) { 
				for(int y=0; y<N; y++) {
					int count=0;
					for(int d=0; d<4; d++) {
						int nx = x+dx[d];
						int ny = y+dy[d];
						
						// 범위를 벗어나거나 이미 채워져 있으면 넘기기 
						if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
						
						// 좋아하는 학생이 있다면 
						for(int l=0; l<4; l++) {
							if(map[nx][ny] == likes[l]) count++;
						}
					}
					
					if(count>max) {
						selecet_position.clear();
						selecet_position.add(new int[] {x,y});
						max = count;
					} else if (count==max) {
						selecet_position.add(new int[] {x,y});
					}
				}
			}
			
			// 2.1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
			
			
			// 3.2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
			
			for(int[] s:selecet_position) {
				System.out.print(Arrays.toString(s));
			}
			System.out.println(Arrays.deepToString(map));
		}
		
		br.close();
	}
	
	
}
