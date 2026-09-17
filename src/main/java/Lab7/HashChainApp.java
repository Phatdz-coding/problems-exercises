package Lab7;

import java.util.*;

/**
 * HashChainApp — Hash Table with Separate Chaining
 *
 * Features:
 *   1. Display key sequence for initial table fill
 *   2. Display probe length for each find/insert operation
 *   3. Display average probe length for initial fill
 *   4. Investigate how load factor affects average probe length
 */
public class HashChainApp {

    // ─────────────────────────────────────────────────────────────────────────
    // Inner classes
    // ─────────────────────────────────────────────────────────────────────────

    /** A single node in a chain (linked list bucket). */
    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    /** Hash table that uses separate chaining for collision resolution. */
    static class HashTableChain {
        private final Node[] table;
        private final int capacity;
        private int size;

        // Tracks probe lengths of the most recent insert or find
        private int lastProbeLength;

        HashTableChain(int capacity) {
            this.capacity = capacity;
            this.table    = new Node[capacity];
            this.size     = 0;
        }

        // ── Hash function ────────────────────────────────────────────────────

        private int hash(int key) {
            return Math.abs(key % capacity);
        }

        // ── Insert ───────────────────────────────────────────────────────────

        /**
         * Insert a key and return the probe length for the operation.
         * Probe length = number of nodes inspected before inserting
         * (1 = empty slot, i.e. first position in chain).
         */
        int insert(int key) {
            int index = hash(key);
            int probes = 1;

            Node current = table[index];

            if (current == null) {
                // Empty bucket — direct insert
                table[index] = new Node(key);
            } else {
                // Walk to the end of the chain, counting probes
                while (current.next != null) {
                    if (current.key == key) {
                        // Duplicate key — no insert, return probe count so far
                        lastProbeLength = probes;
                        return probes;
                    }
                    current = current.next;
                    probes++;
                }
                // Check the last node
                if (current.key == key) {
                    lastProbeLength = probes;
                    return probes;
                }
                current.next = new Node(key);
                probes++;          // the new node itself counts as one probe
            }

            size++;
            lastProbeLength = probes;
            return probes;
        }

        // ── Find ─────────────────────────────────────────────────────────────

        /**
         * Search for a key and return the probe length.
         * Returns -1 (not found); probe length still recorded.
         */
        int find(int key) {
            int index = hash(key);
            int probes = 0;

            Node current = table[index];
            while (current != null) {
                probes++;
                if (current.key == key) {
                    lastProbeLength = probes;
                    return probes;      // found
                }
                current = current.next;
            }

            // Key not found
            lastProbeLength = probes;
            return -1;
        }

        // ── Accessors ────────────────────────────────────────────────────────

        int getLastProbeLength() { return lastProbeLength; }
        int getSize()            { return size; }
        int getCapacity()        { return capacity; }
        double getLoadFactor()   { return (double) size / capacity; }

        /** Pretty-print the entire table. */
        void display() {
            System.out.println("\n═══ Hash Table (capacity=" + capacity + ") ═══");
            for (int i = 0; i < capacity; i++) {
                System.out.printf("  [%2d] → ", i);
                Node cur = table[i];
                if (cur == null) {
                    System.out.print("(empty)");
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (cur != null) {
                        sb.append(cur.key);
                        if (cur.next != null) sb.append(" → ");
                        cur = cur.next;
                    }
                    System.out.print(sb);
                }
                System.out.println();
            }
            System.out.printf("  Load factor: %.2f  (%d/%d)%n",
                    getLoadFactor(), size, capacity);
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Requirement 1 & 2 & 3 — Initial fill with diagnostics
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Fills a hash table with the given keys,
     * printing the key sequence, per-insert probe length,
     * and the final average probe length.
     */
    static double initialFill(HashTableChain ht, int[] keys) {
        System.out.println("\n──────────────────────────────────────────────────");
        System.out.println("  INITIAL FILL  (table capacity = " + ht.getCapacity() + ")");
        System.out.println("──────────────────────────────────────────────────");

        // Requirement 1 — key sequence
        System.out.print("  Key sequence : ");
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i]);
            if (i < keys.length - 1) System.out.print(", ");
        }
        System.out.println();

        // Requirement 2 — probe length per insert
        System.out.println("\n  Insert log:");
        System.out.printf("  %-8s %-10s %-12s %-8s%n",
                "Key", "Index", "ProbeLen", "ChainLen");
        System.out.println("  " + "─".repeat(42));

