package baekjoon.dynamic;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Dynamic4_1003 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] input = new int[t];

        for(int i=0; i<t; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[2][41];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=40; i++) {

            dp[0][i] = dp[0][i-1]+dp[0][i-2];
            dp[1][i] = dp[1][i-1]+dp[1][i-2];
        }

        for(int i=0; i<t; i++) {
            bw.write(dp[0][input[i]] + " " + dp[1][input[i]] + "\n");
        }
        bw.flush();
        bw.close();
    }
}