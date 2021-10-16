import java.util.*;
import java.io.*;

class Solution {

    static int[][] wires_info;
    static boolean[] visited;
    static int cnt;

    public int solution(int n, int[][] wires) {
        int answer = 101;
        wires_info = new int[n+1][n+1];

        // 전선 연결 정보 입력
        for(int i=0; i<wires.length; i++){
            wires_info[wires[i][0]][wires[i][1]]=1;
            wires_info[wires[i][1]][wires[i][0]]=1;
        }

        // 전력망 차례대로 분할해보기
        for(int i=0; i<wires.length; i++){
            cnt =0;
            visited = new boolean[n+1];

            // 끊을자리 표시
            wires_info[wires[i][0]][wires[i][1]]=0;
            wires_info[wires[i][1]][wires[i][0]]=0;

            bfs(n);

            // 다시 되돌리기
            wires_info[wires[i][0]][wires[i][1]]=1;
            wires_info[wires[i][1]][wires[i][0]]=1;

            int min = Math.abs(n-cnt*2); // (n-cnt)-cnt
            if(answer>min) answer=min;
        }
        return answer;
    }

    public void bfs(int n){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[1]=true;
        queue.offer(1);

        while(!queue.isEmpty()){
            int now = queue.poll();
            cnt++;

            for(int j=1; j<=n; j++){
                if(wires_info[now][j]==1 && !visited[j]){
                    queue.offer(j);
                    visited[j]=true;
                }
            }
        }
    }
}
