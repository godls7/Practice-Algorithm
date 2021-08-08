package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_17298_v2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>(); // input의 인덱스를 넣어줄 공간으로 생각
		int[] input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 먼저 입력받기
		for(int n=0; n<N; n++) {
			input[n]= Integer.parseInt(st.nextToken());
		}
		
		// 비교하면서 스택에 넣어주기
		for(int n=0; n<N; n++) {
			
			while(!stack.isEmpty() && input[stack.peek()] < input[n]) {
				input[stack.pop()]= input[n];
			}
			
			stack.push(n);
//			System.out.println(Arrays.toString(input));
//			System.out.println(stack);
		}
		
		while(!stack.isEmpty()) {
			input[stack.pop()] = -1;
		}
		
		for(int i=0; i<N;i++) {
			sb.append(input[i]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}