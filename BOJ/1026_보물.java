package study.algorithm;

import java.io.*;
import java.util.*;

// 휴... 순열 시간초과....ㄸㄹㄹ

public class Main_bj_1026_보물 {
	
//	static int N, min;
//	static int[] A,B, _A;
//	static boolean[] isSelect;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N = Integer.parseInt(br.readLine());
//		A = new int[N];
//		_A = new int[N];
//		B = new int[N];
//		isSelect = new boolean[N];
//		min = Integer.MAX_VALUE/2;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum=0;
		
		for(int i=0; i<N; i++) {
			sum += A[i]*B[N-1-i];
		}
		
		System.out.println(sum);
		br.close();
	}

	/*
	static void perm(int cnt,int sum) {
		
		if(cnt==N) {
			min = Math.min(min, sum);
		}
		
		for(int i=0; i<N; i++) {
			if(isSelect[i]) continue;
			isSelect[i] = true;
			_A[cnt] = A[i];
			perm(cnt+1, sum+A[i]*B[i]);
			isSelect[i]=false;
		}
	}
	*/
}
