package baekjoon.dynamic;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Dynamic3_9095 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        int[] dp = new int[12];

        for(int i=0; i<t; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] =1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i=0; i<t; i++) {
            bw.write(dp[num[i]]+"\n");
        }
        bw.flush();
        bw.close();

    }
}

