package s0809;

import java.io.*;
import java.util.*;

public class d3_9229_한빈이와SpotMart_Combination {
	
	static int N,M, maxWeight;
	static int[] numbers = new int[2];
	static int[] chips;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int c=0; c<count; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // 과자봉지수
			M = Integer.parseInt(st.nextToken()); // 최대 봉지무게
			
			// 과자봉지대입
			chips = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				chips[n] = Integer.parseInt(st.nextToken());
			}
			maxWeight = 0;
			selecteSnack(0,0);
			
			if(maxWeight==0) maxWeight = -1; // maxweight가 조건에 안맞을 경우 초기값 그대로
			sb.append("#").append(c+1).append(" ").append(maxWeight).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void selecteSnack(int cnt, int start) {
		if(cnt==2) {
			int max = numbers[0]+numbers[1];
			if(maxWeight<max && max<=M)
				maxWeight = max;
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = chips[i];
			selecteSnack(cnt+1, i+1);
		}
	}
}
