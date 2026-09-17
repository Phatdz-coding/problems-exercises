package Leetcode;

class Solution79 {
    private char[][] board;
    private String word;

    private boolean dfs(int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        char saved = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(row + 1, col, index + 1)
                || dfs(row - 1, col, index + 1)
                || dfs(row, col + 1, index + 1)
                || dfs(row, col - 1, index + 1);

        board[row][col] = saved;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        if (word.length() > board.length * board[0].length) {
            return false;
        }

        int[] boardCount = new int[128];
        int[] wordCount = new int[128];

        for (char[] row : board) {
            for (char cell : row) {
                boardCount[cell]++;
            }
        }

        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            wordCount[letter]++;
            if (wordCount[letter] > boardCount[letter]) {
                return false;
            }
        }

        if (boardCount[word.charAt(0)] > boardCount[word.charAt(word.length() - 1)]) {
            this.word = new StringBuilder(word).reverse().toString();
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class LC79 {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'B', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A', 'A', 'A' }
        };

        Solution79 s = new Solution79();
        System.out.println(s.exist(board, "AB"));
    }
}
