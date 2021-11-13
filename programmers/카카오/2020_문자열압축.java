import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 987654321;;

        // 문자열 길이가 1이면 리턴
        if(s.length() == 1) return 1;

        // 1~길이/2 : 압축길이
        for(int i=1; i<=s.length()/2; i++){
            String str = ""; // 압축 길이별 저장할 문자열
            String temp=""; // 자른 비교 문자열
            int cnt =1; // 자른문자열 같은 수

            for(int j=0; j<s.length()/i; j++){
                // 이전 비교문자열과 같다면
                if(temp.equals(s.substring(j*i,(j*i)+i))){
                    cnt++; // 증가
                    continue;
                }

                if(cnt>1){
                    // 같은게 있다면 숫자+문자열 붙이기
                    str += cnt + temp;
                    cnt =1;
                } else{
                    // 같은게 없다면 문자열만 붙이기
                    str += temp;
                }
                // 현재 다른걸로 비교 문자열 변경
                temp = s.substring(j*i,j*i+i);
            }

            // 마지막붙이지 못한 문자열 붙이기
            if(cnt>1){
                str += cnt+temp;
                cnt=1;
            } else{
                str += temp;
            }

            // s가 압축한 길이로 나누어 떨어지지 않는다면(남은게 있단소리), 나머지부터 마지막 붙이기
            if(s.length()%i != 0){
                str += s.substring(s.length()-s.length()%i,s.length());
            }
            // 가장 짤은 길이 찾기
            answer = answer > str.length() ? str.length() : answer;
        }

        return answer;
    }
}
