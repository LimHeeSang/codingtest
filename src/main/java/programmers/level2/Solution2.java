package programmers.level2;

import java.util.Locale;

public class Solution2 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] splited = s.split(" ");
        for (String split : splited) {
            sb.append(changeString(split)).append(" ");
        }

        if (s.charAt(s.length() - 1) == ' ') {
            return sb.toString();
        } else {
            return sb.substring(0, sb.length() - 1).toString();
        }
    }

    public String changeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (i == 0) {
                if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
                    ch = Character.toUpperCase(ch);
                }
            } else {
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                }
            }
            sb.append(String.valueOf(ch));
        }
        return sb.toString();
    }
}
