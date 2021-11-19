package s1122;

import java.io.*;
import java.util.*;

public class Main_bj_11399_ATM {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] person = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(person);
//		System.out.println(Arrays.toString(person));
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++){
				sum += person[j];
			}
		}
		
		System.out.println(sum);
	}

}
