import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {

        // boolean answer = true;

        // Arrays.sort(phone_book); 불필요!!
        // System.out.println(Arrays.toString(phone_book));
        Map<String, String> map = new HashMap<String, String>();

        for(String tmp:phone_book) {
        	map.put(tmp, tmp); // key = vaule
        }

        for(String str:phone_book) {
        	for(int i=0; i<str.length(); i++) {
        		String tmp = str.substring(0, i);
                System.out.println(tmp);
        		if(map.containsKey(tmp)) return false;
        	}
        }
        return true;

     // 시간초과....
        // for(int i=0; i<phone_book.length; i++) {
        //     for (int j=i+1; j<phone_book.length; j++){
        //         if(phone_book[i].startsWith(phone_book[j]))
        //             return false;
        //         if(phone_book[j].startsWith(phone_book[i]))
        //             return false;
        //     }
        // }
        // return true;


        // 정답
        // Arrays.sort(phone_book);
        // boolean result = true;
        // for (int i=0; i<phone_book.length-1; i++) {
        //     if (phone_book[i+1].startsWith(phone_book[i])) {
        //         result = false;
        //         break;
        //     }
        // }
        // return result;
    }
}
