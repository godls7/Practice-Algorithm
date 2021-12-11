import java.util.*;

class Solution {

    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        // 모든 경우 수 => 완탐
        dfs(numbers, target, 0,0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int cnt, int sum){
        if(cnt==numbers.length){
            if(sum==target) answer++;
            return;
        }

        // 처음엔 더해서 넘기기
        sum += numbers[cnt];
        dfs(numbers, target, cnt+1, sum);
        sum -= numbers[cnt];
        // 빼서 넘기기
        sum += (-1)*numbers[cnt];
        dfs(numbers, target, cnt+1, sum);
    }
}
