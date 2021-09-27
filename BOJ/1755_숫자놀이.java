import java.io.*;
import java.util.*;

public class Main_bj_1755_숫자놀이 {
	
	static String[] number_en = {"zero","one","two","three","four","five","six","seven","eight","nine"};

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt(); 
		int N = sc.nextInt();
		
		char[] temp = new char[2]; // 숫자를받아 각각을 char로 넣기 
		String strtemp ="";
		String[] result = new String[N-M+1]; // 모든 숫자가 닮길 배열 
		
		Map<String, Integer> number_str = new HashMap<String, Integer>(); // 숫자와 바뀔 영어
		
		for(int i=M; i<=N; i++) {
			temp = String.valueOf(i).toCharArray(); // char로 바꿔야 각 자리 숫자를 분리 할수있음 
			strtemp="";
			for(int j=0; j<temp.length; j++) {
				strtemp += number_en[temp[j]-'0']; // 문자를 숫자로 바꿔서 영어받아오기
				strtemp += " ";
			}
			number_str.put(strtemp, i); // hashmap 에 넣어주고
			result[i-M] = strtemp; // 알파벳으로 오름차순 정렬위해 영어로 변환 문자열 차례대로 넣기 
		}
		
		Arrays.sort(result); // 뒤에것 까지 정렬이 된다구..???
		int cnt =0;
		for(String str:result) {
			sb.append(number_str.get(str)+" ");
			cnt++;
			if(cnt==10) {
				sb.append("\n");
				cnt=0;
			}
		}
		
		System.out.println(sb);
		sc.close();
	}

}
