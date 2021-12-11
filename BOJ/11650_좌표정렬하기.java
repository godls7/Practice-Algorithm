package s1211;

import java.io.*;
import java.util.*;

public class Main_bj_11650_좌표정렬하기 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[][] dot = new int[N][2];
		
		for(int i=0; i<N; i++) {
			dot[i][0] = sc.nextInt();
			dot[i][1] = sc.nextInt();
		}
		
//		System.out.println(Arrays.deepToString(dot));
		
		Arrays.sort(dot, (o1,o2)->{
			int diff = Integer.compare(o1[0], o2[0]);
			return (diff==0)? Integer.compare(o1[1], o2[1]):diff;
			
		});
		
//		System.out.println(Arrays.deepToString(dot));
		
		for(int i=0; i<N; i++) {
			sb.append(dot[i][0]).append(" ").append(dot[i][1]).append("\n");
		}
		
		System.out.println(sb);

	}

}
