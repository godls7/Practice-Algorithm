package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_2635_수이어가기 {
	
	static int N,max;
	static List<Integer> result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for(int i=N/2; i<=N; i++) {
			go(i);
		}
		sb.append(max).append("\n");
		for(int i=0; i<result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static void go(int i) {
		List<Integer> a = new ArrayList<>();
		a.add(N);
		a.add(i);
		while(true) {
			int first = a.get(a.size()-2);
			int second = a.get(a.size()-1);
			
			if(first-second >=0) {
				a.add(first-second);
			}
			else break;
		}
		
		if(max<a.size()) {
			result = new ArrayList<Integer>();
			for(int j=0; j<a.size(); j++) {
				result.add(a.get(j));
			}
			max = a.size();
		}
	}

}
