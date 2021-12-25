import java.util.*;
import java.io.*;

/**
 * 1966_프린터큐
 */
public class Main_1966_프린터큐 {
    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int number = 0;

            int[] star = new int[N];
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for(int i=0; i<N; i++){
                int n = sc.nextInt()
                queue.offer(n);
                star[i] = n;
            }
            
            number = star[M];
            System.out.println(queue);

            // queue 돌면서 출력
            int now = queue.poll();
            if(now>)

            

        }

    }
}