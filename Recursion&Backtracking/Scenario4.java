import java.util.*;

public class Scenario4 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        backtrack(n, 0, cols);
        return result;
    }

    void backtrack(int n, int row, int[] cols) {
        if (row == n) {
            result.add(buildBoard(n, cols));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, cols)) {
                cols[row] = col;
                backtrack(n, row + 1, cols);
            }
        }
    }

    boolean isSafe(int row, int col, int[] cols) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col || Math.abs(cols[i]-col)==Math.abs(i-row)) return false;
        }
        return true;
    }

    List<String> buildBoard(int n, int[] cols) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[cols[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }
}