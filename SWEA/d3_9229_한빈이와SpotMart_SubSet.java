package s0809;

import java.io.*;
import java.util.*;

public class d3_9229_한빈이와SpotMart_SubSet {
	
	static int N,M, maxWeight;
	static int[] chips;
	static boolean[] isSelected;

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
			isSelected = new boolean[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				chips[n] = Integer.parseInt(st.nextToken());
			}
			maxWeight = 0;
			selecteSnack(0);
			
			if(maxWeight==0) maxWeight = -1; // maxweight가 조건에 안맞을 경우 초기값 그대로
			sb.append("#").append(c+1).append(" ").append(maxWeight).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void selecteSnack(int idx) {
		
		int pass= 0;
		int sum=0;
		for(int i=0;i<N;i++) {
			if(isSelected[i]) pass++;
		}
		
		if(pass==2) {
			for(int j=0; j<N; j++) {
				if(isSelected[j]) sum += chips[j];
			}
		}
		if(maxWeight<sum && sum<=M) {
			maxWeight = sum;
			return;
		}
		if(idx==N) return;
		
		isSelected[idx] = true;
		selecteSnack(idx+1); // 현재 과자 포함한 경우
		isSelected[idx] = false;
		selecteSnack(idx+1); // 현재 과자 포함하지 않은 경우
		
		
	}

}
