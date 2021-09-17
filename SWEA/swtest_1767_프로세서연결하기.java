package s0917;

import java.io.*;
import java.util.*;

public class swtest_1767_프로세서연결하기 {
		
	static int N, answer, core_max, length;
	static int map[][],temp_map[][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static List<int[]> cores;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core_max=0; answer=0; length=0;
			cores = new ArrayList<int[]>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && i!=0 && i!=N-1 && j!=0 && j!=N-1) 
						cores.add(new int[] {i,j});// 벽에 붙어있지 않은 코어만 저장 
				}
			}
			calLenth(0,0,0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	// 조합으로 전원연결 가능한 전선 선택 후, dfs로 전선만들기 
	static void calLenth(int idx, int coreCount, int line) {
		// 기저조건 
		if(idx==cores.size()) {
//			// core값이 최대가 여러개인 경우 
//			if(core_max==coreCount) {
//				// 전선합이 최소인것을 출력 
//				answer = Math.min(answer, line);
//				return;
//			}
//			// 아니라면, 둘중 최대를 core_max에 저장해주고 
//			core_max=Math.max(coreCount, core_max);
//			answer = line; // 현재 line 길이 저장 
//			return;
			if(core_max<coreCount) {
				core_max=coreCount;
				answer=line;
			} else if(core_max==coreCount) {
				answer=Math.min(answer, line);
			}
			return;
		}
		
		// 상우하좌를 돌면서 
		for(int d=0; d<4; d++) {
			// 먼저 전원에 연결가능한 경우인지 체크 
			if(isConnect(cores.get(idx),d)){
				// 가능하다면 전선 만들기 
				dfs_makelength(cores.get(idx), d, 2);
				// 그리고 다음 core로 이동 
				calLenth(idx+1, coreCount+1, line+length);
				// 끝나고 돌아왔으면 만들었던 전선 다시 초기화 
				dfs_makelength(cores.get(idx), d, 0);
			}
		}
	}
	
	// 현재 core에서 해당 d 방향으로 전원을 연결 할수 있는지 체크 
	private static boolean isConnect(int[] now, int d) {
		int nx = now[0]+dx[d]; // 설정한 방향의 x
		int ny = now[1]+dy[d]; // 설정한 방향의 y
		
		// 범위에 있는 동안 전원만날때 까지확인 
		while(nx>=0 && nx<N && ny>=0 && ny<N) {
			if(map[nx][ny]!=0) return false; // 0이 아닌게 하나라도 있으면 false
			nx += dx[d]; // 해당 방향으로 끝까지 직진 
			ny += dy[d];
		}
		return true;
	}

	// 전선을 채워 전원에 연결하기 
	static void dfs_makelength(int[] now, int d,int value) {
		// 새로운 전선이므로 length 초기화
		length=0;
		// 현재 전선 채울 방향 위치 
		int nx = now[0]+dx[d]; 
		int ny = now[1]+dy[d];
		// 범위에 있는 동안 전원만날때 까지 채우기 
		while(nx>=0 && nx<N && ny>=0 && ny<N) {
			map[nx][ny]=value; // 해당 가치로 채워주고 
			length++; // 현재 전선 길이 증가 
			nx+=dx[d]; // 해당 방향으로 끝까지 직
			ny+=dy[d];
		}
	}
}
