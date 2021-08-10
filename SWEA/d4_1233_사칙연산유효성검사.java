package s0810;

import java.io.*;
import java.util.*;

public class d4_1233_사칙연산유효성검사 {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 중위로 풀어야해
		// dfs 왼->자신->오 로 돌면서 '자신'이 연산자가 아니면 => 1
		for(int c=0; c<10; c++) {
			int N = Integer.parseInt(br.readLine()); // 노드수
			char[] nodes= new char[N+1];
			int answer=1;
			
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int num = Integer.parseInt(st.nextToken());
				nodes[num] = st.nextToken().charAt(0);
			}
			
//			System.out.println(Arrays.toString(nodes));
			
			for(int j=1; j<=N; j++) {
				if(nodes[j]>='0' && nodes[j]<='9') { // 숫자일때
					if(j<=N/2) { // 부모노드이면
						answer=0; // 무효
						break;
					}
				} else { // 연산자인데
					if(j>N/2) { // 리프노드이면
						answer=0; // 무효
						break;
					}
				}
			}
			sb.append("#").append(c+1).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
}
