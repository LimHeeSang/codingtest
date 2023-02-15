package baekjoon.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Trie3_14426 {

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new Node();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            insert(word);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (contains(word)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static class Node {
        Map<Character, Node> childs = new HashMap<>();
        boolean isEndAlphabet;
    }

    static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.childs.containsKey(word.charAt(i))) {
                node.childs.put(word.charAt(i), new Node());
            }
            node = node.childs.get(word.charAt(i));
        }
        node.isEndAlphabet = true;
    }

    static boolean contains(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.childs.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.childs.get(word.charAt(i));
        }
        return true;
    }
}
