package note.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Perm_Comb {

    static int max = 0;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(arr, visited, 0, n, 3);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }


    //순열
    static void perm(int[] arr, boolean[] visited, int[] output,  int depth, int n, int r) {
        if (depth == r) {
            for(int i =0 ; i < r; i++) {
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, visited, output,depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }

    //중복순열
    static void dupPerm(int[] arr, boolean[] visited, int[] output,  int depth, int n, int r) {
        if (depth == r) {
            for(int i =0 ; i < r; i++) {
                System.out.print(output[i]+" ");
            }
            num++;
            System.out.println(num);
            return;
        }
        for (int i=0; i<n; i++) {
            //if (visited[i] != true) {
            //visited[i] = true;
            output[depth] = arr[i];
            dupPerm(arr, visited, output,depth + 1, n, r);
            //visited[i] = false;;
            //}
        }
    }


    //조합
    static void comb(int[] arr, boolean[] visited, int start, int n, int r) {

        if (r == 0) {

            for(int i =0 ; i < visited.length; i++) {
                if(visited[i]) {
                    System.out.print(arr[i]+" ");
                }
            }

            num++;
            System.out.println("-"+num+"번째경우");
            return;
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r-1);
            visited[i] = false;
        }

    }

    //중복조합
    static void dupComb(int[] arr, boolean[] visited, int[] output, int start, int n, int r,int cnt) {
        if (cnt == r) {
            for(int i =0 ; i < cnt; i++) {
                //if(visited[i]) {
                System.out.print(output[i]+" ");
                //	}
            }
            num++;
            System.out.println("-"+num+"번째경우");
            return;
        }
        for (int i=start-1; i<n; i++) {
            //   if (visited[i] != true) {
            //visited[i] = true;
            output[cnt] = arr[i];
            dupComb(arr, visited, output,i + 1, n, r,cnt+1);
            //visited[i] = false;;
            //  }
        }
    }
}
