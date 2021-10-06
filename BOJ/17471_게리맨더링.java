package h1006;

import java.io.*;
import java.util.*;

public class Main_bj_17471_게리맨더링 {
	
	static int N,K,answer,sum, psum;
	static int people[], graph[][];
	static char part[];
	static boolean select[], visited[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		graph = new int[N+1][N+1];
		answer=987654321;
		
		// 인구수 입력 
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		
		// 인접구역 입력 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			for(int j=0; j<c; j++) {
				int now = Integer.parseInt(st.nextToken());
				graph[i][now]=1;
				graph[now][i]=1;
			}
		}
		
		// 두 선거구로 나누기-조합만들기
		// 구역수의 반만큼 돌리면 A선거구 조합생성, 나머지는 자동으로 B선거구 
		for(int i=0; i<(N/2)+1; i++) {
			K=i;
			select = new boolean[N+1];
			combi(1,0);
		}
		
		if(answer==987654321) System.out.println(-1);
		else System.out.println(answer);
		br.close();
	}

	// 두개 선거구로 나누기 
	static void combi(int start, int cnt) {
		if(cnt==K) {
			sum = 987654321;
			part = new char[N+1];
			// A,B 나눠진 선거구표시 
			for(int i=1; i<N+1; i++) {
				if(select[i]) part[i]='A';
				else part[i]='B';
			}
			search();
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<N+1; i++) {
			select[i]=true;
			combi(i+1, cnt+1);
			select[i]=false;
		}
	}

	// 구역이 올바르게 나누어졌나 검사 
	static void search() {
		// 구역이 나눠줬는지 체크하는 배열 
		visited=new boolean[N+1];
		
		int peopleA=0;
		int peopleB=0;
		
		for(int i=1; i<=N; i++) {
			// A구역에 속하고 아직 확인안한 경우  
			if(part[i]=='A' && !visited[i]) {
				psum=0;
				check(i);
				peopleA = psum;
				break;
			}
		}
		
		for(int i=1; i<=N; i++) {
			// B구역에 속하고 아직 확인안한 경우 
			if(part[i]=='B' && !visited[i]) {
				psum=0;
				check(i);
				peopleB = psum;
				break;
			}
		}
		
		// 방문안한경우가 있다면 끝 
		for(int i=1; i<=N; i++) {
			if(!visited[i]) return;
		}
		sum = Math.abs(peopleA-peopleB);
	}

	// 연결되어있는 경우 재귀를 돌며 올바르게 연결되어있는지 확인 
	static void check(int point) {
		visited[point]=true; //방문처리해주고
		psum += people[point]; // 현재구역 인구수 더해주기 
		for(int i=1; i<=N; i++) {
			// 이미 확인했거나, 구역이 다르거나, 두 지점이 연결이 안되어있으면 넘기기 
			if(visited[i] || part[i]!=part[point] || graph[i][point]!=1) continue;
			check(i);
		}
	}

}
