package note.stack;

public class Stack_List {

    Node top;

    public Stack_List() {
        this.top = null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.linkNode(top);
        top = node;
    }

    public int peek() {
        return top.getData();
    }

    public void pop() {
        if (empty())
            throw new ArrayIndexOutOfBoundsException();
        else {
            top = top.getNextNode();
        }
    }

    public int search(int item) {
        Node searchNode = top;
        int index = 1;
        while(true) {
            if (searchNode.getData() == item) {
                return index;
            } else {
                searchNode = searchNode.getNextNode();
                index ++;
                if (searchNode == null)
                    break;
            }
        }

        return -1;
    }

    public boolean empty() {
        return top == null;
    }
}


class Node {

    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public void linkNode(Node node) {
        this.nextNode = node;
    }

    public int getData() {
        return this.data;
    }

    public Node getNextNode() {
        return this.nextNode;
    }
}


