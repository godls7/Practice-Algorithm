import java.io.*;
import java.util.*;

class Solution {
    // 최소신장트리
    // 크루스칼 알고리즘
    static int[] parent;

    public int solution(int n, int[][] costs) {

        // 우선 가중치 기준으로 오름차순 정렬
        Arrays.sort(costs, (o1,o2) ->
            Integer.compare(o1[2],o2[2])
        );

        System.out.println(Arrays.deepToString(costs));

        parent = new int[n];

        // 부모노드 자기자신으로 초기화
        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        int answer = 0;
        for(int[] edge:costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            // 부모노드가 같다면(같은 그래프라면) 넘기기
            if(fromParent==toParent) continue;

            answer += cost;
            parent[toParent] = fromParent; // 두 노드를 연결해 같은 그래프로 만들어줌

        }
        return answer;
    }

    // 부모노드가 자기자신과 같은 노드를 찾을때 까지 재귀
    static int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node] = findParent(parent[node]);
    }
}
