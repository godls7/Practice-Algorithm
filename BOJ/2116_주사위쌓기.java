package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_2116_주사위쌓기 {
	
	static int sum;
	static int N;
	static int[][] dice;

	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		// 주사위 입력
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(dice));
		
		int max = -1;
		// 주사위 각 번호 돌면서
		for(int i=0; i<6; i++) {
			sum = 0;
			dfs(0, i);
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
	
	static void dfs(int floor, int bottom) {
		if(floor==N) return; //주사위 5개 다 배치했으면 끝
		
		int top = -1;
		switch (bottom) { // 현재 bottom에 top 매치
			case 0: top = 5; break;
			case 1: top = 3; break;
			case 2: top = 4; break;
			case 3: top = 1; break;
			case 4: top = 2; break;
			case 5: top = 0; break;
		}
		int max = -1;
		int next = -1;
		
		for (int i = 0; i <6; i++) { //현재 주사위 번호 순서대로 돌면서
			if(floor<N-1 && dice[floor+1][i]==dice[floor][top]) // 주사위가 마지막경우가 아니고, 현재 top과 다음 bottom이 같으면
				next = i; // 해당 수 다음 bottom으로 넘겨주기
				
			if(i!=bottom && i!=top) { // 현재가 bottom, top이 아닐경우 옆면이란 소리
				max = Math.max(max, dice[floor][i]); // 현재 주사위 값이랑 max랑비교해서 max값 넣어주기
			}
		}
		sum += max; // sum값에 넣어주고
		dfs(floor+1, next); // 다음 주사위로 넘어가기
	}
}
