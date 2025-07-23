public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        Dictionary<char, int> currCountMap = new Dictionary<char, int>();
        Dictionary<char, int> pCountMap = new Dictionary<char, int>();
        foreach(char c in p) {
            if (!pCountMap.ContainsKey(c)) pCountMap[c] = 0;
            pCountMap[c] += 1;
        }
        int i = 0;
        int j = 0;
        List<int> ans = new List<int>();
        while (j < s.Length) {
            // First, expand the window by adding s[j]
            char currChar = s[j];
            if (!currCountMap.ContainsKey(currChar)) currCountMap[currChar] = 0;
            currCountMap[currChar] += 1;
            j++;

            // Then, if window size exceeds p.Length, shrink from the left
            if (j - i > p.Length) {
                char headChar = s[i];
                currCountMap[headChar] -= 1;
                if (currCountMap[headChar] <= 0) currCountMap.Remove(headChar);
                i++;
            }

            // Check if current window matches
            if (j - i == p.Length && CheckCurrCountMap(currCountMap, pCountMap) == 0) {
                ans.Add(i);
            }
        }


        return ans;
    }

    // -1, not enough chars to satisfy pCountMap - move right
    // 0, match - move right
    // 1, too many char or unnecessary char to satifsy pCountMap - move left
    public int CheckCurrCountMap(
        Dictionary<char, int> currCountMap,
        Dictionary<char, int> pCountMap) {
            foreach(var (k, v) in pCountMap) {
                if (!currCountMap.ContainsKey(k)) return -1;
                if (currCountMap[k] < v) return -1;
                if (currCountMap[k] > v) return 1;
            }

            foreach(var (k, v) in currCountMap) {
                if (!pCountMap.ContainsKey(k)) return 1;
            }

            return 0;
    }
}
