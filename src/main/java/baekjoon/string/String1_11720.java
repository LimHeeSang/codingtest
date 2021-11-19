package baekjoon.string;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class String1_11720 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String st = br.readLine();

        int sum =0;
        for(int i=0; i<n; i++) {
            sum += st.charAt(i) - '0';	//charAt은 해당 문자의 아스키코드 값을 반환
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }
}