package baekjoon.bruteforce;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.*;

public class Bruteforce3_2789 {

    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        boolean[] visited = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        comb(cards, visited, 0, n, 3, m);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    static void comb(int[] arr, boolean[] visited, int start, int n, int r, int m) {

        if (r == 0) {
            int sum = 0;
            for(int i =0 ; i < visited.length; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }
            if(max<sum && sum<=m) {
                max = sum;
            }
            return;
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r-1, m);
            visited[i] = false;
        }
    }

}