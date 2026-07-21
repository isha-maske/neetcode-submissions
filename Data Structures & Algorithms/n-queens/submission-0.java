class Solution {

    private List<List<String>> result = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDiag = new HashSet<>();
    private Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, n);

        return result;
    }

    private void backtrack(int row, char[][] board, int n) {

        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) ||
                posDiag.contains(row + col) ||
                negDiag.contains(row - col)) {
                continue;
            }

            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            board[row][col] = 'Q';

            backtrack(row + 1, board, n);

            board[row][col] = '.';

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}
