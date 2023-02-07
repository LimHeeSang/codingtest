package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Graph10_1991 {

    static int n;
    static Node root;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            createNode(st.nextToken(), st.nextToken(), st.nextToken());
        }

        preOrder(root);
        for (String r : result) {
            bw.write(r);
        }
        bw.write("\n");
        result.clear();

        inOrder(root);
        for (String r : result) {
            bw.write(r);
        }
        bw.write("\n");
        result.clear();

        postOrder(root);
        for (String r : result) {
            bw.write(r);
        }
        result.clear();

        bw.flush();
        bw.close();
    }

    static void createNode(String data, String leftData, String rightData) {
        if (root == null) {
            root = new Node(data);
            if (!leftData.equals(".")) {
                root.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                root.right = new Node(rightData);
            }
        }
        searchNode(root, data, leftData, rightData);
    }

    static void searchNode(Node node, String data, String leftData, String rightData) {
        if (node == null) {
            return;
        }
        if (node.data.equals(data)) {
            if (!leftData.equals(".")) {
                node.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                node.right = new Node(rightData);
            }
        }
        searchNode(node.left, data, leftData, rightData);
        searchNode(node.right, data, leftData, rightData);
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        result.add(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        result.add(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        result.add(node.data);
    }

    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }
    }
}
