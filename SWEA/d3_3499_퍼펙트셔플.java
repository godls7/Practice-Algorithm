package s0806;

import java.io.*;
import java.util.*;

public class d3_3499_퍼펙트셔플 {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		ArrayDeque<String> queue1 = new ArrayDeque<>();
		ArrayDeque<String> queue2 = new ArrayDeque<>();
		
		for(int i=0; i<count; i++) {
			int number = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb.append("#").append(i+1);
			
			if(number%2==0) {
				for(int n=0; n<number/2; n++) 
					queue1.offer(st.nextToken());
				
				for(int n=number/2; n<number; n++) 
					queue2.offer(st.nextToken());
			}
			else {
				for(int n=0; n<number/2+1; n++) 
					queue1.offer(st.nextToken());
				
				for(int n=number/2+1; n<number; n++) 
					queue2.offer(st.nextToken());
			}
			
			/*// 오.....역시 수학을 잘해야해
			 * for(int n=0; n<number/2+(N%2); n++) // (N%2) 더해서 홀수처리 
				queue1.offer(st.nextToken());
			
			for(int n=number/2+(N%2); n<number; n++) 
				queue2.offer(st.nextToken());
			*/
			
			
			for(int o=0; o<number/2+1; o++) {
				if(!queue1.isEmpty()) sb.append(" ").append(queue1.poll());
				if(!queue2.isEmpty()) sb.append(" ").append(queue2.poll());
			}
	
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}