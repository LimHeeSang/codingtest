package baekjoon.sort;
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Sort3_1427 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] count = new int[10];

        while(n!=0) {
            count[n%10] +=1;
            n /= 10;
        }

        for(int i=9; i>=0; i--) {
            for(int j = 0; j<count[i]; j++)
                System.out.print(i);
        }

    }

}