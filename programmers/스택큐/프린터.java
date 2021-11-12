import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) throws Exception{
        int answer = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 위치와 우선순위 큐에 넣어주기
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i,priorities[i]});
        }

        int cnt=0; // 출력횟수

        while(!queue.isEmpty()){
            boolean flag = false;
            int[] now = queue.poll();

            // 나머지 중 현재보다 큰게 있다면 true
            for(int[] q:queue){
                if(now[1]<q[1]) {
                    flag = true;
                }
            }

            if(flag){
                // true면 현재꺼 큐에 넣기
                queue.offer(now);
            } else {
                // 아니면 출력카운트 올려주고 원하면 위치면 리턴
                cnt++;
                if(now[0]==location) return cnt;
            }
        }

        return answer;
    }
}
