package baekjoon.dynamic;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.Arrays;

public class Dynamic1_2839 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int INF = 9999;
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        Arrays.fill(dp, INF);

        if(n>=3) {
            dp[3] = 1;
            if(n>=5) {
                dp[5] =1;
            }
        }

        if(n>=6) {
            for(int i=6; i<=n; i++) {
                if(dp[i-5] == INF && dp[i-3] == INF) {
                    continue;
                }
                dp[i] = Math.min(dp[i-5], dp[i-3])+1;
            }
        }


        if(dp[n] == INF) {
            bw.write(String.valueOf(-1));
        }else {
            bw.write(String.valueOf(dp[n]));
        }
        bw.flush();
        bw.close();
    }
}