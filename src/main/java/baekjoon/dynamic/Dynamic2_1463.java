package baekjoon.dynamic;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.Arrays;

public class Dynamic2_1463 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int INF = 9999;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        Arrays.fill(dp, INF);
        dp[1] = 0;

        for(int i=2; i<=n; i++) {
            if(i%3 == 0 ) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}