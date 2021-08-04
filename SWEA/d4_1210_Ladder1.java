package s0803;

import java.io.*;
import java.util.*;

public class d4_1210_Ladder1 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10; i++) {
			int number = Integer.parseInt(br.readLine());
			int[][] ladder = new int[100][100]; // 사다리
			int dest = 0; // 도착지점 열
			
			// 사다리 입력받기
			for(int r=0; r<100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int c=0; c<100; c++) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 도착지점 찾기
			for(int c=0; c<100; c++) {
				if(ladder[99][c] == 2) {
					dest = c;
					break;
				}
			}
			// 아래서 위로 올라가면서
			for(int r=99; r>=0; r--) {
				if(0<dest-1 && dest-1<=99 && ladder[r][dest-1] == 1) { // 범위 안에 있고 왼쪽에 길을 만나는 경우
					while(0<dest-1 && dest-1<=99 && ladder[r][dest-1] == 1) dest--;  // 조건에 맞을때까지 왼쪽으로가기
				}
				else { // 그렇지않으면
					while(0<dest+1 && dest+1<=99 && ladder[r][dest+1] == 1) dest++; // 조건에 맞을때까지 오른쪽으로가기
				}
			}
			sb.append("#").append(number).append(" ").append(dest).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
