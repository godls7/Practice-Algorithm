package s0819;

import java.io.*;
import java.util.*;

public class d3_2806_NQueen {
	
	static int N,cnt; // 퀸 개수, 경우의수
	static int[] col; // 열위치 저장할 배열

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			col = new int[N];
			cnt=0;
			
			setQueen(0); // 행번호 넘기기
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();	
	}
	
	static void setQueen(int rowNum) {
		
		// 길이보다 같거나 커지면 끝이자나 return
		if(rowNum>=N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			col[rowNum] = i; // 해당행에 열을 하나씩 넣으면서 탐색
			if(isAvailable(rowNum)) setQueen(rowNum+1); // 그다음 행으로 넘기기
		}
	}
	
	static boolean isAvailable(int rowNum) {
		// 지금 꺼의 이전까지 하나씩 확인하면서
		for (int i = 0; i < rowNum; i++) {
			// 현재와 이전것들의 열이 같거나, 혹은 대각선에 있다면(둘이 행의차, 열의차가 같을때) 안대지 false
			if(col[rowNum]==col[i] || Math.abs(col[rowNum]-col[i]) == (rowNum-i)) return false;
		}
		return true;
	}
}
