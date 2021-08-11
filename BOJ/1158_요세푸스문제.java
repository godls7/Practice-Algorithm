package h0810;

import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 원으로 돌아갈 큐 선언 후,넣어주기
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) { // 한개가 남을때까지
			for(int j=0;j<K-1; j++) { // K보다 하나적게 빼고 뒤에 queue에 다시 넣어주기
				queue.offer( queue.poll());
			}
			sb.append(queue.poll()).append(", "); // K번째 빠지는걸 출력
		}
		sb.setLength(sb.length()-2); // 현재 길이에서 2칸 자르기
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}
}