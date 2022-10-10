package jianzhiOffer2;

public class Solution12 {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.exist(chars, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ifExist(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ifExist(char[][] board, int i, int j, char[] words, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }
        if (board[i][j] != words[k]) {
            return false;
        }
        if (words.length == k + 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '1';
        if (ifExist(board, i + 1, j, words, k + 1)) {
            return true;
        }
        if (ifExist(board, i - 1, j, words, k + 1)) {
            return true;
        }
        if (ifExist(board, i, j + 1, words, k + 1)) {
            return true;
        }
        if (ifExist(board, i, j - 1, words, k + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
