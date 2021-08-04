package s0803;

import java.io.*;
import java.util.*;

// 입력
//2    
//3   
//4             

// 출력
//#1
//1 2 3
//8 9 4
//7 6 5
//#2
//1 2 3 4
//12 13 14 5
//11 16 15 6
//10 9 8 7

public class d2_1954_달팽이숫자 {
	
	static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0}, dd= {0,1,2,3};// 우 하 좌 상

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_1954.txt"));
		Scanner sc = new Scanner(System.in);
		int case_c = sc.nextInt();
		
		for(int i=0; i<case_c; i++) {
			int size = sc.nextInt(); // 사이즈
			int[][] map = new int[size][size]; // 달팽이맵
			int x=0;
			int y=0;
			int dir = 0;
			int num = 1; // 숫자
			
			for(int m=0; m<size*size; m++) {
				// 다음 위치 지정
				int nx = x + dx[dd[dir]];
				int ny = y + dy[dd[dir]];
				
				// 해당 위치 검사
				if(nx<0 || nx>=size || ny<0 || ny>=size || map[nx][ny] !=0) {// 범위를 벗어나거나 이미 값이 있는 경우를 만나면
					dir = (dir+1)%4; // 다음 순서로 방향 바꿈
					nx = x + dx[dd[dir]]; // 그리고 다시 위치 설정
					ny = y + dy[dd[dir]];
				}
				map[x][y] = num++; // 현재 자리 값 넣기
				x = nx; y = ny; // 다음 위치 넘김
			}
			System.out.println("#"+(i+1));
			for(int[] line:map) {
				for(int m:line) {
					System.out.print(m+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
