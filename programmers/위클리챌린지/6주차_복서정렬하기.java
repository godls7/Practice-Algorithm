import java.io.*;
import java.util.*;

class Boxer implements Comparable<Boxer>{
    int number;
    double win_count;
    int win_heavy;
    int weight;

    public Boxer(int number,double win_count, int win_heavy, int weight){
        this.number = number;
        this.win_count = win_count;
        this.win_heavy = win_heavy;
        this.weight = weight;
    }

    public int compareTo(Boxer b){
        // 승률 먼저 비교
        if(b.win_count-win_count>0) return 1;
        else if(b.win_count-win_count<0) return -1;
        else{
            if(b.win_heavy-win_heavy>0) return 1;
            else if(b.win_heavy-win_heavy<0) return -1;
            else {
                if(b.weight-weight>0) return 1;
                else if(b.weight-weight<0) return -1;
                else {
                    if(b.number-number<=0) return 1;
                    else return -1;
                }
            }
        }
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int n=weights.length;
        int[] answer = new int[n];
        char[][] result = new char[n][n];
        List<Boxer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            char[] now = head2head[i].toCharArray();
            // System.out.println(Arrays.toString(now));
            int win_count=0;
            int lose_count=0;
            int win_heavy=0;
            double win_per=0;
            for(int j=0; j<n; j++){
                if(now[j]=='W') {
                    win_count++;
                    if(weights[i]<weights[j]) win_heavy++;
                } else if(now[j]=='L'){
                    lose_count++;
                }
            }
            if(win_count==0 && lose_count==0) {
                win_per=0;
            } else
                win_per = (double) win_count/(win_count+lose_count)*100;

            list.add(new Boxer(i+1,win_per,win_heavy, weights[i]));
        }
        //  for(Boxer b:list){
        //     System.out.printf("num:%d / winper:%f / win_heavy:%d / weight:%d\n",b.number,b.win_count,b.win_heavy,b.weight);
        // }

        // 돌면서 확인
        Collections.sort(list);

        for(int i=0; i<n; i++){
            answer[i] = list.get(i).number;
        }
        return answer;
    }
}
