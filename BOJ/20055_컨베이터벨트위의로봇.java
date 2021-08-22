package study.algorithm;

import java.io.*;
import java.util.*;

public class Main_bj_20055_컨베이터벨트위의로봇  {
	
	static int N,K, belt[];
	static boolean robot[], isCount[];
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N];
		robot = new boolean[N];
		isCount = new boolean[2*N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int level=1;
		
		while(true) {
			int cnt=0;
			// 1.벨트/로봇 한칸 이동
			turnBelt();
			turnRobot();
			
			// 2. 로봇 한칸 이동가능하면 이동 (불가하면 가만히 있기)
			// => 앞의 칸에 로봇없어야하고, 내구도 1이상이어야함
			for(int i=robot.length-1; i>0; i--) { // 뒤에부터 봐보자
				// 맨뒤 로봇부터 체크
				// 자리에 로봇이 있다면
				if(robot[i]) { 
					int next = i+1;
					 // 내리는위치 로봇이라면
					if(next==N) {
						robot[i] = false; // 내리는위치 로봇빼기
						continue;
					}
					// 현재가 내리는위치가 아니고, 다음칸에 로봇이없고, 내구도가 1이상이면
					if(next<N && !robot[next] && belt[next]>0) { 
						robot[next] = true; // 다음칸으로 로봇 옮기고
						robot[i] = false; // 현재는 로봇없애고
						belt[next]--; // 다음칸 내구도-1
					}
				}
			}
			
			// 3. 올리는위치에 로봇이 없으면 로봇 올리기
			if(!robot[0] && belt[0]>0) {
				robot[0]=true; // 해당위치에 로봇 true
				belt[0]--; // 내구도 -1
				
			}
			 
			// 내구도 0인거 세기!
			for(int i=0; i<2*N; i++) {
				if(belt[i]==0) cnt++;
			}
			
			// 4. 내구도 0이 K개 이상이면 종료
			if(cnt>=K) {
				sb.append(level);
				break;
			}
			
			// 단계 하나 증가
			level++;
		}
		System.out.println(sb);
		br.close();
	}
	
	// 벨트 한칸 이동
	static void turnBelt() {
		int last = belt[belt.length-1];
		for(int i=belt.length-1; i>0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] =last;
	}
	
	// 로봇 한칸 이동
	static void turnRobot() {
		for(int i=robot.length-1; i>0; i--) {
			robot[i] = robot[i-1];
		}
		robot[0]=false;
	}
}