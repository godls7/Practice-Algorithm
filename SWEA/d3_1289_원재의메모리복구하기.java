package s0802;
import java.io.*;
import java.util.*;


public class d3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/input_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			char[] input = sc.next().toCharArray(); // 입력값 char배열로
			int size = input.length;
			char[] tmp = new char[size]; // 초깃값 셋팅하기위한 배열
			int count =0; // 각 경우당 실행횟수 세기
			
			// 초깃값 0 셋팅
			Arrays.fill(tmp, '0');

			
			// 초기 배열과 비교하면서 count 해보기
			for(int j=0; j<size; j++) {
				if(input[j] != tmp[j]) {
					char target = input[j];
					for(int k=j; k<size; k++) tmp[k] = target;
					count ++;
				}
			}
			System.out.println("#"+(i+1)+" "+count);
		}
		sc.close();
	}
}
