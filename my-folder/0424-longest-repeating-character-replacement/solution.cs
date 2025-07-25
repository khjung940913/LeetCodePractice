public class Solution {
    public int CharacterReplacement(string s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int maxOcc = 0;
        int[] occMap = new int[26];
        Array.Fill(occMap, 0);
        while (right < s.Length) {
            char currChar = s[right];
            occMap[currChar - 'A'] += 1;
            maxOcc = Math.Max(maxOcc, occMap[currChar - 'A']);
            int numbCharsToReplace = (right - left + 1) - maxOcc;
            if (numbCharsToReplace > k) {
                occMap[s[left] - 'A']-=1;
                left++;
            }
            ans = Math.Max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
