package h0805;

import java.io.*;
import java.util.*;

public class Main_bj_2493_탑_v2 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<int[]> stack = new ArrayDeque<>(); // {번호, 높이}
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=N; i++) {
			int now = Integer.parseInt(st.nextToken()); // 현재 탑
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] < now) {
					stack.pop();
				}
				else {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
			}
			if(stack.isEmpty()) sb.append("0 ");
			stack.push(new int[] {i,now});
		}
		
		System.out.println(sb);
		br.close();
	}
}