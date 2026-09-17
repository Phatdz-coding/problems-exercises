package DFS;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private static int operations = 0;

    public static void main(String[] args) {
        // init node
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node i = new Node("i");

        // construct the graph
        a.leftChild = d;
        a.rightChild = b;

        b.leftChild = e;
        b.rightChild = c;

        c.leftChild = f;

        d.leftChild = h;

        e.leftChild = h;

        g.leftChild = d;

        h.leftChild = g;
        h.rightChild = f;

        i.leftChild = h;


        List<Object> dfsOrder = depthFirstTraversal(a);
        System.out.println("DFS from a: " + dfsOrder);
        System.out.println("Number of operations: " + operations);


    }

    private static List<Object> depthFirstTraversal(Node start) {
        List<Object> order = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        operations = 0;
        dfs(start, visited, order);
        return order;
    }

    private static void dfs(Node node, Set<Node> visited, List<Object> order) {
        if (node == null || visited.contains(node)) {
            return;
        }

        operations++;

        visited.add(node);
        order.add(node.data);

        dfs(node.leftChild, visited, order);
        dfs(node.rightChild, visited, order);
    }
}
