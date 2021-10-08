import java.util.*;
import java.io.*;

class Solution {

    char[] aeiou={'A','E','I','O','U'};
    int answer=0;
    boolean flag = false; // 찾았을때 return 위한 flag

    public int solution(String word) {
        // 빈 문자부터 시작
        dfs(0,"",word);
        return answer;
    }

    public void dfs(int cnt, String now, String word){
        // 기저조건
        if(cnt==6) return;
        // 입력문자를 찾았다면 flag ture
        if(word.equals(now)) {
            flag=true;
            return;
        }

        for(int i=0; i<5; i++){
            if(flag) return; // 이미 문자 찾았으면 return

            if(cnt+1<6) answer++; // 생성된 문자열의 길이가 5이하인 경우
            dfs(cnt+1, now+aeiou[i],word); // AEIOU 순서대로 붙여주며 dfs
        }
    }
}
