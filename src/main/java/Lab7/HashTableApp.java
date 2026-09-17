package Lab7;

import java.util.Hashtable;

public class HashTableApp {
    public static int CAPACITY;
    public static Hashtable<Integer, Integer> ht;
    private static int probeCount = 1;
    private static int totalProbe = 0;

    public static int hashFunction(int value) {
        return value % CAPACITY;
    }

    public static int probe(int hashValue) {
        return (hashValue + probeCount*(probeCount++)) % CAPACITY;
    }

    public static void insertToHashTable(int[] values) {
        for (int value : values) {
            int hashValue = hashFunction(value);
            while (ht.containsKey(hashValue)) {
                probeCount = 1;
                hashValue = probe(hashValue);
            }
            ht.put(hashValue, value);
            System.out.println("Inserted " + value + ". Probe length: " + probeCount);
            totalProbe += probeCount;
        }
        System.out.println("Quadratic probing:");
        System.out.println("Total probe length: " + totalProbe);
        System.out.println("Average probe length: " + (double) totalProbe / CAPACITY);
    }

    public static void initializeHashTable(int size) {
        CAPACITY = size;
        ht = new Hashtable<Integer, Integer>(CAPACITY);
    }

    public static void main(String[] args) {
        System.out.println("Quad probing test:");
        int[] values = { 5, 19, 23, 39, 41, 49, 22, 12, 88, 69, 77, 36,63, 51, 44, 11, 21, 55, 15, 25 };
        initializeHashTable(values.length);

        insertToHashTable(values);

        System.out.println(ht.entrySet());
    }
}