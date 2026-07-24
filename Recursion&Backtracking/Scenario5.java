public class Scenario5 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (backtrack(board, word, 0, i, j, visited))
                    return true;

        return false;
    }

    boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean found =
            backtrack(board, word, index + 1, row + 1, col, visited) ||
            backtrack(board, word, index + 1, row - 1, col, visited) ||
            backtrack(board, word, index + 1, row, col + 1, visited) ||
            backtrack(board, word, index + 1, row, col - 1, visited);

        visited[row][col] = false;
        return found;
    }
}