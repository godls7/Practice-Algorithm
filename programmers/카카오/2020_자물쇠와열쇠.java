import java.util.*;
import java.io.*;

public class 자물쇠와열쇠 {

	public static void main(String[] args) throws Exception{
		
		boolean result = solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},new int[][] {{1,1,1}, {1, 1,0}, {1,0,1}});
		System.out.println(result);
	}

	public static boolean solution(int[][] key, int[][] lock) {
		int start = key.length-1; // 열쇠와 자물쇠 처음겹치는 위치 
		for(int x=0; x<start+lock.length; x++) { // 이동거리 
			for(int y=0; y<start+lock.length;y++) { // 이동거리 
				for(int r=0; r<4; r++) { // 네번회전 
					int[][] new_lock = new int[lock.length+key.length*2][lock.length+key.length*2];
					//확장한 새로운 lock초기화
					for(int i=0; i<lock.length;i++) {
						for (int j=0; j<lock.length;j++) {
							new_lock[i+start][j+start]=lock[i][j];
						}
					}
					match(new_lock,key,r,x,y);
					if(check(new_lock,start,lock.length)) return true;
				}
			}
		}
		return false;
    }
	
	// new_lock에 key 더해줌 (회전시켜서)
	public static void match(int[][] new_lock, int[][] key, int r, int x, int y) {
		int len = key.length;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(r==0) { // 그대로 
					new_lock[x+i][y+j] += key[i][j];
				} else if(r==1) { // 90도 회전 
					new_lock[x+i][y+j] += key[j][len-i-1];
				} else if(r==2) { // 180도 회전 
					new_lock[x+i][y+j] += key[len-i-1][len-j-1];
				} else { // 270도 회전 
					new_lock[x+i][y+j] += key[len-j-1][i];
				}
			}
		}
	}
	
	public static boolean check(int[][] new_lock,int point,int len) {
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(new_lock[point+i][point+j]!=1) return false;
			}
		}
		return true;
	}
}
