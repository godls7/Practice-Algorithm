package s0928;

import java.io.*;
import java.util.*;

public class d4_8485_원점으로집합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N=Integer.parseInt(br.readLine()); // 점개수 
			int[] list = new int[N];
			int sum=0;
			int count=0;  // 움직이는 횟수 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x0 = Integer.parseInt(st.nextToken());
			int y0 = Integer.parseInt(st.nextToken());
			list[0] = Math.abs(x0)+Math.abs(y0); //첫번째좌표 x,y 더하기 
			int max =list[0];
			
			for(int i=1; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int xi = Integer.parseInt(st.nextToken());
				int yi = Integer.parseInt(st.nextToken());
				list[i] = Math.abs(xi)+Math.abs(yi); // 차례대로 x,y 더하기 
				max = Math.max(max, list[i]); // 최댓값 바꿔주기 
				if(list[i]%2 != list[i-1]%2) // 홀/짝이 통일되지 않으면 -1
					count=-1;
				
				// 홀/짝 통일 되었다면 원점에 도달하는 순간 찾기 
				if(count==0) {
					while(true) {
						boolean flag = true;
						if(sum<max || (max-sum)%2!=0) {
							flag=false;
						}
						if(flag) break;
						count++;
						sum += count;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}

}
