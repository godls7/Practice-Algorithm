class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        int n = scores.length;
        for(int i=0; i<n; i++){ // 열
            int sum = 0;
            int number=n;
            int self=0;
            int min=100; int max=0; int mincnt=0; int maxcnt=0;
            for(int j=0; j<n; j++){ // 행
                // System.out.print(scores[j][i]);
                sum += scores[j][i]; // 일단 총합구하기
                if(i==j) self = scores[j][i]; // 자기 점수 담기
                if(min>scores[j][i]) min = scores[j][i]; // 최솟값 구하기
                if(max<scores[j][i]) max = scores[j][i]; // 최댓값 구하기
            }
            for(int j=0; j<n; j++){
                if(max==scores[j][i]) maxcnt++;
                if(min==scores[j][i]) mincnt++;
            }

            // System.out.printf("sum:%d / self:%d / min:%d/ max:%d\n",sum,self,min,max);
            if(self==min && mincnt==1){
                sum -= min;
                number = n-1;

            } else if(self==max && maxcnt==1){
                sum -= max;
                number = n-1;
            }
            answer += grade(sum,number);
        }
        return answer;
    }

    public String grade(int sum, int n){
        int avg = sum/n;
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 50) return "D";
        else return "F";
    }
}
