package study.algorithm;

import java.util.*;
import java.io.*;

public class Main_bj_2512_예산 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] money = new int[N];
		int sum =0;
		int max=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			sum += money[i];;
			max = Math.max(max, money[i]);
		}
	
//		System.out.println(Arrays.toString(money));
		
		int total = Integer.parseInt(br.readLine());
		
		if(sum<=total) { //모든 요청 배정 가능 
			System.out.println(max);
		} else {
			int result = 0; // 상한값 
			int min=0;
			int mid=0;
			
			// 이분탐색 
			while(true) {
				mid = (min+max)/2; // mid가 현재 상한선이라고 생각 
				sum = 0;
				if(mid==min) { // 모든값이 최솟값이란 의미 
					break;
				}
				for(int i=0; i<N; i++) { // 평균값이랑 비교하면서 다시 총합구하기 
					sum += (mid<money[i])? mid : money[i];
				}
				if(sum <= total) {  // 전체 총값이 현재 더한값보다 크면 
					result = Math.max(mid, result); // 더큰값을 최종 결과값에 넣기 
					min = mid; // 현재 평균값을 최솟값으로 설정 
				} else {
					max = mid;
				}
			}
			System.out.println(result);
		}
		
		br.close();
	}
	
}
