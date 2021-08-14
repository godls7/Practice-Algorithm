package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_1759_암호만들기 {
	
	static int L,C;
	static boolean[] v;
	static char[] input;
	static StringBuilder sb;
	

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		v = new boolean[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			input[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(input); // 처음에 정렬 먼저하기
		combi(0,0);
		br.close();
	}

	static void combi(int cnt, int start) {
		if(cnt==L) {
			sb = new StringBuilder();
			int r=0; // 모음개수
			int s=0; // 자음개수
			for(int i=0; i<C; i++) {
				if(v[i]) { // 선택된 알파벳중에
					sb.append(input[i]);
					if(input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u') {
						r++;
					}else s++;
				}
			}
			if(r>=1 && s>=2) System.out.println(sb);
			return;
		}
		
		for(int i=start; i<C; i++) {
			v[i] = true;
			combi(cnt+1, i+1);
			v[i] = false;
		}
	}
}
