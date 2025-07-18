public class is_plaindrome_valid {
    public Boolean is_palindrome_valid(String s) {
        // Write your code here
        String ss = "";
        for (Character c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                ss += c;
            }
        }

        int i = 0;
        int j = ss.length() - 1;
        while (i < j) {
            if (ss.charAt(i) != ss.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
