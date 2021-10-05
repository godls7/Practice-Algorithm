package s1001;

import java.io.*;
import java.util.*;

class RotaInfo {
	int number,dir;

	public RotaInfo(int number, int dir) {
		super();
		this.number = number;
		this.dir = dir;
	}
}

public class d4_4013_특이한자석 {
	
	static int K,answer;
	static int magnet[][], score[], dir_check[];
	static Queue<RotaInfo> queue = new ArrayDeque<RotaInfo>();

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("res/input_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			answer=0;
			magnet = new int[5][8];
			score = new int[5];
			score[1]=1;
			score[2]=2;
			score[3]=4;
			score[4]=8;
			
			for(int i=1; i<=4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					// N극:0  S극:1
					magnet[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k=0; k<K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 시계:1 반시계:-1
				int number = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				queue.offer(new RotaInfo(number, dir)); // 회전정보 넣기 
			}
			
			// queue에서 하나씩 뽑으면서 방향설정해주기 
			while(!queue.isEmpty()) {
				RotaInfo info = queue.poll();
				int number = info.number;
				int dir = info.dir;
				
				// 현재 위치에서 왼쪽 오른쪽 N,S극체크 
				dir_check = new int[5];
				dir_check[number]=dir;
				
				// 오른쪽 체크 
				for(int i=number+1; i<=4; i++) {
					// 지금 극과 오른쪽 톱니의 왼쪽극이 같다면 
					if(magnet[i-1][2]==magnet[i][6]) {
						dir_check[i]=0; // 안돈다 
						break;
					}
					else 
						// 지금이 시계이면 반시계로, 아니면 반대로 설정
						dir_check[i] = dir_check[i-1]==1? -1:1;
				}
				
				// 왼쪽 체크 
				for(int i=number-1; i>=1; i--) {
					// 지금 극과 왼쪽 톱니의 오른쪽극이 같다면 
					if(magnet[i+1][6]==magnet[i][2]) {
						dir_check[i]=0; // 안돈다 
						break;
					}
					else
						// 지금이 시계이면 반시계로, 아니면 반대로 설정
						dir_check[i] = dir_check[i+1]==1? -1:1;
				}
				
				// 이제 1~4순으로 돌리기 
				for(int i=1; i<=4; i++) {
					int temp;
					switch (dir_check[i]) {
					case 1: // 시계
						temp = magnet[i][7]; // 맨꼭대기 
						for(int j=7; j>0; j--) {
							magnet[i][j] = magnet[i][j-1];
						}
						magnet[i][0]=temp;
						break;
					case -1: // 반시계 
						temp = magnet[i][0];
						for(int j=0; j<7; j++) {
							magnet[i][j]=magnet[i][j+1];
						}
						magnet[i][7]=temp;
						break;
					case 0: // 안돌아감 
						break;
					}
				}
			}
			
			for(int i=1; i<=4; i++) {
				if(magnet[i][0]==1) answer+=score[i];
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
