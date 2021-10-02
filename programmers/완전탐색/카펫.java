package study.algorithm;

import java.util.Arrays;

public class pro_카펫 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(10,2)));
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width=0,height=0;
        int area = brown+yellow; // width*height
        int plus = brown/2+2;    // width+height
        
        for(int i=3; i<2500; i++) { // i는 width
        	if(area%i==0) { // 넓이에서 나누어떨어지면 사각형 충족한단 얘기 
        		height = area/i;
        		if(i+height==plus) { // 더하기값도 맞아
        			if(i>=height) {// 가로가 더 길어나 같음 
        				answer[0]=i;
                        answer[1]=height;
        			}
        			else {
        				answer[0]=height;
        				answer[1]=i;
        			}
        		}
        	}
        }
        return answer;
    }
}
