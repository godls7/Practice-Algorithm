package s0809;

import java.io.*;
import java.util.*;

public class d3_5215_햄버거다이어트 {
	
	static int N, L, maxScore;
	static int material[][];
	static boolean isSelected[];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			material = new int[N][2];
			isSelected = new boolean[N];
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				material[j][0] = Integer.parseInt(st.nextToken());
				material[j][1] = Integer.parseInt(st.nextToken());
			}
			
			maxScore = 0;
			selectMaterial(0,0,0);
			sb.append("#").append(i+1).append(" ").append(maxScore).append("\n");
		}	
		System.out.println(sb);
		br.close();
	}
	
	static void selectMaterial(int idx, int scr, int cal) {
		
		if(cal>L) return; // 칼로리 초과하면 리턴
		if(cal<=L) maxScore = Math.max(maxScore, scr);
		if(idx == N) return; // 모든 조합 다 확인했으면 리턴
		
//		isSelected[idx] = true;
		selectMaterial(idx+1, scr+material[idx][0], cal+material[idx][1]);
//		isSelected[idx] = false;
		selectMaterial(idx+1, scr, cal);
		
	}

}