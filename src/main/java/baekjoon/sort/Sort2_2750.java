package baekjoon.sort;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Sort2_2750 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 수의 범위 -1000000 ~ 1000000
        // 기준점 0 = index 1000000으로 시작
        boolean[] count = new boolean[2000001];


        for(int i=0; i<n; i++)
            count[Integer.parseInt(br.readLine()) + 1000000] = true;


        for(int i=0; i<count.length; i++) {
            if(count[i] == true)
                bw.write((i-1000000) + "\n");
        }
        bw.flush();
        bw.close();
    }

}