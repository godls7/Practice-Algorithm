package s0802;

import java.io.*;
import java.util.*;

public class d2_1204_최빈수구하기 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1204.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int case_c = Integer.parseInt(br.readLine());

		for(int i=0; i<case_c; i++) {
			int[] scores = new int[101];
			int number = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			while(st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());
				scores[score]++;
			}
			
			int max = 0;
			int idx = 0;
			for(int j=0; j<scores.length; j++) {
				if(max<=scores[j]) {
					max = scores[j];
					idx = j;
				}
			}
			System.out.printf("#%d %d\n",number,idx);
//			Arrays.fill(scores, 0);
		}
		br.close();
	}
}
