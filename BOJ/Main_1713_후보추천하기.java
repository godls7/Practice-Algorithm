import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
    int num; // 번호
    int total; // 총 추천횟수
    int time;

    public Student(int num, int total, int time){
        this.num = num;
        this.total = total;
        this.time = time;
    }

    @Override
    public int compareTo(Student o){
        if(this.total == o.total) // 추천수가 같다면
            return this.time-o.time; // 시간순 정렬
        else if(this.total < o.total)  
            return -1; // 내림차순
        else 
            return 1; // 오름차순
    }
}

public class Main_1713_후보추천하기 {

    static int N,M;
    static int[] students;
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        students = new int[101]; // 학생 100번까지
        ArrayList<Student> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            int number = sc.nextInt(); // 추천학생번호
            if(students[number]>0){ // 이미 있다면
                students[number] += 1; // 추천수 증가
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).num == number){ // 리스트에서도 확인
                        list.get(j).total +=1; // 리스트에서 해당학생 추천수 증가
                        break;
                    }
                }
            } else{ // 없어서 새로추가
                if(list.size()>=N){ // 틀 찼으면
                    Collections.sort(list); // 추천횟수 적은수,시간순으로 정렬
                    int number2 = list.get(0).num; // 현재 학생번호
                    list.remove(0); // 첫번째학생삭제
                    students[number2] = 0; // 추천받은수 0으로 변경
                }
                list.add(new Student(number, 1, i)); // 새로운 학생추가
                students[number]=1;
            }
        }

        for (int i = 0; i < 101; i++) {
            if(students[i]!=0){
                System.out.print(i+" ");
            }
        }
    }
    
}
