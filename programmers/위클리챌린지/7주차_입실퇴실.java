import java.io.*;
import java.util.*;

class Solution{
  public int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];
		List<Integer> list = new ArrayList<>();
		int idx=0;

		// 입실하면서 만난사람수 세기
		for(int i=0; i<answer.length; i++) {
			// 입실 사람 list에 넣기
			list.add(enter[i]);
			for(int j=0; j<list.size(); j++) {
				// 지금 들어온 사람의 경우는 현존하는 사람들만 만남 list.size-1
				if(enter[i]==list.get(j)) {
					answer[list.get(j)-1]=list.size()-1;
				} else { // 이미있던 사람들은 새로운 사람으로 인해 만난사람 +1
					answer[list.get(j)-1]++;
				}
			}
			// 퇴실처리
			// 퇴실사람 순서대로 list에 있는지 체크해서
			// list에 있다면 list에서 제거 없다면 인덱스에 머무르기
			while(idx<answer.length && list.contains(leave[idx])) {
				list.remove(Integer.valueOf(leave[idx++])); // list에 있다면 해당 사람 지우기
			}
		}
		return answer;
	}
}
