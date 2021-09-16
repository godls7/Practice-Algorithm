package h0916;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기 {
	
	static class Point {
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static final int INF =100; //코드상, 최대값이 100이 넘을일이 없으므로 100으로 설정 

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine()); // 편의점 개수 
			int[][] D = new int[N+2][N+2]; // 이동가능한 거리 저장위한 2차원 배열 
			List<Point> points = new ArrayList<>(); // 방문장소 저장위한 리스트
			
			// 리스트에 출발~도착까지 좌표넣기 
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// 리스트에 저장된 모든좌표들 거리계산 뒤, D배열에 저장 
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==j) continue;// 자기자신으로 가는것이므로 넘기기 
					Point now = points.get(i), next=points.get(j);
					int now_distance = Math.abs(now.x-next.x)+Math.abs(now.y-next.y);
					
					if(now_distance <=1000) D[i][j]=1; // 거리가 1000이하라면 i->j로 가기가능 
					if(D[i][j]==0) D[i][j]=INF; // 자기자신으로 가지않는데 0이면 무한대로 설정 
				}
			}
//			for(int[] d:D)System.out.println(Arrays.toString(d));
			
			// 플로이드 코드 
			for(int k=0; k<N+2; k++) { // 경 
				for(int i=0; i<N+2; i++) { // 출 
					for(int j=0; j<N+2; j++) { // 도 
						D[i][j]=Math.min(D[i][j],D[i][k]+D[k][j]);
					}
				}
			}
			if(0<D[0][N+1] && D[0][N+1]<100) // 0(집)에서 N+1(페스티벌장소) 까지의 조건 0아니고 무한대가 아니여야함 
				System.out.println("happy");
			else 
				System.out.println("sad");
		}
		br.close();
	}

}
