public class ValidSudoku {
        public boolean verify_sudoku_board(ArrayList<ArrayList<Integer>> board) {
        // Write your code here
        HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
        HashSet<Integer>[][] patchSet = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                patchSet[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size();j++) {
                Integer val = board.get(i).get(j);
                if (val == 0) {
                    continue;
                }
                HashSet<Integer> rs = rowMap.computeIfAbsent(i, k -> new HashSet<Integer>());
                HashSet<Integer> cs = colMap.computeIfAbsent(j, k -> new HashSet<Integer>());

                if (rs.contains(val) || cs.contains(val)) {
                    return false;
                }

                if (patchSet[i/3][j/3].contains(val)) {
                    return false;
                }

                rs.add(val);
                cs.add(val);
                patchSet[i/3][j/3].add(val);
            }
        }

        return true;
    }
}