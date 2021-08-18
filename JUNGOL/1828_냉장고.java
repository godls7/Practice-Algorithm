package h0817;

import java.io.*;
import java.util.*;

// 그리디
public class Main_jo_1828 {
	// 화학성분 클래스
	// 굳이 클래스 배열 안만들고, int[]로 하는게 더 낫다! 성능 젤 조아
	static class Element implements Comparable<Element>{ 
		int row, high;

		public Element(int row, int high) {
			super();
			this.row = row;
			this.high = high;
		}

		@Override
		public String toString() {
			return "Element [row=" + row + ", high=" + high + "]";
		}

		@Override
		public int compareTo(Element o) {
			return Integer.compare(this.high, o.high);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Element[] elements = new Element[N];
		
		// Element 클래스에 화학성분 하나씩 저장
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			elements[i] = new Element(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(elements); // 최고온도기준으로 오름차순 정렬
//		Arrays.sort(elements, (o1,o2)->Integer.compare(o1.high, o2.high));
		int count = 1; // 냉장고 순
		int max = elements[0].high; // 처음 화학성분의 최고온도 저장
		
		for(int i=1; i<N; i++) {
			if(max<elements[i].row) { // 바로 전 화학성분의 최고온도보다 높은 최저온도를 가지게 되면
				max = elements[i].high;
				count++;
			}
		}
		System.out.println(count);
	}

}
