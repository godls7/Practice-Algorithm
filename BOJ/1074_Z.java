package h0817;

import java.io.*;
import java.util.*;

// 분할정복
public class Main_bj_1074_Z {
	
	static int N,r,c,count;
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int)Math.pow(2, N);
		
		solve(N,0,0);
		System.out.println(count);
		br.close();
	}
	
	static void solve(int n, int row, int col) {
		if(flag) return; // 재귀빠져나온 것들도 명시적으로 return 시켜줘야하니까 넣어줌!
		
		if(row==r && col==c) { // 찾으려고 하는 row,col과 같으면
			flag=true;
			return;
		}
		
		if(row<=r && r<row+n && col<=c && c<col+n) {
			solve(n/2, row, col);// 1사분면
			solve(n/2, row, col+n/2); // 2사분면
			solve(n/2, row+n/2, col); // 3사분면
			solve(n/2, row+n/2, col+n/2); // 4사분면
		}
		else {
			count += n*n;
			return;
		}
		
	}
}
