package s0714;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d1_2072_홀수만더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int tc=0; tc<10; tc++) {
			int sum=0;
			for(int i=0; i<10; i++) {
				int n =Integer.parseInt(st.nextToken());
				if(n%2==1) sum+=n;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
		sb.setLength(0); // BufferedReader 가 비워짐
		br.close();
		
	}
}
