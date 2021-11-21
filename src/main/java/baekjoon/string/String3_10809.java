package baekjoon.string;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class String3_10809 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(char ch = 'a'; ch<='z'; ch++) {
            bw.write(str.indexOf(ch) +" ");
        }
        bw.flush();
        bw.close();
    }
}