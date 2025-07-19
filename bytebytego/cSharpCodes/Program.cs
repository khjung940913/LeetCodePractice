// See https://aka.ms/new-console-template for more information
using System.Text.Json;

// Console.WriteLine(
//     JsonSerializer.Serialize(
//         PairSumUnsorted.PairSumUnsortedFunc(new List<int>() { -1, 3, 4, 2 }, 3)
//     )
// );


Console.WriteLine(
    JsonSerializer.Serialize(
        VerifySudokuBoard.verify_sudoku_board(new int[9][] {
            new int[]{3,0,6,0,5,8,4,0,0 },
            new int[]{5,2,0,0,0,0,0,0,0 },
            new int[]{0,8,7,0,0,0,0,3,1 },
            new int[]{1,0,2,5,0,0,3,2,0 },
            new int[]{9,0,0,8,6,3,0,0,5 },
            new int[]{0,5,0,0,9,0,6,0,0 },
            new int[]{0,1,0,0,0,0,0,7,4 },
            new int[]{0,3,0,0,0,8,2,5,0 },
            new int[]{0,0,5,2,0,6,0,0,0 }
        })
    )
);