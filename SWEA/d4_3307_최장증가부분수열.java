package s0916;

import java.io.*;
import java.util.*;

public class d4_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int t=1; t<=T;t++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N]; // 각원소를 끝으로 하는 최장길이 
			
			for (int i = 0; i <N; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			
			int max=0;
			for(int i=0; i<N; i++) {
				LIS[i]=1;
				for(int j=0; j<i;j++) {
					if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
						LIS[i]= LIS[j]+1;
					}
				}
				if(max<LIS[i]) max=LIS[i];
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
