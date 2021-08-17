import java.io.*;
import java.util.*;

// 하...이것도 말아먹다니...ㅠㅠ

public class Main_bj_2954_창영이의일기장 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		for(int i=0; i<input.length(); i++) {
			
			boolean flag = false; // 서브문자열 판단위한 flag
			if(input.charAt(i)=='a' || input.charAt(i)=='e' || input.charAt(i)=='i' 
					|| input.charAt(i)=='o' || input.charAt(i)=='u') {
				flag = true; // 모음이있다면, true;
			}
			if(flag) {
				// 해당 모음앞까지 + 해당 모음 뒤 p,모음 제거 후 그뒤부터
				input = input.substring(0,i) + input.substring(i+2); 
			}
		}
		System.out.println(input);
		br.close();	
	}
}