package Lab6;

import java.util.Stack;

public class Section7_8 extends Tree2 {
    private static final char EMPTY = 0;
    private static Stack stack_prefix;
    private static Node2 treeRoot;

    // function to traverse through a tree to create prefix notation
    public static void convertToPrefix(Node2 n) {
        if (stack_prefix == null) {
            stack_prefix = new Stack<>();
        }
        if (n.leftChild == null && n.rightChild == null) {
            if (n.operation != EMPTY)
                stack_prefix.push(n.operation);
            else
                stack_prefix.push(n.value);
        } else {
            if (n.operation != EMPTY)
                stack_prefix.push(n.operation);
            else
                stack_prefix.push(n.value);
            convertToPrefix(n.leftChild);
            convertToPrefix(n.rightChild);
        }
    }

    public static Node2 createTreeFromPrefix() {
        // reverse the stack
        Stack reversedStack = new Stack();
        while (!stack_prefix.isEmpty()) {
            reversedStack.push(stack_prefix.pop());
        }
        return createTreeFromPrefixRecursive(reversedStack);
    }

    // recursive function to read and generate a tree from prefix notation
    private static Node2 createTreeFromPrefixRecursive(Stack s) {
        Node2 n = new Node2();

        // get the top token
        Object token = s.pop();

        if (token instanceof Integer) {
            n = node((Integer) token);
        } else if (token instanceof Character) {
            n = node((char) token, createTreeFromPrefixRecursive(s), createTreeFromPrefixRecursive(s));
        }
        return n;
    }

    public static void main(String[] args) {
        Node2 a = node(2);
        Node2 b = node(3);
        Node2 c = node('+', a, b);
        Node2 d = node(5);
        Node2 e = node(1);
        Node2 f = node('-', d, e);
        Node2 g = node('*', c, f);
        Node2 h = node(8);
        treeRoot = node('/', g, h);

        // print the original tree
        showTree(1, treeRoot);

        // test method convertToPrefix()
        convertToPrefix(treeRoot);

        // print the prefix expression
        System.out.println(stack_prefix);
        // stack_prefix.pop();
        // System.out.println(stack_prefix);

        // test method createTreeFromPrefix()
        Node2 newTree = createTreeFromPrefix();
        showTree(1, newTree);
    }
}
