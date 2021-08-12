package h0812;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이 {
	
	static int input[]; // 입력값
	static int real[]; // 진짜 난쟁이
	static int size = 9;
	static int size_t = 7;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[size];
		real = new int[size_t];
		
		for(int i=0; i<size; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		br.close();
	}

	static void combination(int cnt, int start) {
		
		if(cnt==size_t) {
			int sum=0;
			for(int r:real) {
				sum += r;
			}
			if(sum==100) {
				for(int r:real) {
					sb.append(r).append("\n");
				}
			}
			return;
		}
		
		for(int i=start; i<size; i++) {
			real[cnt] = input[i];
			combination(cnt+1,i+1);
		}
		return;
	}
}
