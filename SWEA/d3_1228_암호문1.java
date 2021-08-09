package s0809;

import java.io.*;
import java.util.*;

public class d3_1228_암호문1 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int n = 1;
		while(br.ready()) {
			sb.append("#").append(n++);
			
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 길이
			List<String> origin_code = new ArrayList<String>(); // 원본 암호문 저장할 ArrayList
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			// 원본암호문 입력
			for(int i=0; i<N;i++) {
				origin_code.add(st.nextToken());
			}
			
			int C = Integer.parseInt(br.readLine()); // 명령문 개수
			
			st = new StringTokenizer(br.readLine(), "I");
			for(int c=0; c<C; c++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken()," "); // 각 명령어
				int start = Integer.parseInt(st2.nextToken()); // 시작위치
				int count = Integer.parseInt(st2.nextToken()); // 개수
				
				for(int s=start; s<count+start; s++) { // 시작위치부터 개수만큼 원본 암호문에 삽입
					origin_code.add(s, st2.nextToken());
				}
			}
			
			for(int j=0; j<10; j++) {
				sb.append(" ").append(origin_code.get(j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
