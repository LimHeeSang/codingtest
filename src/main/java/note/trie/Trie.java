package note.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static Node root;

    public static void main(String[] args) {
        root = new Node();
        insert("kakao");
        insert("busy");
        insert("busywaiting");
        insert("kakaofriends");
        insert("cap");
        insert("kkkao");

        delete(root, "busy", 0);
        delete(root, "kakaofriends", 0);

        System.out.println(contains("kakao"));
        System.out.println(contains("busy"));
        System.out.println(contains("hi"));
        System.out.println(contains("busywaiting"));
        System.out.println(contains("kakaofriends"));
        System.out.println(contains("cap"));
        System.out.println(contains("kkkao"));
    }

    static class Node {
        Map<Character, Node> childs = new HashMap<>();
        boolean isEndOfWord;
    }

    static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.childs.containsKey(word.charAt(i))) {
                node.childs.put(word.charAt(i), new Node());
            }
            node = node.childs.get(word.charAt(i));
        }
        node.isEndOfWord = true;
    }

    static boolean contains(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.childs.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.childs.get(word.charAt(i));
        }
        return node.isEndOfWord;
    }

    // 해당 단어가 트라이에 있다고 가정
    static void delete(Node node, String word, int depth) {
        if (depth == word.length() && node.isEndOfWord) {
            node.isEndOfWord = false;
            return;
        }

        char key = word.charAt(depth);
        Node childNode = node.childs.get(key);
        delete(childNode, word, depth + 1);
        if (childNode.childs.isEmpty() && !childNode.isEndOfWord) {
            node.childs.remove(key);
        }
    }
}
