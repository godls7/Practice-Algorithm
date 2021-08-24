package s0824;

import java.io.*;
import java.util.*;

public class d4_7465_창용마을무리의개수_서울_12반_이해인 {
	
	static int N,M; // 사람수,관계수
	static int[] jjang; // 부모원소 관리
	
	// 초기집합 만들기
	static void make() {
		for(int i=1; i<=N; i++) {
			jjang[i] =i; // 자신은 대표로 만듬
		}
	}
	
	// 대표찾기
	static int find(int a) {
		if(a==jjang[a]) return a; // 자신의 대표자
		return jjang[a] = find(jjang[a]); // a부터 위로거슬러 가면서 제일 짱을 짱으로 설정해주기
	}
	
	// 합치기
	static void union(int a, int b) {
		int aJJang = find(a);
		int bJJang = find(b);
		if(aJJang != bJJang) jjang[bJJang] = aJJang; // b의 짱을 a로 설정
	}

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // 1~N 까지 사람
			jjang = new int[N+1];
			M = Integer.parseInt(st.nextToken());
			
			make();
			
			for(int m=1; m<=M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int cnt=0;
			boolean[] ans = new boolean[N+1];
			for(int i=1;i<=N; i++) {
				int p = find(i); // 부모찾음
				if(!ans[p]) cnt++; // 아직대표선택 안됬으면 카운트증가
				ans[p]=true; // 그리고 대표로 선택해쥼
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}

}
