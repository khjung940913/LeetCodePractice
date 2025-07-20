import java.util.ArrayList;
import java.util.HashSet;
class UserCode {

    public static void zeroStriping(ArrayList<ArrayList<Integer>> matrix) {
        // // Write your code here
        // var rowSet = new HashSet<Integer>();
        // var colSet = new HashSet<Integer>();

        // for(int i = 0; i < matrix.size();i++) {
        //     for (int j = 0; j < matrix.get(i).size(); j++) {
        //         if (matrix.get(i).get(j) == 0) {
        //             rowSet.add(i);
        //             colSet.add(j);
        //         }
        //     }
        // }

        // for(int i = 0; i < matrix.size();i++) {
        //     for (int j = 0; j < matrix.get(i).size(); j++) {
        //         if (rowSet.contains(i) || colSet.contains(j)) {
        //             matrix.get(i).set(j, 0);
        //         }
        //     }
        // }
        zeroStripingInPlace(matrix);
    }

    public static void zeroStripingInPlace(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here
        if (matrix.isEmpty()) return;
        if (matrix.get(0).isEmpty()) return;
        var firstRowHasZero = false;
        var firstColHasZero = false;
        for (int i = 0; i < matrix.get(0).size(); i++) {
            if (matrix.get(0).get(i) == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix.size(); j++) {
            if (matrix.get(j).get(0) == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(0).set(j, 0);
                    matrix.get(i).set(0, 0);
                }
            }
        }

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {
                if (matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
                if (matrix.get(i).get(0) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < matrix.get(0).size(); i++) {
                matrix.get(0).set(i, 0);
            }
        }

        if (firstColHasZero) {
            for (int j = 0; j < matrix.size(); j++) {
                matrix.get(j).set(0, 0);
            }
        }
    }
}