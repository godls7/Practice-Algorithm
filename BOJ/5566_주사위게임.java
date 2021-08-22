package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_5566_주사위게임 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] map = new int[N+1];
		int[] dice = new int[M+1];
		
		for(int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=M; i++) {
			dice[i] = Integer.parseInt(br.readLine());
		}
//		
//		System.out.println(Arrays.toString(map));
//		System.out.println(Arrays.toString(dice));
		
		int cnt = 0;
		int now_idx = 1; // 현재위치
		int now = map[now_idx]; // 현재위치에서 이동값
		
		// 주사위 하나씩 돌면서
		for(int d=1; d<=M; d++) {
			cnt++;
			int now_dice = dice[d];

			now_idx += now_dice;
			if(now_idx>=N) break;
			
			now = map[now_idx];
			
			now_idx += now; // 현재 이동값 + 주사위값
			if(now_idx>=N) break;
			now = map[now_idx];

		}
		System.out.println(cnt);
		br.close();
	}
}
