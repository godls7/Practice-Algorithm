package s0803;

import java.io.*;
import java.util.*;

// 높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업 : 평탄화
public class d3_1208_Flatten {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 10가지 테스트케이스 입력받기
		for(int i=0; i<10; i++) {
			int count = Integer.parseInt(br.readLine()); // 덤프 횟수
			int[] box_h = new int[100]; // 상자의 높이값 저장위한 배열 : 100개
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<100; j++) { // 각 케이스별 박스높이 입력
				box_h[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int d=0; d<count; d++) { // 덤프횟수만큼
				Arrays.sort(box_h); // box 배열 오름차순 정렬
				if(box_h[99]-box_h[0] == 0 || box_h[99]-box_h[0] == 1) break;
				box_h[99]--; // 높이 중 최댓값 - 1
				box_h[0]++; //  높이 중 최솟값 + 1
			}
			Arrays.sort(box_h); // 최종 오름차순 정렬
//			System.out.printf("#%d %d%n",i+1, box_h[99]-box_h[0]);
			sb.append("#").append(i+1).append(" ").append(box_h[99]-box_h[0]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}









//			List<Integer> box = new ArrayList<>(); // 상자의 높이값 저장위한 리스트
//			while(st.hasMoreTokens()) { // 각 케이스별 박스높이 입력
//				box.add(Integer.parseInt(st.nextToken()));
//			}
////			System.out.println(box);
//			
//			for(int d=0; d<count; d++) {
//				box.sort(Comparator.reverseOrder()); // box list 내림차순 정렬
//				int max = box.get(0); // 높이 중 최댓값
//				int min = box.get(99); // 높이 중 최솟값
//				box.set(0, max-1); 
//				box.set(99, min+1);
//			}
//			
//			// 최종 내림차순 정렬
//			box.sort(Comparator.reverseOrder());
//			System.out.printf("#%d %d\n",i+1, box.get(0) - box.get(99));
