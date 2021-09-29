package h0929;

import java.io.*;
import java.util.*;

class Point{
	int r,c,cost;

	public Point(int r, int c, int cost) {
		super();
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
}

public class Main_bj_4485_녹색옷입은애가젤다지 {

	static final int INF =987654321;
	static int N, answer;
	static int map[][], distance[][];
	static boolean visited[][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; ;t++) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			answer=0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = INF;
				}
			}
			int result=bfs();
			sb.append("Problem ").append(t).append(": ").append(result).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}

	static int bfs() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0,0,map[0][0]));
		
		
		
		return 0;
	}

	
	
}
