package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String12_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence;
        while ((sentence = br.readLine()) != null) {
            int lowerCount = 0;
            int upperCount = 0;
            int numberCount = 0;
            int blankCount = 0;

            int index = 0;
            while (index < sentence.length()) {
                char alphabet = sentence.charAt(index);
                if (Character.isLowerCase(alphabet)) {
                    lowerCount++;
                } else if (Character.isUpperCase(alphabet)) {
                    upperCount++;
                } else if (Character.isDigit(alphabet)) {
                    numberCount++;
                } else if (alphabet == ' ') {
                    blankCount++;
                }
                index++;
            }
            System.out.println(lowerCount + " " + upperCount + " "
                    + numberCount + " " + blankCount);
        }
    }
}
