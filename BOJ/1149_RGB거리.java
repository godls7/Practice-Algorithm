package h0914;

import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리 {
	
	static int [][] cost;
	static int [][] dp;
	
	static int red = 0;
	static int green=1;
	static int blue=2;
	
	static int cal_cost(int n,int color) {
		
		if(dp[n][color]==0) { // 아직 비용계산이 안되어있는 경우
			if(color==red) // 현재 빨강인 경우, 이전집이 초록 혹은 파랑 이여야
				dp[n][red] = Math.min(cal_cost(n-1, green), cal_cost(n-1, blue))+cost[n][red];
			else if (color==green) // 현재 초록인 경우, 이전이 빨강 혹은 파랑  
				dp[n][green] = Math.min(cal_cost(n-1, red), cal_cost(n-1, blue))+cost[n][green];
			else  //  현재 파랑인경우, 이전이 빨강 혹은 초
				dp[n][blue] = Math.min(cal_cost(n-1, red), cal_cost(n-1, green))+cost[n][blue];
		}
		
		return dp[n][color]; //해당 색깔의 n번째집 비용 리턴 
	}
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		dp = new int[N+1][3];
		
		// 1~N집 별로 색상별 비용 입력 
		for(int i=1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp 배열에 1번째집 색깔별 비용 입
		dp[1][red] = cost[1][red];
		dp[1][green] = cost[1][green];
		dp[1][blue] = cost[1][blue];
		
		int min_cost = Math.min(cal_cost(N, red), Math.min(cal_cost(N,green), cal_cost(N, blue)));
		System.out.println(min_cost);
	}

}
