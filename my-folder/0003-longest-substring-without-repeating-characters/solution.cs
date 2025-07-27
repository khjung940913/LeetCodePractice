public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int left = 0;
        int right = 0;
        var usedChars = new HashSet<char>();
        int ans = 0;
        while (right < s.Length) {
            while(usedChars.Contains(s[right])) {
                usedChars.Remove(s[left]);
                left++;
            }
            ans = Math.Max(ans, right - left + 1);
            usedChars.Add(s[right]);
            right++;
        }
        return ans;
    }
}
