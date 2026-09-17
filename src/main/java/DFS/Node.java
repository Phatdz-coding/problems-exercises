package DFS;

public class Node {
    public Object data;
    public Node leftChild;
    public Node rightChild;

    public Node(Object data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(Object data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(Object data, Node leftChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = null;
    }
}