package s0804;

import java.io.*;
import java.util.*;

public class d3_2805_농작물수확하기_dfs_bfs {
	
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N,m,sum,farm[][];
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int c=1; c<=count; c++) {
			int N = Integer.parseInt(br.readLine());
			m = (N-1)/2; // 가운데 값 
			farm = new int[N][N];
			v= new boolean[N][N];
			
			for(int i=0; i<N;i++) {
				String line = br.readLine();
				for (int j=0; j<N; j++) {
					farm[i][j] = line.charAt(j) - '0';
					// farm[i][j] = line.charAt(j)-'0'; // 대문자는 'A'로, 소문자는 'a'로 빼줌!
				}
			}
			sum = 0;
			dfs(m,m); // 가운데 값으로 넘기기
			bfs(m,m);
			sb.append("#").append(c).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		sum += farm[i][j];
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && (Math.abs(m-ni)+Math.abs(m-nj)<=m)) 
																// 맨해튼 distance방법 : 중심에서 해당좌표까지 가는 x,y 거리더한게
																// 중간값보다 작거나같아야해..!!헐...
				dfs(ni, nj);
		}
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		v[i][j] = true;
		sum += farm[i][j];
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0; d<4; d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && (Math.abs(m-ni)+Math.abs(m-nj)<=m)) {
					v[ni][nj] = true;
					sum += farm[ni][nj];
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
}