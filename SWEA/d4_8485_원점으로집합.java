package s0928;

import java.io.*;
import java.util.*;

public class d4_8485_원점으로집합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		next:for(int t=1; t<=T; t++) {
			int N=Integer.parseInt(br.readLine()); // 점개수 
			int[] list = new int[N];
			int sum=0;
			int max=0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x0 = Integer.parseInt(st.nextToken());
				int y0 = Integer.parseInt(st.nextToken());
				list[i] = Math.abs(x0)+Math.abs(y0); // 차례대로 x,y 더하기 
				max = Math.max(max,list[i]);
			}
			
			for(int i=1; i<N;i++) {
				if(list[0]%2 != list[i]%2) {// 첫번째와 비교해 홀/짝이 통일되지 않으면 -1
					sb.append("#").append(t).append(" ").append(-1).append("\n");
					continue next;
				}
			}
			for(int i=0;;i++) {
				sum+=i;
				if(sum>=max && (sum%2)==(max%2)) { // 홀수/짝수가 같은 군만 
					sb.append("#").append(t).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
		br.close();
		
	}
}
