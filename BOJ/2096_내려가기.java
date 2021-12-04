package s1122;

import java.io.*;
import java.util.*;

public class Main_bj_2096_내려가기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] max = new int[3];
		int[] min = new int[3];
		
		for(int i=0; i<N; i++) {
			int a0 = sc.nextInt();
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			// 맨첫줄은 입력
			if(i==0) {
				max[0] = min[0] = a0;
				max[1] = min[1] = a1;
				max[2] = min[2] = a2;
			}
			else {
				// 최댓값 
				int max0 = max[0], max2 = max[2];
				max[0] = Math.max(max[0], max[1])+a0;
				max[2] = Math.max(max[1], max[2])+a2;
				max[1] = Math.max(Math.max(max0, max[1]), max2)+a1;
				
				// 최솟값
				int min0 = min[0], min2 = min[2];
				min[0] = Math.min(min[0], min[1])+a0;
				min[2] = Math.min(min[1], min[2])+a2;
				min[1] = Math.min(Math.min(min0, min[1]), min2)+a1;
			}
		}
		System.out.print(Math.max(max[0], Math.max(max[1], max[2]))+" ");
		System.out.println(Math.min(min[0], Math.min(min[1], min[2])));
	}

}
