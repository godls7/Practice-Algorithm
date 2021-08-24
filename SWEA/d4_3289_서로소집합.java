package s0824;

import java.io.*;
import java.util.*;

public class d4_3289_서로소집합 {
	
	static int N;
	static int[] parents;
	
	static void make() {
		for (int i=1; i<=N; i++) {
			parents[i] = i; // 자기 자신을 대표로 만듬
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a; //대표가 자기자신이란 소리
		return parents[a] = find(parents[a]); // 자신의 대표 찾아가면서 상위대표를 설정해주며 리턴
	}
	
	static boolean union(int a,int b) { // 두원소를 하나의 집합으로합치기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false; //이미같은 집합 
		parents[bRoot] = aRoot; // b대표자를 a로 바꿔줌
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // 정점
			int M = Integer.parseInt(st.nextToken()); // 연산수
			parents = new int[N+1];
			sb.append("#").append(T).append(" ");
			
			make();
			System.out.println(Arrays.toString(parents));
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				int tag = Integer.parseInt(st.nextToken());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
				switch (tag) {
				case 0:
					boolean input = union(first, second);
					System.out.println(input);
					System.out.println(Arrays.toString(parents));
					break;
					
				case 1:
					if(find(first)==find(second)) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
