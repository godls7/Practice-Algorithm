package h1005;

import java.io.*;
import java.util.*;

public class Main_bj_15961_회전초밥 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 접시수 
		int d = Integer.parseInt(st.nextToken()); // 초밥가짓수 
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시수 
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호 (하나더 먹을수 있는 초밥) 
		
		int[] plates = new int[n]; // 회전접시 
		int[] eat = new int[d+1]; // 먹은것 
		
		// 접시에 초밥 담기 
		for(int i=0; i<n; i++) {
			plates[i] = Integer.parseInt(br.readLine());
		}
		
		int count=0, max=0;
		for(int i=0; i<k; i++) {
			if(eat[plates[i]]==0) count++; // 처음 먹는 초밥 +1 
			eat[plates[i]]++;
		}
//		System.out.println(Arrays.toString(eat));
//		System.out.println(count);
		max=count;
		
		// 다음 접시부터 끝 접시까지 돌면서 
		for(int i=1; i<n; i++) {
			// 최대 초밥가짓수 가질때까지 
			if(max<=count) {
				// 아직 쿠폰초밥을 안먹었으면 +1 
				if(eat[c]==0) max=count+1;
				// 이미 먹었으면 그대로 
				else max=count;
			}
			eat[plates[i-1]]--; // 처음초밥 빼기 
			if(eat[plates[i-1]]==0) count--; // 처음초밥 남아있지 않다면 count -1 
//			System.out.println(Arrays.toString(eat));
			
			if(eat[plates[(i+k-1)%n]]==0) count++; // 4칸뒤 초밥 아직 안먹었다면 count+1 
			eat[plates[(i+k-1)%n]]++; // 해당 값도 올려주기 
//			System.out.println(Arrays.toString(eat));
		}
		
		System.out.println(max);
		br.close();
	}
}
