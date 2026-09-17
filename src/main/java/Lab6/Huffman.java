package Lab6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Huffman extends Tree2 {
    private static String message;
    private static Map<String, Integer> dictionary = null;

    // new display method for readability
    public static void showTree(int n, Node2 t) {
        if (t == null) return;
        tab(n);
        if (t.leftChild == null && t.rightChild == null) {
            System.out.println("'" + t.character + "' (" + t.value + ")");
        } else {
            System.out.println("Node (" + t.value + ")");
            showTree(n + 2, t.leftChild);
            showTree(n + 2, t.rightChild);
        }
    }

    // count the number of occurrences of a character in the message
    // use String instead of char for further processing like words or phrases
    public static int countChar(String s) {
        int count = 0;
        for (char ch : message.toCharArray()) {
            if (ch == s.charAt(0)) {
                count++;
            }
        }
        return count;
    }

    // sorting algorithm to sort the dictionary in ascending order
    private static void sortDictionary() {
        if (dictionary == null)
            return;

        dictionary = dictionary.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public static Map<String, Integer> getDictionary() {
        if (dictionary != null)
            return dictionary;

        dictionary = new HashMap<String, Integer>();
        for (char c : message.toCharArray()) {
            // Implementation for generating dictionary
            dictionary.put(String.valueOf(c), countChar(String.valueOf(c)));
        }

        // sort the dictionary by the frequency
        sortDictionary();

        return dictionary;
    }

    // set new message method
    public static void setMessage(String message) {
        if (dictionary != null) {
            dictionary.clear();
        }

        Huffman.message = message;
        dictionary = null;
    }

    // note: a token can be a single character or a word, depend on the
    // getDictionary() method
    public static int getTotalToken() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    // generate binary tree using Huffman coding algorithm
    public static Node2 getTree() {
        if (dictionary == null || dictionary.isEmpty())
            return null;

        // use a priorityQueue to store nodes, ordered by frequency
        PriorityQueue<Node2> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));

        // Create leaf nodes for each character in the dictionary
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            Node2 leaf = new Node2();
            leaf.character = entry.getKey();
            leaf.value = entry.getValue();
            pq.add(leaf);
        }

        // Build the tree by combining the two nodes with the lowest frequencies
        while (pq.size() > 1) {
            Node2 left = pq.poll();
            Node2 right = pq.poll();

            Node2 parent = new Node2();
            parent.value = left.value + right.value;
            parent.leftChild = left;
            parent.rightChild = right;

            pq.add(parent);
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        // the message is the required text in the Lab6
        String orignalMessage = "I am a student at International University. My name is PhatDZ. I am working on a DSA lab";

        // test getDictionary() method
        setMessage(orignalMessage);
        System.out.println(getDictionary());
        System.out.println("Total tokens: " + getTotalToken());

        // test building tree
        Node2 root = getTree();
        System.out.println("Huffman Tree Structure (Root value: " + (root != null ? root.value : "null") + "):");
        showTree(0, root);
    }
}
