package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack1_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Deque<String> dq = new ArrayDeque<>();
        String[] splited = s.split("");

        boolean flag = false;
        f1 : for (int i = 0; i < splited.length; i++) {
            String temp = "";
            int result = 0;

            if (!validateString(splited[i])) {
                flag = true;
                break;
            }

            switch (splited[i]) {
                case "(":
                    dq.push("(");
                    break;

                case "[":
                    dq.push("[");
                    break;

                case ")":
                    while (true) {
                        if (dq.isEmpty()) {
                            flag = true;
                            break f1;
                        }

                        temp = dq.pop();
                        if (isNumber(temp)) {
                            result += Integer.parseInt(temp);
                            continue;
                        }
                        if (temp.equals("(")) {
                            dq.push(String.valueOf(result == 0 ? 2 : result * 2));
                            break;
                        }else{
                            flag = true;
                            break f1;
                        }
                    }
                    break;
                case "]":
                    while (true) {
                        if (dq.isEmpty()) {
                            flag = true;
                            break f1;
                        }

                        temp = dq.pop();
                        if (isNumber(temp)) {
                            result += Integer.parseInt(temp);
                            continue;
                        }
                        if (temp.equals("[")) {
                            dq.push(String.valueOf(result == 0 ? 3 : result * 3));
                            break;
                        }else{
                            flag = true;
                            break f1;
                        }
                    }
                    break;
            }
        }

        int answer = 0;
        if (flag != true) {
            while (!dq.isEmpty()) {
                String str = dq.pop();
                if (!isNumber(str)) {
                    answer = 0;
                    break;
                }
                answer += Integer.parseInt(str);
            }
        }
        System.out.println(answer);
    }

    static boolean validateString(String str) {
        return str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]");
    }

    static boolean isNumber(String str) {
        return !str.equals("(") && !str.equals("[");
    }
}
