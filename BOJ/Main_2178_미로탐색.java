import java.io.*;
import java.util.*;

/**
 * Main_2178_미로탐색
 */
public class Main_2178_미로탐색 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        // System.out.println(Arrays.deepToString(map));
        visited[0][0]=true;
        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int d=0; d<4; d++){
                int nx = nowx + dx[d];
                int ny = nowy + dy[d];

                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;

                queue.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                map[nx][ny] = map[nowx][nowy]+1;
            }
        }
        
    }
}