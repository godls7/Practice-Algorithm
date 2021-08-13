package h0812;

import java.io.*;
import java.util.*;


// 부분집합
public class Main_bj_2961_도영이가만든맛있는음식 {
	
	static int[][] ingredent;
	static int N, min;
			
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ingredent = new int[N][2];
		min = Integer.MAX_VALUE;
		
		// 이차원배열에 신맛, 쓴맛 입력
		for(int n=0; n<N; n++) {
			ingredent[n][0] = Integer.parseInt(sc.next());
			ingredent[n][1] = Integer.parseInt(sc.next());
		}
		
		subset(0,1,0);
		System.out.println(min);
		sc.close();
	}
	
	static void subset(int cnt, int sin, int sson) {
		if(cnt==N) {
			int sub = Math.abs(sin-sson);
			if(sson!=0 && min > sub) {
				min = sub;
				return;
			}
			return;
		}

		// 현재재료 넣고 
		subset(cnt+1, sin*ingredent[cnt][0], sson+ingredent[cnt][1]);
		// 현재재료 안넣고
		subset(cnt+1, sin, sson);
	}
}