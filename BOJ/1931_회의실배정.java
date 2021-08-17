package h0817;

import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실배정 {
	
	static class Meeting implements Comparable<Meeting>{
		
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Meeting o) {
			int value = Integer.compare(this.end, o.end); // 끝나는 시간으로 오름차순정렬
			if(value !=0) return value;
			return Integer.compare(this.start, o.start); // 같다면 시작하는 시간으로 오름차순 정렬
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
//		for(Meeting m:meetings) System.out.println(m);
		
		Arrays.sort(meetings);
		int cnt = meetings.length;
		int result = 1;
		int end = meetings[0].end;
		for(int i=1; i<cnt; i++) {
			if(end <= meetings[i].start) {
				end = meetings[i].end;
				result++;
			}
		}
		System.out.println(result);
	}
}
