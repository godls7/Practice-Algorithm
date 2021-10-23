import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] c:clothes){
            if(map.containsKey(c[1])){
                int value = map.get(c[1]);
                map.put(c[1],value+1);
            } else{
                map.put(c[1],1);
            }
        }
        // System.out.println(map);

        for(String key:map.keySet()){
            answer*=map.get(key)+1;
        }

        return answer-1;
    }
}
