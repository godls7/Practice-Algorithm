package s0812;

import java.io.*;
import java.util.*;

public class d3_6808_규영이와인영이의카드게임 {
	
	// List 보다 배열이 빠르다...ㅎㅎ
	static List<Integer> gyu;
	static List<Integer> in;
	static int SIZE=9, win, lose;
	static int[] in_numbers;
	static boolean[] isSelect,card;
			
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int number = Integer.parseInt(br.readLine());
		
		for(int n=0;n<number; n++) {
			gyu = new ArrayList<>();
			in = new ArrayList<>();
			in_numbers = new int[SIZE]; // in이 각 경우마다 나열된 순열
			card = new boolean[2*SIZE+1];
			isSelect = new boolean[2*SIZE+1];
			win = 0;
			lose= 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 규영이 내는 카드 입력받기
			for(int i=0; i<9; i++) {
				gyu.add(Integer.parseInt(st.nextToken()));
				
			}
			
			// 인영이 카드 입력받기
			int cnt = 0;
			for(int i=1; i<=SIZE*2; i++) {
				if(!gyu.contains(i)) in.add(i);
			}
			
			permutation(0); // 인영이 카드순서 위해 순열
			sb.append("#").append(n+1).append(" ").append(win).append(" ").append(362880-win).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	
	static void permutation(int cnt) {
		// 기저조건
		// cnt가 카드9개가 나오면
		if(cnt==9) {
			int gyu_s=0, in_s=0; // 규영, 인영 각각 스코어 변수
			
			for(int i=0; i<SIZE; i++) {
				if(gyu.get(i) > in_numbers[i]) { // 같은자리 숫자 비교하면서
					gyu_s += gyu.get(i) + in_numbers[i]; // 규영이크면 규영한테 점수줌
				} else
					in_s += gyu.get(i) + in_numbers[i]; // 규영이크면 규영한테 점수줌
			}
			
			if(gyu_s>in_s) win++;
		}
		
		// 기본 순열 코드
		// isSelect를기준으로 in이가진 카드 중 in_numbers(카드순열) 배열로 옮겨줌
		for(int i=0; i<SIZE; i++) {
			if(isSelect[i]) continue;
			in_numbers[cnt] = in.get(i);
			isSelect[i] = true;
			permutation(cnt+1);
			isSelect[i] = false;
			// 규영과 인영이 각각 이겼을경우 바로 파라미터로 넘겨버리기
//			if(gyu.get(i)>in.get(i))
//				permutation(cnt+1, gyu_s+gyu.get(cnt)+in.get(i), in_s);
//			if(gyu.get(i)<in.get(i))
//				permutation(cnt+1, gyu_s, in_s+gyu.get(cnt)+in.get(i));
		}
	}
}