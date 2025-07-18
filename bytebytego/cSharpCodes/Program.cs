// See https://aka.ms/new-console-template for more information
using System.Text.Json;

Console.WriteLine(
    JsonSerializer.Serialize(
        PairSumUnsorted.PairSumUnsortedFunc(new List<int>() { -1, 3, 4, 2 }, 3)
    )
);
