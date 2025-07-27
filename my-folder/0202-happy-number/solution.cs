public class Solution {
    public bool IsHappy(int n) {
        if (n == 1) return true;
        return IsHappy(GetNextNumber(n), GetNextNumber(GetNextNumber(n)));
    }

    public bool IsHappy(int n1, int n2) {
        if (n1 == 1 || n2 == 1) return true;
        if (n1 == n2) return false;
        return IsHappy(GetNextNumber(n1), GetNextNumber(GetNextNumber(n2)));
    }

    public int GetNextNumber(int n) {
        int ret = 0;
        while (n > 0) {
            int i = n % 10;
            ret += (i * i);
            n = n / 10;
        }
        return ret;
    }
}
