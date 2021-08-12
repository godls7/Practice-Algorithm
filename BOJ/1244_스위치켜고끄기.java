package h0802;

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기 {

	// 스위치 바꾸는 함수
	static int change(int n) {
		if(n==0) return 1;
		else return 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switch_count = Integer.parseInt(br.readLine()); // 스위치 개수
		
		int[] switches = new int[switch_count+1]; // switch배열 (switch 번호 맞추기위해 하나크게 해줌)
		StringTokenizer st = new StringTokenizer(br.readLine()," "); // 스위치 입력받기
		int i=0;
		// 스위치를 스위치배열에 입력
		while(st.hasMoreTokens()) {
			int swi = Integer.parseInt(st.nextToken());
			switches[i+1] = swi;
			i++;
		}

		int student_count = Integer.parseInt(br.readLine()); //학생수
		// [[성별,번호],[성별,번호],[성별,번호],[성별,번호],[성별,번호],[성별,번호]] 입력
		int[][] students = new int[student_count][2]; 
		for(int s=0; s<student_count; s++) {
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				students[s][0] = Integer.parseInt(st.nextToken());
				students[s][1] = Integer.parseInt(st.nextToken());
			}
		}		
		// 학생들 한명씩 확인하면서 스위치변경
		for(int j=0; j<student_count; j++) {
			// 남학생인 경우
			if(students[j][0]==1) { 
				int target = students[j][1]; // 가진 번호
				int num = target;
				while(target<switches.length) { // target이 스위치번호 보다 작을동안
					switches[target] = change(switches[target]); // 0->1, 1->0 바꾸기
					target += num; // 다음 순서 target
				}
//				for(int t=target; t<switches.length; t+=target) {
//					switches[t] = change(switches[t]); // 0->1, 1->0 바꾸기
//				}
			}
			// 여학생인 경우
			else if(students[j][0]==2) { 
				int target = students[j][1]; // 가진 번호
				int target_l = target-1; // 가진번호 왼쪽
				int target_r = target+1; // 가진번호 오른쪽
				switches[target] = change(switches[target]); // 일단 가진 번호 스위치 변경
				while(true) {
					if(target_l <= 0 || target_r >= switches.length || switches[target_l] != switches[target_r]) break;
					switches[target_l] = change(switches[target_l]);
					switches[target_r] = change(switches[target_r]);
					target_l--;
					target_r++;
				}
//				while(0 < target_l && target_r < switches.length) {
//					if(switches[target_l] == switches[target_r]) {
//					switches[target_l] = change(switches[target_l]);
//					switches[target_r] = change(switches[target_r]);
//					target_l--;
//					target_r++;
//					}
//					else break;
//				}
			}
		}
				
		for(int s=1; s<switches.length; s++) {
			System.out.print(switches[s]+" ");
			if(s%20 == 0) System.out.println(); // 20개씩 개행
		}
		br.close();
	}
}