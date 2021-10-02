package study.algorithm;

import java.io.*;
import java.util.*;

public class pro_Hindex {

	public static void main(String[] args) {

		int[] input = {3, 0, 6, 1, 5};
		System.out.println(solution(input));
	}

	private static int solution(int[] citations) {
		// integer로 변경 
		Integer arr[] = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		
		// 내림차순정렬 
		Arrays.sort(arr, Collections.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<=i)
				return i;
		}
		
        return arr.length;
		
	}
}
