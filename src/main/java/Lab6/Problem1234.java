package Lab6;

public class Problem1234 extends Tree2 {
    // variable to hold the global root tree
    private static Node2 treeRoot;

    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    // Problem 1
    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    public static int countNodes() {
        return countNodesRecursive(treeRoot);
    }

    private static int countNodesRecursive(Node2 t) {
        if (t == null) {
            return 0;
        }
        return 1 + countNodesRecursive(t.leftChild) + countNodesRecursive(t.rightChild);
    }

    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    // Problem 2
    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    public static int getHeight() {
        return heightRecursive(treeRoot);
    }

    private static int heightRecursive(Node2 t) {
        if (t == null) {
            return -1; // Height of null tree is -1, leaf node will have height 0
        }
        if (t.leftChild == null && t.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursive(t.leftChild), heightRecursive(t.rightChild));
    }

    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    // Problem 3
    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    public static boolean isFullyBalanced() {
        return isFullyBalancedRecursive(treeRoot);
    }

    private static boolean isFullyBalancedRecursive(Node2 t) {
        if (t == null) {
            return true;
        }
        int leftHeight = heightRecursive(t.leftChild);
        int rightHeight = heightRecursive(t.rightChild);

        if (Math.abs(leftHeight - rightHeight) <= 1
                && isFullyBalancedRecursive(t.leftChild)
                && isFullyBalancedRecursive(t.rightChild)) {
            return true;
        }
        return false;
    }

    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    // Problem 4
    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    private static boolean isIdenticalWithRecursive(Node2 root, Node2 t) {
        if (root == null && t == null) {
            return true;
        }
        if (root != null && t != null) {
            return root.value == t.value && isIdenticalWithRecursive(root.leftChild, t.leftChild)
                    && isIdenticalWithRecursive(root.rightChild, t.rightChild);
        }
        return false;
    }

    public static boolean isIdenticalWith(Node2 t) {
        return isIdenticalWithRecursive(treeRoot, t);
    }

    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    // Main class for testing
    // ⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘⫘
    public static void main(String[] args) {
        // ────────────୨ৎ────────────
        // Create root tree
        // ────────────୨ৎ────────────
        Node2 a = node(2);
        Node2 b = node(3);
        Node2 c = node('+', a, b);
        Node2 d = node(5);
        Node2 e = node(1);
        Node2 f = node('-', d, e);
        Node2 g = node('*', c, f);
        Node2 h = node(8);
        treeRoot = node('/', g, h);

        // ────────────୨ৎ────────────
        // print tree
        // ────────────୨ৎ────────────
        System.out.println("Tree:");
        showTree(0, treeRoot);

        // ────────────୨ৎ────────────
        // test problem 1
        // ────────────୨ৎ────────────
        System.out.println("Number of elements: " + countNodes());

        // ────────────୨ৎ────────────
        // test problem 2
        // ────────────୨ৎ────────────
        System.out.println("Height of tree: " + getHeight());

        // ────────────୨ৎ────────────
        // test problem 3
        // ────────────୨ৎ────────────
        System.out.println("Is fully balanced: " + isFullyBalanced());

        // ────────────୨ৎ────────────
        // test problem 4
        // ────────────୨ৎ────────────
        // create identical tree
        Node2 a2 = node(2);
        Node2 b2 = node(3);
        Node2 c2 = node('+', a2, b2);
        Node2 d2 = node(5);
        Node2 e2 = node(1);
        Node2 f2 = node('-', d2, e2);
        Node2 g2 = node('*', c2, f2);
        Node2 h2 = node(8);
        Node2 identicalTree = node('/', g2, h2);
        System.out.println("Is identical with copy: " + isIdenticalWith(identicalTree));

        // create non-identical tree
        Node2 differentTree = node(10);
        System.out.println("Is identical with different tree: " + isIdenticalWith(differentTree));
    }
}