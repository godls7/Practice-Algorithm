package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_2527_직사각형 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			
			if((x2==x3 && y2==y3) || (x1==x4 && y1==y4) || (x2==x3 && y1==y4) || ()) { // 점인경우
				
			} else if() { // 선인경우
				
			} else if() { // 공통부분 없는 경우
				
			} else System.out.println("a");
		}
		
	}

}
