package s0809;

import java.io.*;
import java.util.*;

public class d3_9229_한빈이와SpotMart_duplicatefor {


	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int c=0; c<count; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // 과자봉지수
			int M = Integer.parseInt(st.nextToken()); // 최대 봉지무게
			
			// 과자봉지대입
			int[] chips = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				chips[n] = Integer.parseInt(st.nextToken());
			}
			
			int maxWeight = -1; // 최대무게 -1로 초기화
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(chips[i]+chips[j]<=M) maxWeight = Math.max(maxWeight, chips[i]+chips[j]);
					// 과자별로 비교하면서 최대값을 swap
					// 모든 경우가 M을 넘어갈 경우 -1
				}
			}

			sb.append("#").append(c+1).append(" ").append(maxWeight).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
