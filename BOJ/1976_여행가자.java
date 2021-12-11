package s1211;

import java.io.*;
import java.util.*;

public class Main_bj_1976_여행가자 {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		// 유니온 파인드 
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		int[] plan = new int[M+1];
		
		// 경로 셋팅 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 여행계획 셋팅 
		for(int i=1; i<=M; i++) {
			plan[i] = sc.nextInt();
		}
		
		// 부모 셋팅 
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]==1) {
					if(i<j) union(j,i); //처음부터 순서대로 그래프 만들기 
					else union(i,j);
				}
			}
		}
		
		int city = find(plan[1]); // 출발점 
		for(int i=2; i<plan.length; i++) {
			if(city != find(plan[i])) {// 루트순서대로 경로의 처음이 출발점인지 확인 
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");

	}
	
	static int find(int city) {
		if(parent[city] == city)
			return city;
		
		int p = find(parent[city]);
		return p;
	}
	
	static void union(int a, int b) {
		int c1 = find(a);
		int c2 = find(b);
		
		if(c1 != c2)
			parent[c1]=c2; 
	}

}
