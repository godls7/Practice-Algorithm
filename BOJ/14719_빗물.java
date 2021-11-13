package s1115;

import java.io.*;
import java.util.*;

public class Main_bj_14719_빗물 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int left=0, right=0, rain=0;
		
		// 모이는 빗물 계산 (1번 마지막기둥은 제외)
		for(int i=1; i<W-1; i++) {
			left = right =0;
			// 왼쪽 최대 
			for(int j=0; j<i; j++) {
				left = Math.max(map[j], left);
			}
			// 오른쪽 최대
			for(int j=i+1; j<W; j++) {
				right = Math.max(map[j], right);
			}
			
			// 왼오중 낮은거 기준으로 빗물 계산
			if(map[i] <left && map[i]<right) {
				rain += Math.min(left, right)-map[i];
			}
		}
		System.out.println(rain);
		
	}

}
