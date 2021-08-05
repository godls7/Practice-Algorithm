package s0805;

import java.io.*;
import java.util.*;

public class d4_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int c=0; c<10; c++) {
			// 입력받기
			int length = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			// 스택에 push
			for(int i=0; i<length; i++){
				char now = input.charAt(i); // 하나씩 보면서
				// 닫힌 괄호 종류에 맞는 쌍 유효성 여부를 확인하여 제거
                // stack이 비어있지 않은 상태에서 pop() 가능
				if(now == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop(); 
				else if(now == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop(); 
				else if(now == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop(); 
				else if(now == '>' && !stack.isEmpty() && stack.peek() == '<') stack.pop(); 
				else stack.push(now);
			}
			int result = stack.isEmpty()? 1:0;
			sb.append("#").append(c+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
