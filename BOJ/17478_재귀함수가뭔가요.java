package h0802;

import java.io.*;
import java.util.*;

public class Main_bj_17478_재귀함수가뭔가요 {
	
//	static String line ="";
	static void answer(int n, String underbar) {
		
//		String dash = line;
		
		if(n==0) {
			System.out.println(underbar+"\"재귀함수가 뭔가요?\"");
			System.out.println(underbar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(underbar+"라고 답변하였지.");
			return;
		} 
		// 반복
		System.out.println(underbar+"\"재귀함수가 뭔가요?\"");
		System.out.println(underbar+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(underbar+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지");
		System.out.println(underbar+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
//		line += "____";
		answer(n-1, underbar+"____");
		
		System.out.println(underbar+"라고 답변하였지.");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		answer(input, "");
	}
}


/* 강사님 코드
 * import java.util.Scanner;

public class Main_bj_17478_재귀함수가뭔가요 {
   static String [] sa= {
       "\"재귀함수가 뭔가요?\"",
      "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",      
      "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지. ",
      "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
       "\"재귀함수는 자기 자신을 호출하는 함수라네.\"",
       "라고 답변하였지."
   };
   
    static void recur(int N, String underbar) {
      
      //재귀함수의 종료, 기본부분
      if(N==0) { //끝내주는 상황
         System.out.println(underbar+sa[0]);
         System.out.println(underbar+sa[4]);
         System.out.println(underbar+sa[5]);
         return;
      } else {
         //유도파트 //동일한 내용의 출력문
         for (int i = 0; i < 4; i++) {
              System.out.println(underbar+sa[i]);
         }
         //underbar = ; //처음 underbar "". 두번째일 때 underbar 4개   
         recur(N-1, underbar+ "____"); //2를 받으면 1을 부르고 1을 받으면 0을 부르고
   
         System.out.println(underbar+sa[5]);
      }
   }
   
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      //재귀횟수
      int N=sc.nextInt();
      System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
      //재귀횟수에 따른 챗봇 응답 출력
      recur(N, ""); //N만큼 출력 
      
      
        sc.close();
   }

}
*/