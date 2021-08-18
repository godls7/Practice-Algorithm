package s0818;

import java.io.*;
import java.util.*;

public class sw_4012_요리사 {
	
	static int N, R, result;
	static int[][] foods;
	static boolean[] isSelect;
	static List<Integer> a;
	static List<Integer> b;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			foods = new int[N][N];
			isSelect = new boolean[N];
			result = Integer.MAX_VALUE;
			
			// 케이스 별로 식재료 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0, 0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	// 식재료 조합을 만들기 위한 조합 함수
	static void combi(int cnt, int start) {
		if(cnt==R) {
			a = new ArrayList<>();
			b = new ArrayList<>();
			for(int i=0; i<N; i++) { // 식재료를 다 돌면서
				if(isSelect[i]) a.add(i); // 선택 됐다면 A음식 List에 저장
				else b.add(i); // 선택 안됐다면 B음식 List에 저장
			}
			result = Math.min(result, Math.abs(cal(a)-cal(b))); // 최소 A,B음식의 차이를 비교해서 저장
			return;
		}
		
		for(int i=start; i<N; i++) {
			isSelect[i] = true;
			combi(cnt+1, i+1);
			isSelect[i] = false;
		}
	}
	// 식재료의 여러 조합을 시너지를 더해 해당음식의 맛을 계산할 함수
	static int cal(List<Integer> food) {
		int sum=0;
		
		// ABC -> AB AC BA BC CA CB 다 구해야함...!
		// size : 4일때
		for(int i=0; i<food.size()-1; i++) {  // 012
			for(int j=i+1; j<food.size(); j++) { // 123
				sum += foods[food.get(i)][food.get(j)];
				sum += foods[food.get(j)][food.get(i)];
			}
		}
		return sum;
	}
}