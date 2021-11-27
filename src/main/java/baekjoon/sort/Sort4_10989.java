package baekjoon.sort;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Sort4_10989 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[10000001];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++)
            count[arr[i]]++;

        for(int i=0; i<10000001; i++)
            for(int j=0; j<count[i]; j++)
                bw.write(i + "\n");

        bw.flush();
        bw.close();
    }

}
