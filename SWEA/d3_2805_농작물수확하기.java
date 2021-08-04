package s0804;

import java.io.*;
import java.util.*;

public class d3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int c=0; c<count; c++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N;i++) {
				String line = br.readLine();
				for (int j=0; j<N; j++) {
					farm[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			
			int sum= 0;
			int half = N/2+1;
			for(int i=0; i<half;i++) {
				int k=0;
				for(int j=0; j<N/2-i; j++) { // 빈공간 띄는것 만큼 k++ k:열의 인덱스
					k++;
				}
				for(int z=0; z<2*i+1; z++) {
					sum += farm[i][k];
					k++;
				}
			}
			
			for(int i=N-half; i>0; i--) { // 2 1 -> 4 5
				int k=0;
				for(int j=0; j<N/2-i+1; j++) {
					k++;
				}
				for(int z=0; z<2*i-1; z++) {
					sum += farm[N-i][k];
					k++;
				}
			}
			sb.append("#").append(c+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
