package h0805;

import java.io.*;
import java.util.*;

public class Main_bj_2493_탑_서울_12반_이해인_v1 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<Integer> idx = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		stack.push(Integer.parseInt(st.nextToken()));
		idx.push(0);
		
		label:for(int i=1; i<N; i++) {
			int now = Integer.parseInt(st.nextToken()); // 현재 탑

			while(!stack.isEmpty()) {
				if(stack.peek() < now) {// 이전 탑이 지금 탑보다작다면 -> 필요없는것들 다 빼기
					stack.pop(); // 이전 탑 빼버리기
					idx.pop(); // 인덱스도 빼기
				}
				else { // 이전 탑이 크거나 같다면
					stack.push(now);
					result[i] = idx.peek()+1; // 큰 것의 인덱스 받아와서 넣기
					idx.push(i); // 현재것의 인덱스 넣기
					continue label;
				}
			}
			// 비어 있거나, 이전것보다 크다면
			stack.push(now);
			result[i] = 0;
			idx.push(i); // 큰 것의 인덱스 넣기
		}
		
		for(int r:result) {
			sb.append(r).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}