        int totalProbes = 0;
        for (int key : keys) {
            int idx      = Math.abs(key % ht.getCapacity());
            int probeLen = ht.insert(key);
            totalProbes += probeLen;
            System.out.printf("  %-8d %-10d %-12d %-8d%n",
                    key, idx, probeLen, probeLen);
        }

        // Requirement 3 — average probe length
        double avg = (double) totalProbes / keys.length;
        System.out.println("  " + "─".repeat(42));
        System.out.printf("  Total probes : %d  |  Keys inserted : %d%n",
                totalProbes, keys.length);
        System.out.printf("  ➤ Average probe length : %.4f%n", avg);

        return avg;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Requirement 2 (find) — probe length for individual find operations
    // ─────────────────────────────────────────────────────────────────────────

    static void findDemo(HashTableChain ht, int[] keysToFind) {
        System.out.println("\n──────────────────────────────────────────────────");
        System.out.println("  FIND OPERATIONS");
        System.out.println("──────────────────────────────────────────────────");
        System.out.printf("  %-8s %-10s %-12s %-8s%n",
                "Key", "Index", "ProbeLen", "Found?");
        System.out.println("  " + "─".repeat(42));

        for (int key : keysToFind) {
            int result   = ht.find(key);
            int probeLen = ht.getLastProbeLength();
            int idx      = Math.abs(key % ht.getCapacity());
            String found = (result == -1) ? "No" : "Yes";
            System.out.printf("  %-8d %-10d %-12d %-8s%n", key, idx, probeLen, found);
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Requirement 4 — Load factor investigation
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Generates random keys and measures average probe length
     * across a range of load factors for a fixed table capacity.
     */
    static void investigateLoadFactor(int tableCapacity, int trialCount) {
        System.out.println("\n══════════════════════════════════════════════════════");
        System.out.println("  LOAD FACTOR INVESTIGATION");
        System.out.printf("  Table capacity: %d  |  Random keys per trial: varied%n",
                tableCapacity);
        System.out.println("══════════════════════════════════════════════════════");
        System.out.printf("  %-14s %-12s %-18s%n",
                "Load Factor", "Keys (#)", "Avg Probe Length");
        System.out.println("  " + "─".repeat(46));

        // Target load factors from 0.1 to 2.0 (chains can exceed 1.0)
        double[] loadFactors = { 0.10, 0.25, 0.50, 0.75, 1.00, 1.25, 1.50, 1.75, 2.00 };
        Random rng = new Random(42); // fixed seed for reproducibility

        for (double lf : loadFactors) {
            int numKeys = (int) Math.ceil(lf * tableCapacity);
            double totalAvg = 0.0;

            for (int t = 0; t < trialCount; t++) {
                HashTableChain ht = new HashTableChain(tableCapacity);
                int totalProbes = 0;

                // Generate unique random keys
                Set<Integer> seen = new HashSet<>();
                int inserted = 0;
                while (inserted < numKeys) {
                    int key = rng.nextInt(tableCapacity * 10);
                    if (seen.add(key)) {
                        totalProbes += ht.insert(key);
                        inserted++;
                    }
                }
                totalAvg += (double) totalProbes / numKeys;
            }

            double avg = totalAvg / trialCount;
            System.out.printf("  %-14.2f %-12d %-18.4f%n", lf, numKeys, avg);
        }

        System.out.println("  " + "─".repeat(46));
        System.out.println("\n  Observation: As load factor increases, average probe");
        System.out.println("  length grows — slowly at first, then more steeply.");
        System.out.println("  Chaining handles overload (λ > 1) gracefully, unlike");
        System.out.println("  open addressing which degrades rapidly near full.");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Main
    // ─────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {

        // ── Demo 1: Initial fill ────────────────────────────────────────────
        int tableSize = 11; // prime size reduces clustering
        HashTableChain ht = new HashTableChain(tableSize);

        // Sample keys (you can change these)
        int[] keys = { 20, 34, 45, 70, 56, 23, 90, 11, 34, 7, 80, 44 };

        double avgProbe = initialFill(ht, keys);

        // Display the filled table
        ht.display();

        // ── Demo 2: Find operations ─────────────────────────────────────────
        int[] findKeys = { 45, 70, 99, 11, 200 }; // mix of present/absent
        findDemo(ht, findKeys);

        // ── Demo 3: Load factor investigation ──────────────────────────────
        investigateLoadFactor(100, 50); // capacity=100, 50 random trials each
    }
}