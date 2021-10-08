import java.io.*;
import java.util.*;

class Solution{
  public String solution(String[] table, String[] languages, int[] preference) {
		String answer ="";
		int max=0;
		// language, preference
		Map<String, Integer> hm = new HashMap<String, Integer>();

		for(int i=0; i<languages.length; i++) {
			hm.put(languages[i], preference[i]);
		}

		for(int i=0; i<5; i++) {
			// 5,4,3,2,1 점수순
			String[] str=table[i].split(" ");
			int score=0;
			for(int j=1; j<6; j++) {
				if(hm.containsKey(str[j])) {
					// language에 있으면 점수 추가
					score += (6-j)*hm.get(str[j]);
				}
			}

			if(max<score) {
				max=score;
				answer=str[0]; // 직업군
			} else if(max==score){
				if(answer.compareTo(str[0])>0) {
					answer=str[0];
				}
			}
		}
		return answer;
	}

}
