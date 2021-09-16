package s0916;

import java.io.*;
import java.util.*;

public class d6_1263_사람네트워크2 {

	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N=Integer.parseInt(st.nextToken());
			int[][] D = new int[N][N];
			
			for(int i=0;i<N; i++) {
				for(int j=0; j<N;j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && D[i][j]==0) D[i][j]=INF;
				}
			}
			
//			for(int[] a:D) System.out.println(Arrays.toString(a));
			
			for(int k=0; k<N; k++){
				for(int i=0; i<N; i++){
					for(int j=0; j<N; j++){
						D[i][j]=Math.min(D[i][j],D[i][k]+D[k][j]);
					}
				}
			}
			
			// 가장 최솟값을 가진 CC 구하기 
			int min = INF;
			
			for(int i=0; i<N; i++) {
				int temp = 0;
				for(int j=0; j<N; j++) {
					temp += D[i][j];
				}
				if(min>temp) min=temp;
			}
			
			
//			for(int[] a:D) System.out.println(Arrays.toString(a));
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
