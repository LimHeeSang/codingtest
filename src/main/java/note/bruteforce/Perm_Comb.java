package note.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Perm_Comb {

    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        //문자열 str 요소중 r개의 순열 or 중복순열 or 조합 or 중복조합 원소들을 모두 List에 담기
        String str = "12345";
        visited = new boolean[str.length()];

        dupComb(str, "",0,3);
        System.out.println(list);
        System.out.println("count : " + count);
    }

    //순열
    static void perm(String str, String temp, int r){
        if (r == 0) {
            int num = Integer.parseInt(temp);
            list.add(num);
            count++;
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(!visited[i]){
                temp += str.charAt(i);
                visited[i] = true;
                perm(str, temp, r - 1);
                visited[i] = false;
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    //중복순열
    static void dupPerm(String str, String temp, int r) {
        if (r == 0) {
            int num = Integer.parseInt(temp);
            list.add(num);
            count++;
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            dupPerm(str, temp, r - 1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    //조합
    static void comb(String str, String temp, int start, int r) {
        if (r == 0) {
            int num = Integer.parseInt(temp);
            list.add(num);
            count++;
            return;
        }

        for(int i=start; i<str.length(); i++){
            if(!visited[i]){
                temp += str.charAt(i);
                visited[i] = true;
                comb(str, temp, i + 1, r - 1);
                visited[i] = false;
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    //중복조합
    static void dupComb(String str, String temp, int start, int r) {
        if (r == 0) {
            int num = Integer.parseInt(temp);
            list.add(num);
            count++;
            return;
        }

        for(int i=start; i<str.length(); i++){
            temp += str.charAt(i);
            dupComb(str, temp, i, r - 1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
