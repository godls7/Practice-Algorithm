package s0812;

import java.io.*;
import java.util.*;

public class d3_6808_규영이와인영이의카드게임 {
	
	static int[] gyu;
	static int[] in;
	static int SIZE=9, win, lose;
	static int[] in_numbers;
	static boolean[] isSelect,card;
			
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int number = Integer.parseInt(br.readLine());
		
		for(int n=0;n<number; n++) {
			gyu = new int[SIZE]; // 규영의 카드
			in = new int[SIZE]; // 인영의 카드 
			in_numbers = new int[SIZE]; // in이 각 경우마다 나열된 순열
			card = new boolean[2*SIZE+1];
			isSelect = new boolean[2*SIZE+1];
			win = 0;
			lose= 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 규영이 내는 카드 입력받기
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
				
			}
			
			// 인영이 카드 입력받기
			int cnt = 0;
			for(int i=1; i<=SIZE*2; i++) {
				if(!card[i]) {
					in[cnt] = i;
					cnt++;
				}
			}
//			System.out.println(Arrays.toString(gyu)+"/"+Arrays.toString(in));
			
			permutation(0); // 인영이 카드순서 위해 순열
			sb.append("#").append(n+1).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	
	static void permutation(int cnt) {
		
		if(cnt==9) {
			int gyu_s=0, in_s=0;
			
			for(int i=0; i<SIZE; i++) {
				if(gyu[i] > in_numbers[i]) {
					gyu_s += gyu[i] + in_numbers[i];
				} else
					in_s += gyu[i] + in_numbers[i];
			}
			
			if(gyu_s>in_s) win++;
			else if(gyu_s<in_s) lose++;
		}
		
		for(int i=0; i<SIZE; i++) {
			if(isSelect[i]) continue;
			in_numbers[cnt] = in[i];
			isSelect[i] = true;
			permutation(cnt+1);
			isSelect[i] = false;
		}
	}
}