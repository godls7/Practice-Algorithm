import java.io.*;
import java.util.*;



public class 주식가격 {

	public static void main(String[] args) throws Exception{
		
		int[] prices = {1,2,3,2,3};
		
		solution(prices);
	}

	private static int[] solution(int[] prices) {
		int length = prices.length;
		int[] answer = new int[length];
		
		// 2
		for(int i=0; i<length; i++) {
			for(int j=i+1; j<length; j++) {
				answer[i]++;
				if(prices[i]>prices[j]) break;
			}
		}
		
		
		// 1
		ArrayDeque<int[]> stack = new ArrayDeque<int[]>();
		stack.push(new int[] {0,prices[0]}); // 맨처음꺼 먼저 넣기 
		
		for(int i=1; i<length; i++) {
			if(stack.peek()[1] > prices[i]) { // stack 맨위가 현재 값보다 크면 => 가격이 떨어졌다는 의미 
				int[] now = stack.pop();
				answer[now[0]] = i-now[1];
//				answer[stack.peek()[0]] = i-stack.peek()[0]; // 
			} 
			stack.push(new int[] {i,prices[i]});
//			System.out.println(stack);
		}
		
		while(!stack.isEmpty()) {
			int[] now = stack.pop();
			answer[now[0]] = (length-1)-now[0];
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
