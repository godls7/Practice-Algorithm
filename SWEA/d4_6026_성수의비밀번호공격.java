package s0928;

import java.io.*;
import java.util.*;

public class d4_6026_성수의비밀번호공격 {
	
	static int M,N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 모듈러가 음수이면 P를 한번더 더해주자 

		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N =Integer.parseInt(st.nextToken());
			int P = 1_000_000_007;
			
			long result = surjection(M, N, P);
			result = result>=0? result:(result+P);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	
	// 전사함수 : sigma((-1)^i*nCi*(n-i)^m) = nCn.nFm - nCn-1.n -1Fm +nCn-2.n -2Fm ...
	static long surjection(int m, int n, int p) {
		long tot=0L;
		for(int i=0; i<m; i++) {
			long t1=(i%2==0)? 1:-1;
			long t2=nCr(m,i,p)%p;
			long t3=power(m-i, n, p)%p;
			tot=(tot+(t1*t2*t3)%p)%p;
		}
		return tot%p;
	}

	static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0]=1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1]*i%p;
		}
		
		return (fac[n]*power(fac[r], p-2, p) %p * power(fac[n-r], p-2, p)%p)%p;
	}

	static long power(long x, long y, long p) {
		long res = 1L;
		x = x%p;
		
		while(y>0) {
			if(y%2==1) // 홀수면 
				res = (res*x)%p; // 결과에 먼저한번 곱해주고 p로 나눈 나머지 
			y = y >> 1; // 짝수면 나누기 2
			x = (x*x)%p; // 제곱해주고 p로 나눈 나머지 
		}
		return res;
	}
}
