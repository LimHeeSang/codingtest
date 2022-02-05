package programmers.bruteforce;
import java.util.*;

//bruteforce1 소수 찾기
class BruteForce1 {

    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        int count = 0;
        visited = new boolean[numbers.length()];

        for(int i=1; i<=numbers.length(); i++){
            perm(numbers, "", i);
        }

        System.out.println(list);
        for(int l : list){
            if(checkSosu(l)) count++;
        }

        return count;
    }

    public static void perm(String str, String temp, int r){    //조합 구현
        if(r == 0){
            int num = Integer.parseInt(temp);
            if(!list.contains(num)) list.add(num);

            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!visited[i]){
                temp += str.charAt(i);
                visited[i] = true;
                perm(str, temp, r-1);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }

    public static boolean checkSosu(int n){    //n이 소수인지 판별해주는 함수
        if(n == 0 || n == 1) return false;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
