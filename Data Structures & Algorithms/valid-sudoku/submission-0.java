class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                int boxIndex = (row / 3) * 3 + (col / 3);

                rows.putIfAbsent(row, new HashSet<>());
                cols.putIfAbsent(col, new HashSet<>());
                boxes.putIfAbsent(boxIndex, new HashSet<>());

                if (rows.get(row).contains(current) ||
                    cols.get(col).contains(current) ||
                    boxes.get(boxIndex).contains(current)) {

                    return false;
                }

                rows.get(row).add(current);
                cols.get(col).add(current);
                boxes.get(boxIndex).add(current);
            }
        }

        return true;
    }
}
