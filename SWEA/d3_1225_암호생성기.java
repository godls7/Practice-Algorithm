package s0805;

import java.io.*;
import java.util.*;

public class d3_1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(br.ready()) { // 읽을게 있는동안만
			int number = Integer.parseInt(br.readLine());
//			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> queue = new ArrayDeque<Integer>(); // 이게 더 빠름..
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int count = 0;
			while(true) {
				++count;
				int temp = queue.poll();
				if((temp-count) <= 0) {queue.offer(0); count=0; break;}
				else queue.offer(temp-count);
				
				if(count%5==0) count=0;
			}
			
			sb.append("#").append(number).append(" ");
			for(int i=0; i<8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}

}
