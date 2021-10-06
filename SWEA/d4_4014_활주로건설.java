package s1006;

import java.io.*;
import java.util.*;

//1
//6 2
//3 3 3 2 1 1
//3 3 3 2 2 1
//3 3 3 3 3 2
//2 2 3 2 2 2
//2 2 3 2 2 2
//2 2 2 2 2 2

public class d4_4014_활주로건설 {
	
	static int N,X;
	static int map1[][],map2[][];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			map1 = new int[N][N];
			map2 = new int[N][N];
			int answer=0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map1[i][j]=Integer.parseInt(st.nextToken());
					map2[j][i]=map1[i][j]; // 행열뒤집어서 베열에 저장 
				}
			}
			
			for(int i=0; i<N; i++) {
				// 활주로 건설가능하면 answer+1 
				answer += check(map1[i]);
				answer += check(map2[i]);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	static int check(int[] arr) { // 활주로 건설가능하면 1, 아니면 0
		// 가로확인
		boolean[] check=new boolean[N];
		
		for(int i=0; i<N-1; i++) {
			int now = arr[i];
			int next = arr[i+1];
			
			if(Math.abs(now-next)>1) return 0; // 높이가 2 이상 차이나면 안됨 
			if(check[i+1] || now==next) continue; // 이미체크를 했거나 평지인경우 넘기기 
			
			if(now>next) { // 올라갈때 
				// 3 3 2 2 1 1
				for(int j=i+1; j<=i+X; j++) { // now의 다음부터 X길이 만큼 돌면서 
					// 범위 넘어가거나, 평지가 아니거나, 이미체크 했으면 
					if(j==N || arr[j]!=next || check[j]) return 0;
					check[j]=true; // 지형체크확인 체크 
				}
			} else { // 내려갈때 
				for(int j=i; j>i-X; j--) {
					// 범위 넘어가거나, 평지가 아니거나, 이미체크 했으면 
					if(j<0 || arr[j]!=now || check[j]) return 0;
					check[j]=true; // 지형체크확인 체크 
				}
			}
		}
		return 1;
	}
}