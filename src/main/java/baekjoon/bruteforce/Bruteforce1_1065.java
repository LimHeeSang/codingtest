package baekjoon.bruteforce;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Bruteforce1_1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int totalCount = 0;

        for(int i=n; i>=1; i--) {
            if(n<10) {
                totalCount = n;
                break;
            }
            if(n>=10 && n<=99) {
                totalCount = n;
                break;
            }

            if(i<=99) {
                totalCount += 99;
                break;
            }


            String[] str = String.valueOf(i).split("");

            int[] box = new int[str.length];

            for(int j=0; j<str.length; j++) {
                box[j] = Integer.parseInt(str[j]);
            }



            int a, b, c;

            //4자리 = 1000
            if(str.length == 4) {
                a = box[1]-box[0];
                b = box[2]-box[1];
                c = box[1]-box[0];

                if(a==b && b==c) {
                    totalCount++;
                }
            }

            if(str.length == 3) {
                a = box[1]-box[0];
                b = box[2]-box[1];

                if(a==b) {
                    totalCount++;
                }
            }

        }

        bw.write(String.valueOf(totalCount));
        bw.flush();
        bw.close();

    }

}