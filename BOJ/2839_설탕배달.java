package h0817;

import java.io.*;
import java.util.*;

public class Main_bj_2839_설탕배달 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		while(true) {
			if(N%5 ==0) {
				System.out.println(N/5+cnt);
				break;
			} else if(N <=0) {
				System.out.println(-1);
				break;
			} 
			N -= 3;
			cnt++;
		}
	}
}