package note.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tree {

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int a, b, c;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            createNode(a, b, c);
        }

        //전위순회
        preOrder(root);
        System.out.println();

        //전위순회2
        preOrder2(root);
        System.out.println();

        //중위순회
        inOrder(root);
        System.out.println();

        //후위순회
        postOrder(root);
        System.out.println();

        //레벨순회
        levelOrder(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void createNode(int data, int leftData, int rightData) {
        if (root == null) {
            root = new Node(data);

            if (leftData != -1) {
                root.left = new Node(leftData);
            }
            if (rightData != -1) {
                root.right = new Node(rightData);
            }
        }
        searchNode(root, data, leftData, rightData);
    }

    public static void searchNode(Node node, int data, int leftData, int rightData) {
        if (node == null) {
            return;
        }
        if (node.data == data) {
            if (leftData != -1) {
                node.left = new Node(leftData);
            }
            if (rightData != -1) {
                node.right = new Node(rightData);
            }
        }
        searchNode(node.left, data, leftData, rightData);
        searchNode(node.right, data, leftData, rightData);
    }

    // 전위순회 루트 -> 왼쪽 -> 오른 = 깊이우선탐색
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //전위순회 스택으로 구현해보기
    public static void preOrder2(Node node) {
        Deque<Node> dq = new LinkedList<>();

        dq.offerLast(node);

        while (!dq.isEmpty()) {
            Node pNode = dq.pollLast();

            System.out.print(pNode.data + " ");
            if (pNode.right != null) {
                dq.offerLast(pNode.right);
            }
            if (pNode.left != null) {
                dq.offerLast(pNode.left);
            }
        }
    }

    // 중위순회 왼쪽 -> 루트 -> 오른
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // 후위순회 왼쪽 -> 오른쪽 -> 루트
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // 레벨순회 각 레벨에 맞게 순회 = 너비우선탐색
    public static void levelOrder(Node node) {

        Queue<Node> q = new LinkedList<>();

        q.offer(node);

        while (!q.isEmpty()) {
            Node pNode = q.poll();

            System.out.print(pNode.data + " ");

            if (pNode.left != null) {
                q.offer(pNode.left);
            }
            if (pNode.right != null) {
                q.offer(pNode.right);
            }

        }
    }
}


