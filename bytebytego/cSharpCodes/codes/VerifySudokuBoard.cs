public class VerifySudokuBoard
{
    public static Boolean verify_sudoku_board(int[][] board) {
        // Write your code here
        var rowMap = new Dictionary<int, HashSet<int>>();
        var colMap = new Dictionary<int, HashSet<int>>();
        HashSet<int>[][] patchSet = new HashSet<int>[3][];
        for (int i = 0; i < 3; i++) {
            patchSet[i] = new HashSet<int>[3];
            for (int j = 0; j < 3; j++)
            {
                patchSet[i][j] = new HashSet<int>();
            }
        }
        for (int i = 0; i < board.Count(); i++) {
            for (int j = 0; j < board[i].Count(); j++) {
                int val = board[i][j];
                if (val == 0) {
                    continue;
                }
                HashSet<int> rs = rowMap.GetValueOrDefault(i, new HashSet<int>());
                HashSet<int> cs = colMap.GetValueOrDefault(i, new HashSet<int>());

                if (rs.Contains(val) || cs.Contains(val)) {
                    return false;
                }

                if (patchSet[i / 3][j / 3].Contains(val)) {
                    return false;
                }

                rs.Add(val);
                cs.Add(val);
                patchSet[i / 3][j / 3].Add(val);
            }
        }

        return true;
    }
}